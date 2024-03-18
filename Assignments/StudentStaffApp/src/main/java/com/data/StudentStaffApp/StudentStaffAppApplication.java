package com.data.StudentStaffApp;

import com.data.StudentStaffApp.Model.MyData;
import com.data.StudentStaffApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentStaffAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentStaffAppApplication.class, args);


	}
	@Bean
	CommandLineRunner commandLineRunner(StudentService service){
		return args -> {

			List<MyData> dataList=service.fetchAndStoreData();
			service.writeDataToJson(dataList);
		};
	}

}
