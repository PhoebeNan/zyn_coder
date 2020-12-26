package com.zyn.dao;

import com.zyn.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author zyn
 * @create 2020/12/26 15:15
 * @Description
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
