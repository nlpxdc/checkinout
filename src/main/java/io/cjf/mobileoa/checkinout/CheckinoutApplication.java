package io.cjf.mobileoa.checkinout;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.cjf.mobileoa.checkinout.dao")
public class CheckinoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckinoutApplication.class, args);
    }

}

