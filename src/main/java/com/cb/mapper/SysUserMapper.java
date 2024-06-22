package com.cb.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.cb.domain.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author cuibing
* @description 针对表【sys_user(后台系统用户表)】的数据库操作Mapper
* @createDate 2024-06-21 14:48:19
* @Entity com.cb.domain.SysUser
*/
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findOneByUserName(@Param("userName") String userName);
}




