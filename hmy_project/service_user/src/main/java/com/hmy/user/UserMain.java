package com.hmy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.hmy.user.feign")
@ComponentScan(basePackages = {"com.plxcc.servicebase.config","com.hmy.user"})
public class UserMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(UserMain.class,args);
    }
}
