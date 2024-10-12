package com.gobanggame.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @program: gobanggame
 * @description: 注册时使用的DTO
 **/
@Data
@Schema(description = "注册DTO")
public class UserRegisterDTO {
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "密码")
    private String password;
}
