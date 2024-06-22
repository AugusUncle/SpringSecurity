package com.cb.service;

import com.cb.domain.AppUser;
import com.cb.mapper.AppUserMapper;
import com.cb.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginServiceImpl implements LoginServcie {

    @Autowired
    private AppUserMapper appUserMapper;
    @Override
    public User login(AppUser user) {

        AppUser newUser = appUserMapper.getUserByAccount(user.getAccount());

        if (newUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getAccount(), user.getPassword(), new ArrayList<>());
    }

}
