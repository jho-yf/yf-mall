package cn.jho.mall.product.service;

import cn.jho.mall.product.vo.AttrGroupRelationVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.jho.common.utils.PageUtils;
import cn.jho.mall.product.entity.AttrAttrgroupRelationEntity;

import java.util.List;
import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author jho
 * @email xujihong.yif@gmail.com
 * @date 2021-12-27 14:18:07
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    /**
     * 按条件分页查询属性-分组关联关系
     *
     * @param params 查询参数
     * @return {@link PageUtils}
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 批量保存属性-分组关联
     * @param vos 属性-分组关联视图对象 {@link List<AttrGroupRelationVO>}
     */
    void saveBatch(List<AttrGroupRelationVO> vos);
}

