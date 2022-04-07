package cn.jho.mall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-01-01 11:25
 */
@EnableDiscoveryClient
@SpringBootApplication
public class YfMallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(YfMallMemberApplication.class, args);
    }

}
