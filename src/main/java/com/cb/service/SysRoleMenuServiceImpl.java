package com.cb.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cb.domain.SysRoleMenu;
import com.cb.service.SysRoleMenuService;
import com.cb.mapper.SysRoleMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author cuibing
* @description 针对表【sys_role_menu(角色和菜单关联表)】的数据库操作Service实现
* @createDate 2024-06-21 14:48:19
*/
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu>
    implements SysRoleMenuService{

}




