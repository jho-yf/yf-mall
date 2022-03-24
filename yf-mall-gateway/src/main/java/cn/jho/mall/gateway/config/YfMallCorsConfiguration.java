package cn.jho.mall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * 跨域配置
 *
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-20 11:23
 */
@Configuration
public class YfMallCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许所有请求头跨域
        corsConfiguration.addAllowedHeader("*");
        // 允许所有请求方法跨域
        corsConfiguration.addAllowedMethod("*");
        // 允许所有请求来源跨域
        corsConfiguration.addAllowedOrigin("*");
        // 允许客户端携带验证信息(如：cookie)
        corsConfiguration.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(source);
    }

}
