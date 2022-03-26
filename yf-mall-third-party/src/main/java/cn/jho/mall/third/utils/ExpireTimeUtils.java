package cn.jho.mall.third.utils;

import java.util.Date;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-26 20:11
 */
public class ExpireTimeUtils {

    public static Date getExpireTime(int second) {
        return new Date(System.currentTimeMillis() + second * 1000L);
    }

}
