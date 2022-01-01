package cn.jho.mall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-01-01 11:40
 */
@MapperScan("cn.jho.mall.order.dao")
@SpringBootApplication
public class YfMallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(YfMallOrderApplication.class, args);
    }

}
