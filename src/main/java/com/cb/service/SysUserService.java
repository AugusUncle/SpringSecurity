package com.cb.service;

import com.cb.domain.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cb.domain.dto.RegisterDto;
import com.cb.domain.dto.UserDto;

/**
* @author cuibing
* @description 针对表【sys_user(后台系统用户表)】的数据库操作Service
* @createDate 2024-06-21 14:48:19
*/
public interface SysUserService  {


    /**
     * 注册
     * @param registerDto
     */
    void register(RegisterDto registerDto);

    /**
     * 根据账号获取用户
     * @param account
     * @return
     */
    UserDto getUserByUserName(String account);
}
