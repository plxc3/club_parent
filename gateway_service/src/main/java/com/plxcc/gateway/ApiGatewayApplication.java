package com.plxcc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackgeName: com.plxcc.gateway
 * @ClassName: ApiGatewayApplication
 * @Author: plxc
 * Date: 2020/8/8 9:15
 * project name: club_parent
 * @Version:
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}