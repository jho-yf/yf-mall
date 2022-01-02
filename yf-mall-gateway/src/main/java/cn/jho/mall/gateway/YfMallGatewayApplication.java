package cn.jho.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-01-02 18:06
 */
@EnableDiscoveryClient
@SpringBootApplication
public class YfMallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(YfMallGatewayApplication.class, args);
    }

}
