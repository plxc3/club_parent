package com.plxcc.center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


/**
 * @PackgeName: com.plxcc.center
 * @ClassName: CenterApplication
 * @Author: plxc
 * Date: 2020/8/7 19:41
 * project name: club_parent
 * @Version:
 * @Description:
 */
@SpringBootApplication
@ComponentScan("com.plxcc")
@MapperScan("com.plxcc.center.mapper")
public class CenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CenterApplication.class,args);
    }
}
