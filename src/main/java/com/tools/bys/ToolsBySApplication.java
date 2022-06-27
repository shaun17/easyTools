package com.tools.bys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.tools.bys"})
@MapperScan("com.tools.bys.biz.generator.mapper")
@EnableAsync
public class ToolsBySApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ToolsBySApplication.class, args);
    }
}
