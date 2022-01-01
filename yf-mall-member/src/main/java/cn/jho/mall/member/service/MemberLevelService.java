package cn.jho.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.jho.common.utils.PageUtils;
import cn.jho.mall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2022-01-01 11:22:18
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

