package cn.jho.mall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-01-01 11:11
 */
@EnableDiscoveryClient
@MapperScan("cn.jho.mall.coupon.dao")
@SpringBootApplication
public class YfMallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(YfMallCouponApplication.class, args);
    }

}
