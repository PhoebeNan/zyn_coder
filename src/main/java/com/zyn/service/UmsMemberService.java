package com.zyn.service;


import com.zyn.common.CommonResult;

/**
 * @Author zyn
 * @create 2020/12/21 9:29
 * @Description * 会员管理Service
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

}
