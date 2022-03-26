package cn.jho.mall.third.controller;

import cn.jho.common.utils.R;
import cn.jho.mall.third.service.OssService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JHO xu-jihong@qq.com
 * @date 2022-03-26 19:22
 */
@RestController
@RequestMapping("/oss")
public class OssController {

    private final OssService ossService;

    public OssController(OssService ossService) {
        this.ossService = ossService;
    }

    @GetMapping("/policy")
    public R getPolicy() {
        return R.ok().put("data", ossService.getPolicy());
    }

}
