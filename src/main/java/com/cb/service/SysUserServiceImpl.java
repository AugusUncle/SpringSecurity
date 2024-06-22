package com.cb.service;


import com.cb.domain.SysRole;
import com.cb.domain.SysUser;
import com.cb.domain.SysUserRole;
import com.cb.domain.dto.RegisterDto;
import com.cb.domain.dto.UserDto;
import com.cb.mapper.SysRoleMapper;
import com.cb.mapper.SysUserMapper;
import com.cb.mapper.SysUserRoleMapper;
import com.cb.service.SysUserService;
import com.cb.utils.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;


    @Override
    public void register(RegisterDto registerDto) {

        SysUser sysUser = new SysUser();
        sysUser.setUserName(registerDto.getUserName());
        sysUser.setPassword(EncryptionUtil.hashPassword(registerDto.getPassword()));
        sysUserMapper.insert(sysUser);

        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUser.getId());
        sysUserRole.setRoleId(2L);
        sysUserRoleMapper.insert(sysUserRole);
    }

    @Override
    public UserDto getUserByUserName(String userName) {

        SysUser sysUser = sysUserMapper.findOneByUserName(userName);
        if(sysUser == null){
            return null;
        }

        List<SysUserRole> sysUserRoles = sysUserRoleMapper.findAllByUserId(sysUser.getId());

        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setPassword(sysUser.getPassword());

        if (!CollectionUtils.isEmpty(sysUserRoles)) {
            List<Long> roleIds = sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
            List<SysRole> roles = sysRoleMapper.findAllByIdIn(roleIds);
            userDto.setRoles(roles);
        }
        return userDto;
    }
}




