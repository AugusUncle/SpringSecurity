package com.cb.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cb.domain.SysRole;
import com.cb.service.SysRoleService;
import com.cb.mapper.SysRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author cuibing
* @description 针对表【sys_role(角色信息表)】的数据库操作Service实现
* @createDate 2024-06-21 14:48:18
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
    implements SysRoleService{

}




