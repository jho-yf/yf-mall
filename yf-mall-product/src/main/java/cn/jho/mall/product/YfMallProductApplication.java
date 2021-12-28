package cn.jho.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2021-12-27 14:21
 */
@MapperScan("cn.jho.mall.product.dao")
@SpringBootApplication
public class YfMallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(YfMallProductApplication.class, args);
    }

}
