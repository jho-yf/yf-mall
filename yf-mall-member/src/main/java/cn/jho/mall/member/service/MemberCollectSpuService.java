package cn.jho.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.jho.common.utils.PageUtils;
import cn.jho.mall.member.entity.MemberCollectSpuEntity;

import java.util.Map;

/**
 * 会员收藏的商品
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2022-01-01 11:22:18
 */
public interface MemberCollectSpuService extends IService<MemberCollectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

