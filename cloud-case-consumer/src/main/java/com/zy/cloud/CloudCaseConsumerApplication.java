package com.zy.cloud;

import com.zy.cloud.consumer.config.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Administrator
 */
//由于在common公共组件中导入了mysql连接包，所有的服务又要导入公共组件所有在启东时排除DataSourceAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableDiscoveryClient
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
