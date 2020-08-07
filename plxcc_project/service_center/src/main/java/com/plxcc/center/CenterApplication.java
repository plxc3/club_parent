package com.plxcc.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("com.plxcc")
public class CenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CenterApplication.class,args);
    }
}
