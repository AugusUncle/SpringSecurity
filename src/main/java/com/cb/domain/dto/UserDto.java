package com.cb.domain.dto;

import com.cb.domain.SysRole;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String userName;
    private String password;
    private List<SysRole> roles;
}
