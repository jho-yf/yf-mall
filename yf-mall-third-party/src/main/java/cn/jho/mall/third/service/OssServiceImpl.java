package cn.jho.mall.third.service;

import cn.jho.mall.third.data.vo.OssPolicyVO;
import cn.jho.mall.third.properties.YfOssProperties;
import cn.jho.mall.third.utils.ExpireTimeUtils;
import com.alibaba.alicloud.context.AliCloudProperties;
import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-26 19:40
 */
@Service
public class OssServiceImpl implements OssService {

    private final OSS ossClient;

    private final AliCloudProperties aliCloudProperties;

    private final YfOssProperties yfOssProperties;

    public OssServiceImpl(OSS ossClient,
                          AliCloudProperties aliCloudProperties,
                          YfOssProperties yfOssProperties) {
        this.ossClient = ossClient;
        this.aliCloudProperties = aliCloudProperties;
        this.yfOssProperties = yfOssProperties;
    }

    @Override
    public OssPolicyVO getPolicy() {
        // 用户上传文件时指定的前缀（文件所在文件夹）
        String dirName = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "/";
        PolicyConditions conditions = new PolicyConditions();
        // PostObject请求最大可支持的文件大小为5GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024
        long maxSize = 5 * 1024 * 1024L;
        conditions.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, maxSize);
        conditions.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dirName);

        Date expireTime = ExpireTimeUtils.getExpireTime(30);
        String postPolicy = ossClient.generatePostPolicy(expireTime, conditions);
        byte[] binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String signature = ossClient.calculatePostSignature(postPolicy);
        return new OssPolicyVO(aliCloudProperties.getAccessKey(), encodedPolicy, signature, dirName, yfOssProperties.getHost(), expireTime);
    }
}
