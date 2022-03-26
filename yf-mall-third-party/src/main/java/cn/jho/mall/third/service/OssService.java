package cn.jho.mall.third.service;

import cn.jho.mall.third.data.vo.OssPolicyVO;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-26 19:39
 */
public interface OssService {

    /**
     * 获取OSS签名
     *
     * @return {@link OssPolicyVO}
     */
    OssPolicyVO getPolicy();

}
