package cn.jho.mall.third.config;

import cn.jho.mall.third.properties.YfOssProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-26 19:59
 */
@Configuration
@EnableConfigurationProperties(YfOssProperties.class)
public class YfOssConfiguration {
}
