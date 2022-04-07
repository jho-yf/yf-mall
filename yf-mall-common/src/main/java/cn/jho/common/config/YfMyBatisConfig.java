package cn.jho.common.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis配置类
 *
 * @author JHO xu-jihong@qq.com
 * @date 2022-04-07 19:52
 */
@Configuration
@EnableTransactionManagement
@MapperScan("cn.jho.mall.*.dao")
@ConditionalOnClass(PaginationInnerInterceptor.class)
public class YfMyBatisConfig {

    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor();
        // 设置请求的页面大于最后一页操作，true回到首页，false继续请求
        interceptor.setOverflow(true);
        return interceptor;
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(PaginationInnerInterceptor paginationInnerInterceptor) {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }

}
