package cn.jho.mall.product;

import cn.jho.mall.product.entity.BrandEntity;
import cn.jho.mall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2021-12-28 20:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class YfMallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    public void testSave() {
        BrandEntity brand = new BrandEntity();
        brand.setName("乙方");
        brandService.save(brand);
        log.info("【{}】保存成功", brand);
    }

    @Test
    public void testUpdate() {
        BrandEntity brand = new BrandEntity();
        brand.setBrandId(1L);
        brand.setName("乙方小弟");
        brandService.updateById(brand);
        log.info("【{}】更新成功", brand);
    }

    @Test
    public void testList() {
        // BrandEntity brandEntity = new BrandEntity();
        List<BrandEntity> brands = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        log.info("查询成功：{}", brands);
    }

}
