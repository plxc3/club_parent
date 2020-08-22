package com.plxcc.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @PackgeName: com.plxcc.admin
 * @ClassName: AcmApplication
 * @Author: plxc
 * Date: 2020/8/16 16:03
 * project name: club_parent
 * @Version:
 * @Description:
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.plxcc.admin.mapper")
@ComponentScan(basePackages = {"com.plxcc","com.plxcc.admin"})
public class AcmApplication {
    public static void main(String[] args) {
        SpringApplication.run(AcmApplication.class,args);
    }
}
