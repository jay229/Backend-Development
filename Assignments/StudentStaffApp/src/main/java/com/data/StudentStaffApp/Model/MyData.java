package com.data.StudentStaffApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyData {
    private int id;
    private String student_name;
    private String student_address;
    private String student_class;
    private String coordinator_name;
    private String teacher_name;
    private String coordinator_address;
    private String teacher_address;

}
