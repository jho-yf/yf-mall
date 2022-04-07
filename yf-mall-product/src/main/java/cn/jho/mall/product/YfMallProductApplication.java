package cn.jho.mall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2021-12-27 14:21
 */
@EnableDiscoveryClient
@SpringBootApplication
public class YfMallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(YfMallProductApplication.class, args);
    }

}
