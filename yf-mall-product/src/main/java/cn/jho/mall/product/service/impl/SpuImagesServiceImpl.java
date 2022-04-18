package cn.jho.mall.product.service.impl;

import cn.jho.common.utils.PageUtils;
import cn.jho.common.utils.Query;
import cn.jho.mall.product.dao.SpuImagesDao;
import cn.jho.mall.product.entity.SpuImagesEntity;
import cn.jho.mall.product.service.SpuImagesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author JHO
 */
@Service("spuImagesService")
public class SpuImagesServiceImpl extends ServiceImpl<SpuImagesDao, SpuImagesEntity> implements SpuImagesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuImagesEntity> page = this.page(
                new Query<SpuImagesEntity>().getPage(params),
                new QueryWrapper<SpuImagesEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveImages(Long spuId, List<String> images) {
        if (images != null && !images.isEmpty()) {
            List<SpuImagesEntity> spuImagesEntities = images.stream().map(img -> {
                SpuImagesEntity entity = new SpuImagesEntity();
                entity.setSpuId(spuId);
                entity.setImgUrl(img);
                return entity;
            }).collect(Collectors.toList());
            this.saveBatch(spuImagesEntities);
        }
    }

}