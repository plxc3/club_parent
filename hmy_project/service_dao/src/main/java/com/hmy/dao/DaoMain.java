package com.hmy.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.plxcc","com.hmy"})
@MapperScan("com.hmy.dao.mapper")
public class DaoMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(DaoMain.class,args);
    }
}
