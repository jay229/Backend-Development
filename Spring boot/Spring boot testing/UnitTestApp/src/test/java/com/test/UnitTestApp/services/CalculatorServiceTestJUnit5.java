package com.test.UnitTestApp.services;

import org.junit.jupiter.api.*;
import services.CalculatorService;

import java.util.Date;

public class CalculatorServiceTestJUnit5 {
    @BeforeAll
    public static void init(){
        System.out.println("test cases are started executing at "+new Date());
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("Before each method");
    }
    @Test
    public void sumTest(){
        System.out.println("Sum test...");
        int result=CalculatorService.sum(10,12);
        int expected=22;
        Assertions.assertEquals(result,expected);
    }
    @AfterAll
    public static void cleanUp(){
        System.out.println("Test cases are finished executing at "+new Date());
    }
    @AfterEach
    public void afterEach(){
        System.out.println("After each method");
    }
}
