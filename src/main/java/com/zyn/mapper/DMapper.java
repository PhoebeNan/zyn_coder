package com.zyn.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 赵亚楠
 * @create 2020/9/14 19:10
 * @Description
 */
@Mapper
public interface DMapper {


    @Insert("INSERT INTO d(id, name, age) VALUES (1, \"zyn\", \"18\")")
    int insert4();


}
