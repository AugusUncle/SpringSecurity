package com.cb.service;

import com.cb.domain.AppUser;
import org.springframework.security.core.userdetails.User;

public interface LoginServcie {
 public User login(AppUser user);

}
