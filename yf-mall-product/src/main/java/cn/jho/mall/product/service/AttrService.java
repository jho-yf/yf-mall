package cn.jho.mall.product.service;

import cn.jho.mall.product.vo.AttrGroupRelationVO;
import cn.jho.mall.product.vo.AttrRespVO;
import cn.jho.mall.product.vo.AttrVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.jho.common.utils.PageUtils;
import cn.jho.mall.product.entity.AttrEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2021-12-27 14:18:07
 */
public interface AttrService extends IService<AttrEntity> {

    /**
     * 按条件分页查询商品属性
     *
     * @param params 查询参数
     * @return {@link PageUtils}
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存商品属性
     *
     * @param vo {@link AttrVO}
     */
    void save(AttrVO vo);

    /**
     * 根据参数条件和分类id分页查找属性
     *
     * @param params 查询参数
     * @param catelogId 分类id
     * @param attrType 属性类型
     * @return {@link PageUtils}
     */
    PageUtils queryAttrPage(Map<String, Object> params, Long catelogId, String attrType);

    /**
     * 根据属性id获取{@link AttrRespVO}对象
     *
     * @param attrId 属性id
     * @return {@link AttrRespVO}
     */
    AttrRespVO getAttrInfo(Long attrId);

    /**
     * 更新属性信息
     *
     * @param attr {@link AttrVO}
     */
    void updateAttr(AttrVO attr);

    /**
     * 根据属性分组id获取属性列表
     *
     * @param attrGroupId 属性分组id
     * @return {@link List<AttrEntity>}
     */
    List<AttrEntity> getRelationAttr(long attrGroupId);


    /**
     * 根据属性分组id获取属性列表
     *
     * @param attrGroupId 属性分组id
     * @param attrType 属性类型
     * @return {@link List<AttrEntity>}
     */
    List<AttrEntity> getRelationAttr(long attrGroupId, Integer attrType);

    /**
     * 获取没有与属性分组关联的所有属性
     *  1. 只关联属性分组所属分类下的属性
     *  2. 只关联没有其他属性分组关联的属性
     *  3. 基本属性（即attr_type=0才需要关联分组），销售属性（即attr_type=1不需要关联分组）
     *
     * @param attrGroupId 属性分组id
     * @param params 查询参数
     * @return {@link PageUtils} 分页对象
     */
    PageUtils getNoRelationAttr(Long attrGroupId, Map<String, Object> params);

    /**
     * 删除属性和属性分组关联
     *
     * @param relationVOList 属性和属性分组关联的视图对象列表
     */
    void deleteRelation(List<AttrGroupRelationVO> relationVOList);

}

