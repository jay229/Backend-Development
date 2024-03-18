package com.data.StudentStaffApp.service;

import com.data.StudentStaffApp.Model.MyData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    DataSource dataSource;
    public List<MyData> fetchAndStoreData() throws IOException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String query=" SELECT\n" +
                "    s.id AS student_id,\n" +
                "    s.name AS student_name,\n" +
                "    s.address AS student_address,\n" +
                "    s.class,\n" +
                "    c.name AS coordinator_name,\n" +
                "    t.name AS teacher_name,\n" +
                "    c.address AS coordinator_address,\n" +
                "    t.address AS teacher_address\n" +
                "FROM\n" +
                "    student s\n" +
                "LEFT JOIN\n" +
                "    staff c ON s.coordinator_id = c.id\n" +
                "LEFT JOIN\n" +
                "    staff t ON s.teacher_id = t.id;";
        List<MyData> dataList = jdbcTemplate.query(query, (rs, rowNum) -> {
            MyData data = new MyData();
            data.setId(rs.getInt("student_id"));
            data.setStudent_name(rs.getString("student_name"));
            data.setStudent_address(rs.getString("student_address"));
            data.setStudent_class(rs.getString("class"));
            data.setCoordinator_name(rs.getString("coordinator_name"));
            data.setTeacher_name(rs.getString("teacher_name"));
            data.setCoordinator_address(rs.getString("coordinator_address"));
            data.setTeacher_address(rs.getString("teacher_address"));

            return data;
        });
        return dataList;
    }
    public void writeDataToJson(List<MyData> dataList){
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("data.json");
            mapper.writeValue(file, dataList);
            System.out.println("Data has been written to data.json");
        }
        catch (IOException e){
            System.err.println("Error writing JSON file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
