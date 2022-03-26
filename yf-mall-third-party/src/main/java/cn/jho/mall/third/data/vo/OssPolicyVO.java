package cn.jho.mall.third.data.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-26 21:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OssPolicyVO {

    private String accessId;

    private String policy;

    private String signature;

    private String dir;

    private String host;

    private Date expireTime;

}
