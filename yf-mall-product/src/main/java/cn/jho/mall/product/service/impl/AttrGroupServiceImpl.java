package cn.jho.mall.product.service.impl;

import cn.jho.common.constant.ProductConst;
import cn.jho.common.utils.PageUtils;
import cn.jho.common.utils.Query;
import cn.jho.mall.product.dao.AttrGroupDao;
import cn.jho.mall.product.entity.AttrGroupEntity;
import cn.jho.mall.product.service.AttrGroupService;
import cn.jho.mall.product.service.AttrService;
import cn.jho.mall.product.vo.AttrGroupWithAttrsVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author JHO
 */
@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    private AttrService attrService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long categoryId) {
        String key = (String) params.get("key");
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)) {
            wrapper.and(obj -> obj.eq("attr_group_id", key).or().like("attr_group_name", key));
        }

        if (categoryId != null && categoryId != 0) {
            wrapper.and(obj -> obj.eq("catelog_id", categoryId));
        }
        IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), wrapper);
        return new PageUtils(page);
    }

    @Override
    public List<AttrGroupWithAttrsVO> getAttrGroupWithAttrsByCatelogId(Long catelogId) {
        List<AttrGroupEntity> attrGroups = this.list(
                new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));
        return attrGroups.stream().map(entity -> {
            AttrGroupWithAttrsVO vo = new AttrGroupWithAttrsVO();
            BeanUtils.copyProperties(entity, vo);
            // 只展示基本属性
            vo.setAttrs(attrService.getRelationAttr(entity.getAttrGroupId(),
                    ProductConst.AttrTypeEnum.ATTR_TYPE_BASE.getCode()));
            return vo;
        }).collect(Collectors.toList());
    }

}