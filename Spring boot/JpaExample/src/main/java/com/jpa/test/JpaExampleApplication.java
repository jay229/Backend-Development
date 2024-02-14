package com.jpa.test;

import com.jpa.test.entities.User;
import com.jpa.test.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class JpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(JpaExampleApplication.class, args);
		UserRepository userRepository=context.getBean(UserRepository.class);

//		Create user and save in database
//		User user1=new User();
//		user1.setName("Mritunjay kumar tiwari ");
//		user1.setStatus("I'm a Software development engineer");
//
//		System.out.println(userRepository.save(user1));

//		Create multiple users and save all in database at once
//		User user1=new User();
//		user1.setName("Sharmila kumari ");
//		user1.setStatus("I'm a Java developer");
//
//		User user2=new User();
//		user2.setName("Hitesh kumar");
//		user2.setStatus("I'm a Java developer");
//
//		List<User> users=List.of(user1,user2);
//
//		List<User> userList= (List<User>) userRepository.saveAll(users);
//		userList.forEach((user -> System.out.println(user)));



//		get particular user by id
//		User user=userRepository.findById(153).get();
//		System.out.println(user);


//		get all users from database

//		List<User> users=(List<User>) userRepository.findAll();
//		users.forEach((user-> System.out.println(user)));

//		delete particular user from DB
//		System.out.println("Before deletion");
//		List<User> users=(List<User>) userRepository.findAll();
//		users.forEach((user-> System.out.println(user)));
//
//		userRepository.deleteById(153);
//
//		System.out.println("after deletion");
//
//		List<User> userList=(List<User>) userRepository.findAll();
//		userList.forEach((user-> System.out.println(user)));




//		update particular user
//		User user=userRepository.findById(102).get();
//		System.out.println(user);
//		user.setName("Mritunjay");
//
//		System.out.println(userRepository.save(user));

//		delete all users from db
		System.out.println("Before deletion");
		List<User> userList=(List<User>) userRepository.findAll();
		userList.forEach((user-> System.out.println(user)));

		userRepository.deleteAll(userList);


	}

}
