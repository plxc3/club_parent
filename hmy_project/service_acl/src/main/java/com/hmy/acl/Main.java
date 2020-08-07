package com.hmy.acl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.plxcc.servicebase","com.hmy.acl"})
public class Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class,args);
    }
}
