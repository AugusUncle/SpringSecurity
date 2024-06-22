package com.cb.security;

import com.cb.domain.dto.UserDto;
import com.cb.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService; // 假设您有一个UserRepository接口来与数据库交互



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = sysUserService.getUserByUserName(username);
        if (userDto == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(userDto.getUserName(), userDto.getPassword(), getAuthorities(userDto));
    }

    /**
     * 获取用户权限
     * @param userDto
     * @return
     */
    private Collection<? extends GrantedAuthority> getAuthorities(UserDto userDto) {
        return userDto.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority( role.getRoleName()))
                .collect(Collectors.toList());
    }
}
