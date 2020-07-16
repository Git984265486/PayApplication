package com.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 简单main函数，用于测试当面付api
 */
@SpringBootApplication
@MapperScan("com.example.Mapper")
@ServletComponentScan
public class Main {

    public static void main(String args[]){
        SpringApplication.run( Main.class , args );
        System.out.println("【启动成功！】");
    }

}
