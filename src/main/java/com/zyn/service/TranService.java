package com.zyn.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zyn.mapper.AMapper;
import com.zyn.mapper.BMapper;
import com.zyn.mapper.CMapper;
import com.zyn.mapper.DMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 赵亚楠
 * @create 2020/11/28 9:40
 * @Description
 */
@Component
public class TranService {

    @Autowired
    AMapper aMapper;

    @Autowired
    BMapper bMapper;

    @Autowired
    CMapper cMapper;

    @Autowired
    DMapper dMapper;


    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @DS("master")
    public void a() {


        aMapper.insert1();

        System.out.println("*********");

        dMapper.insert4();
//
//        int i =1/0;


    }



    //一定要把@Transactional设置为Propagation.REQUIRES_NEW，这样在调用另一个事务方法时，TransactionInterceptor 会将原事务挂起，暂时性的将原事务信息和当前线程解绑。
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @DS("t_pk")
    public void b() {
        bMapper.insert1();

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @DS("t_card")
    public void c() {
        cMapper.insert1();

    }
}
