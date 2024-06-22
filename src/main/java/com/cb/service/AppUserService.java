package com.cb.service;

import com.cb.domain.AppUser;

import java.util.List;

public interface AppUserService {

    public List<AppUser> getUserList();


    public AppUser getUserByAccount( String account);
    public AppUser getUserById(String id);

    public void saveUser(AppUser user);
}
