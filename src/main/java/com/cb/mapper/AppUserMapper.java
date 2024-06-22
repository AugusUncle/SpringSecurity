package com.cb.mapper;

import com.cb.domain.AppUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppUserMapper {

    public List<AppUser> getUserList();
    public AppUser getUserByAccount(String account);
    public AppUser getUserById(String id);

    public void insertUser(AppUser user);
}
