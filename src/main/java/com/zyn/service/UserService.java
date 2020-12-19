package com.zyn.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zyn.mapper.AMapper;
import com.zyn.mapper.BMapper;
import com.zyn.mapper.CMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

;

/**
 * @Author 赵亚楠
 * @create 2020/11/5 17:10
 * @Description
 */
@Service
public class UserService {


    @Autowired
    TranService tranService;


    public void insert() {

        tranService.a();

        tranService.b();

        tranService.c();
    }



}
