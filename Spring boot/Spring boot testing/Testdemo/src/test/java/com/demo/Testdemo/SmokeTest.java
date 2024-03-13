package com.demo.Testdemo;

import com.demo.Testdemo.controllers.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class SmokeTest {
    @Autowired
    HomeController homeController;

    @Test
    void contextLoads() throws Exception{
        assertThat(homeController).isNotNull();
    }
}
