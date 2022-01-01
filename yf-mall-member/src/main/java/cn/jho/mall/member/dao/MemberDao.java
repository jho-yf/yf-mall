package cn.jho.mall.member.dao;

import cn.jho.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2022-01-01 11:22:18
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
