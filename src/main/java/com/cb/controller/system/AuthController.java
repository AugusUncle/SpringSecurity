package com.cb.controller.system;

import com.cb.domain.Result;
import com.cb.domain.dto.LoginDto;
import com.cb.domain.dto.RegisterDto;
import com.cb.domain.dto.UserDto;
import com.cb.service.SysUserService;
import com.cb.utils.ErrorCode;
import com.cb.utils.HttpStatus;
import com.cb.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public Result Login(@RequestBody LoginDto loginDto) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (loginDto.getUserName(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtTokenUtil.generateToken(authenticate);
        return Result.success(ErrorCode.OK.getStatus(),"'登陆成功'", token);
    }

    @PostMapping("/register")
    public Result register(@RequestBody RegisterDto registerDto) {
        UserDto userDto = sysUserService.getUserByUserName(registerDto.getUserName());
        if (userDto != null) {
            return Result.error(HttpStatus.BAD_REQUEST, "用户已存在");
        }

        sysUserService.register(registerDto);
        return Result.success(ErrorCode.OK.getStatus(), "注册成功");

    }
}
