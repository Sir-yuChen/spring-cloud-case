package com.zy.cloud;

import com.zy.cloud.consumer.config.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Administrator
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
//name为生产者服务的服务名称  configuration为配置类的类名
@RibbonClient(name = "CLOUD-CASE-PRODUCE", configuration = MyselfRule.class)
public class CloudCaseConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudCaseConsumerApplication.class, args);
        System.out.println("springCloud Consumer start !!!");
    }
    /**
     *  启动：Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured
     *     导入数据库连接包，未配置信息
     *    解决：
     *     @SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
     *     启动不加连接数据库
     *
     */


}
