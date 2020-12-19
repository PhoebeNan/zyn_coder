package com.zyn.controller;

/**
 * @Author 赵亚楠
 * @create 2020/12/19 15:21
 * @Description
 */

import com.zyn.common.CommonPage;
import com.zyn.common.CommonResult;
import com.zyn.mbg.model.PmsBrand;
import com.zyn.service.PmsBrandService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理Controller
 */
@Controller
@RequestMapping("/brand")
@Slf4j
public class PmsBrandController {

    @Autowired
    private PmsBrandService demoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    /**
     *
     *  查询所有品牌详情
     * @return
     */
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {

        List<PmsBrand> pmsBrands = demoService.listAllBrand();

        return CommonResult.success(pmsBrands);
    }

    /**
     *
     *  {
     *    "name":"zyn",
     *    "sort":"50"
     *  }
     *
     *  根据id新增品牌
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = demoService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.info("createBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.info("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    /**
     *  根据id更新品牌
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        CommonResult commonResult;
        int count = demoService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrandDto);
            LOGGER.info("updateBrand success:{}", pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.info("updateBrand failed:{}", pmsBrandDto);
        }
        return commonResult;
    }

    /**
     *  根据id删除品牌
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = demoService.deleteBrand(id);
        if (count == 1) {
            LOGGER.info("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.info("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    /**
     *  对品牌进行分页处理
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = demoService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    /**
     *  根据id获取品牌
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(demoService.getBrand(id));
    }
}
