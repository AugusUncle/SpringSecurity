package com.cb.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.cb.domain.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author cuibing
* @description 针对表【sys_user_role(用户和角色关联表)】的数据库操作Mapper
* @createDate 2024-06-21 14:48:19
* @Entity com.cb.domain.SysUserRole
*/
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    List<SysUserRole> findAllByUserId(@Param("userId") Long userId);

}




