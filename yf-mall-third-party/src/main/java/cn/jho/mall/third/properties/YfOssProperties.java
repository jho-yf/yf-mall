package cn.jho.mall.third.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-26 19:56
 */
@Data
@ConfigurationProperties("yf.third.oss")
public class YfOssProperties {

    private String bucket;

    private String host;

}
