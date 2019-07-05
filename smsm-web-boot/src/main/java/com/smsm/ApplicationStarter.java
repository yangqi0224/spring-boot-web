package com.smsm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//自动注入，扫描service，controller等注解
@SpringBootApplication(scanBasePackages = "com.smsm")
//指定mapper接口的包名
@MapperScan(basePackages = "com.smsm.mapper")
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }

}
