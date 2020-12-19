package com.zyn.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @Author 赵亚楠
 * @create 2020/12/19 15:44
 * @Description
 */
@Data
public class CommonPage<T> {

    private Integer pageNum; //当前页
    private Integer pageSize; //每页的数量
    private Integer totalPage; //总页数
    private Long total; //总记录数
    private List<T> list; // 结果集

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }
}
