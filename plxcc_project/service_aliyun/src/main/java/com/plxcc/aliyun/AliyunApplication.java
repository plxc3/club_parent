package com.plxcc.aliyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @PackgeName: com.plxcc.aliyun
 * @ClassName: AliyunApplication
 * @Author: plxc
 * Date: 2020/8/7 22:37
 * project name: club_parent
 * @Version:
 * @Description:
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.plxcc")
//开启服务调用
@EnableFeignClients
public class AliyunApplication {
    public static void main(String[] args) {
        SpringApplication.run(AliyunApplication.class,args);
    }
}
