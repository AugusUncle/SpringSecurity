package com.cb.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "AppUser", description = "AppUser entity")
public class AppUser {

    @Schema(name = "userId", description = "用户ID")
    private int userId;
    @Schema(name = "nickName", description = "昵称")
    private String nickName;
    @Schema(name = "phoneNumber", description = "手机号")
    private String phoneNumber;
    @Schema(name = "userPhoto", description = "用户头像")
    private String userPhoto;
    @Schema(name = "account", description = "账号")
    private String account;
    @Schema(name = "password", description = "密码")
    private String password;
    @Schema(name = "userType", description = "用户类型")
    private String userType;
    @Schema(name = "status", description = "状态")
    private String status;
}
