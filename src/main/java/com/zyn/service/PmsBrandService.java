package com.zyn.service;

import com.zyn.mbg.model.PmsBrand;

import java.util.List;

/**
 * @Author 赵亚楠
 * @create 2020/12/19 15:22
 * @Description
 */
public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
