//package com.test.UnitTestApp.services;
//
//import org.junit.*;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import services.CalculatorService;
//
//import java.util.Date;
//
//public class CalculatorServiceTest {
////    @BeforeClass
////    public static void init(){
////        System.out.println("Test cases are started executing at "+new Date());
////    }
//    @BeforeEach
//    public void beforeEach(){
//        System.out.println("before each test time"+new Date());
//
//    }
////    @Before
////    public void beforeEach(){
////        System.out.println("before each test time"+new Date());
////
////    }
//
//    @Test()
//    public void sumTest(){
//        System.out.println("Test for sum ");
//        int result=CalculatorService.sum(10,12);
//        int expected=22;
//        Assert.assertEquals(expected,result);
//    }
//    @Test
//    public void productTest(){
//        System.out.println("Test for product ");
//        int result=CalculatorService.product(2,4);
////        Assert.assertEquals(result,6);
//        Assert.assertEquals(result,8);
//    }
////    @AfterClass
////    public static void cleanup(){
////        System.out.println("Test cases execution is finished at"+new Date());
////    }
//    @AfterEach
//    public void afterEach(){
//        System.out.println("after each Test time"+new Date());
//    }
////    @After
////    public void afterEach(){
////        System.out.println("after each Test time"+new Date());
////    }
//}
