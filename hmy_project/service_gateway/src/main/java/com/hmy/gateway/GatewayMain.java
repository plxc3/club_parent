package com.hmy.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.hmy"})
public class GatewayMain
{
    public static void main(String[] args)
    {
        SpringApplication.run(GatewayMain.class,args);
    }
}
