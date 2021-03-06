package cn.jho.mall.product.service.impl;

import cn.jho.common.constant.ProductConst.AttrTypeEnum;
import cn.jho.common.utils.PageUtils;
import cn.jho.common.utils.Query;
import cn.jho.mall.product.dao.AttrAttrgroupRelationDao;
import cn.jho.mall.product.dao.AttrDao;
import cn.jho.mall.product.dao.AttrGroupDao;
import cn.jho.mall.product.dao.CategoryDao;
import cn.jho.mall.product.entity.AttrAttrgroupRelationEntity;
import cn.jho.mall.product.entity.AttrEntity;
import cn.jho.mall.product.entity.AttrGroupEntity;
import cn.jho.mall.product.entity.CategoryEntity;
import cn.jho.mall.product.service.AttrService;
import cn.jho.mall.product.service.CategoryService;
import cn.jho.mall.product.vo.AttrGroupRelationVO;
import cn.jho.mall.product.vo.AttrRespVO;
import cn.jho.mall.product.vo.AttrVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @author JHO
 */
@Service("attrService")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    private final AttrAttrgroupRelationDao relationDao;

    private final AttrGroupDao attrGroupDao;

    private final CategoryDao categoryDao;

    private final CategoryService categoryService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(AttrVO vo) {
        AttrEntity entity = new AttrEntity();
        BeanUtils.copyProperties(vo, entity);
        // ??????????????????
        this.save(entity);

        if (vo.getAttrType() == AttrTypeEnum.ATTR_TYPE_BASE.getCode() && vo.getAttrGroupId() != null) {
            // ????????????(1)???????????????????????????(0)????????????
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            relationEntity.setAttrId(entity.getAttrId());
            relationEntity.setAttrGroupId(vo.getAttrGroupId());
            relationDao.insert(relationEntity);
        }

    }

    @Override
    public PageUtils queryAttrPage(Map<String, Object> params, Long catelogId, String attrType) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("attr_type", AttrTypeEnum.getAttrTypeCodeByName(attrType))
                .or()
                // ????????????????????????????????????????????????
                .eq("attr_type", AttrTypeEnum.ATTR_TYPE_BOTH.getCode());
        if (catelogId != 0) {
            queryWrapper.eq("catelog_id", catelogId);
        }

        String key = (String) params.get("key");
        if (StringUtils.hasLength(key)) {
            queryWrapper.and(wrapper -> wrapper.eq("attr_id", key).or().like("attr_name", key));
        }

        IPage<AttrEntity> page = this.page(new Query<AttrEntity>().getPage(params),
                queryWrapper);
        PageUtils pageUtils = new PageUtils(page);
        List<AttrEntity> records = page.getRecords();
        List<AttrRespVO> data = records.stream().map(entity -> {
            AttrRespVO vo = new AttrRespVO();
            BeanUtils.copyProperties(entity, vo);

            // ??????????????????
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = null;
            if (AttrTypeEnum.ATTR_TYPE_BASE.getName().equalsIgnoreCase(attrType)
                    || AttrTypeEnum.ATTR_TYPE_BOTH.getName().equalsIgnoreCase(attrType)) {
                // ???????????????????????????????????????????????????
                attrAttrgroupRelationEntity = relationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>()
                                .eq("attr_id", entity.getAttrId()));
            }

            if (attrAttrgroupRelationEntity != null) {
                AttrGroupEntity attrGroup = attrGroupDao.selectById(attrAttrgroupRelationEntity.getAttrGroupId());
                vo.setGroupName(attrGroup.getAttrGroupName());
            }

            // ????????????id
            CategoryEntity category = categoryDao.selectById(entity.getCatelogId());
            if (category != null) {
                vo.setCatelogName(category.getName());
            }
            return vo;
        }).collect(Collectors.toList());

        pageUtils.setList(data);
        return pageUtils;
    }

    @Override
    public AttrRespVO getAttrInfo(Long attrId) {
        AttrEntity entity = this.getById(attrId);
        AttrRespVO vo = new AttrRespVO();
        BeanUtils.copyProperties(entity, vo);

        // ??????????????????id
        AttrAttrgroupRelationEntity relationEntity = null;
        if (entity.getAttrType().equals(AttrTypeEnum.ATTR_TYPE_BASE.getCode())) {
            // ???????????????????????????????????????????????????
            relationEntity = relationDao.selectOne(
                    new QueryWrapper<AttrAttrgroupRelationEntity>()
                            .eq("attr_id", attrId));
        }
        if (relationEntity != null) {
            vo.setAttrGroupId(relationEntity.getAttrGroupId());
            AttrGroupEntity attrGroup = attrGroupDao.selectById(relationEntity.getAttrGroupId());
            vo.setGroupName(attrGroup.getAttrGroupName());
        }

        Long catelogId = entity.getCatelogId();
        vo.setCatelogPath(categoryService.findCategoryPath(catelogId));

        CategoryEntity categoryEntity = categoryService.getById(catelogId);
        if (categoryEntity != null) {
            vo.setCatelogName(categoryEntity.getName());
        }
        return vo;
    }

    @Override
    public void updateAttr(AttrVO attr) {
        AttrEntity entity = new AttrEntity();
        BeanUtils.copyProperties(attr, entity);
        this.updateById(entity);

        if (attr.getAttrType().equals(AttrTypeEnum.ATTR_TYPE_BASE.getCode()) && attr.getAttrGroupId() != null) {
            // ???????????????????????????????????????????????????
            // ????????????
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            relationEntity.setAttrGroupId(attr.getAttrGroupId());
            relationEntity.setAttrId(attr.getAttrId());

            Long count = relationDao.selectCount(
                    new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attr.getAttrId()));
            if (count > 0) {
                relationDao.update(relationEntity,
                        new UpdateWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attr.getAttrId()));
            } else {
                relationDao.insert(relationEntity);
            }
        }

    }

    @Override
    public List<AttrEntity> getRelationAttr(long attrGroupId) {
        return this.getRelationAttr(attrGroupId, null);
    }

    @Override
    public List<AttrEntity> getRelationAttr(long attrGroupId, Integer attrType) {
        List<AttrAttrgroupRelationEntity> relationEntities = relationDao.selectList(new QueryWrapper<AttrAttrgroupRelationEntity>()
                .eq("attr_group_id", attrGroupId));
        List<Long> attrIds = relationEntities.stream()
                .map(AttrAttrgroupRelationEntity::getAttrId)
                .collect(Collectors.toList());
        if (attrIds.isEmpty()) {
            return Collections.emptyList();
        }
        return this.baseMapper.selectList(new QueryWrapper<AttrEntity>()
                .in("attr_id", attrIds)
                .eq(attrType != null, "attr_type", attrType));
    }

    @Override
    public PageUtils getNoRelationAttr(Long attrGroupId, Map<String, Object> params) {
        // ???????????????????????????????????????????????????????????????????????????
        AttrGroupEntity attrGroup = attrGroupDao.selectById(attrGroupId);
        QueryWrapper<AttrGroupEntity> queryWrapper = new QueryWrapper<AttrGroupEntity>()
                .eq("catelog_id", attrGroup.getCatelogId());
        List<AttrGroupEntity> attrGroups = attrGroupDao.selectList(queryWrapper);
        Set<Long> attrGroupIds = attrGroups.stream().map(AttrGroupEntity::getAttrGroupId).collect(Collectors.toSet());

        // ????????????????????????????????????id
        List<AttrAttrgroupRelationEntity> relationEntities = relationDao.selectList(
                new QueryWrapper<AttrAttrgroupRelationEntity>()
                        .in(!attrGroupIds.isEmpty(), "attr_group_id", attrGroupIds));
        Set<Long> attrIds = relationEntities.stream().map(AttrAttrgroupRelationEntity::getAttrId).collect(Collectors.toSet());

        // ?????????????????????????????????????????????
        QueryWrapper<AttrEntity> attrQueryWrapper = new QueryWrapper<AttrEntity>()
                .eq("attr_type", AttrTypeEnum.ATTR_TYPE_BASE.getCode())
                .eq("catelog_id", attrGroup.getCatelogId())
                .notIn(!attrIds.isEmpty(), "attr_id", attrIds);
        // ???????????????
        String key = (String) params.get("key");
        if (StringUtils.hasLength(key)) {
            attrQueryWrapper.and(w -> w.eq("id", key).or().like("attr_name", key));
        }
        IPage<AttrEntity> page = this.page(new Query<AttrEntity>().getPage(params), attrQueryWrapper);
        return new PageUtils(page);
    }

    @Override
    public void deleteRelation(List<AttrGroupRelationVO> relationVOList) {
        QueryWrapper<AttrAttrgroupRelationEntity> queryWrapper = new QueryWrapper<>();
        for (AttrGroupRelationVO vo : relationVOList) {
            queryWrapper.or(wrapper ->
                    wrapper.eq("attr_id", vo.getAttrId())
                    .eq("attr_group_id", vo.getAttrGroupId()));
        }
        relationDao.delete(queryWrapper);
    }

}