package cn.jho.mall.third;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-26 17:56
 */
@EnableDiscoveryClient
@SpringBootApplication
public class YfThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(YfThirdPartyApplication.class, args);
    }

}
