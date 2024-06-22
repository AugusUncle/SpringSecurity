package com.cb.service;

import com.cb.domain.AppUser;
import com.cb.mapper.AppUserMapper;
import com.cb.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserMapper AppUserMapper;

    @Override
    public List<AppUser> getUserList() {
        return AppUserMapper.getUserList();
    }

    @Override
    public AppUser getUserByAccount(String account) {
        return AppUserMapper.getUserByAccount(account);
    }

    @Override
    public AppUser getUserById(String id) {
        return AppUserMapper.getUserById(id);
    }

    @Override
    public void saveUser(AppUser user) {
        AppUserMapper.insertUser(user);
    }


}
