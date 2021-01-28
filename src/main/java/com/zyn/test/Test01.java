package com.zyn.test;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 赵亚楠
 * @create 2020/11/27 15:59
 * @Description
 */
public class Test01 {


    public static void main(String[] args) {


//       Map<String, List<String>> map = new HashMap<>();
//
//
//       map.put(null,null);
//
//        List<String> list = map.get("zyn");
//        if (CollectionUtils.isEmpty(list)){
//            list = new ArrayList<>();
//            map.put("zyn",list);
//        }
//
//        System.out.println("======");

        Map<String, Object> map = new HashMap<>();
        String o = (String)map.get("zyn");


    }




}



