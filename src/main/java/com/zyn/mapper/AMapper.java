package com.zyn.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zyn.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Author 赵亚楠
 * @create 2020/9/14 19:10
 * @Description
 */
@Mapper
public interface AMapper {


    @Insert("INSERT INTO a(id, name, age) VALUES (1, \"zyn\", \"18\")")
    int insert1();


}
