package cn.jho.mall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-01-01 11:50
 */
@MapperScan("cn.jho.mall.ware.dao")
@SpringBootApplication
public class YfMallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(YfMallWareApplication.class, args);
    }

}
