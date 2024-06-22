package com.cb.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cb.domain.SysUserRole;
import com.cb.service.SysUserRoleService;
import com.cb.mapper.SysUserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author cuibing
* @description 针对表【sys_user_role(用户和角色关联表)】的数据库操作Service实现
* @createDate 2024-06-21 14:48:19
*/
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
    implements SysUserRoleService{

}




