package com.gobanggame.service;

import com.gobanggame.pojo.dto.UserRegisterDTO;
import com.gobanggame.pojo.dto.UserUpdateDTO;
import com.gobanggame.pojo.entity.User;
import com.gobanggame.pojo.vo.UserLoginVO;
import com.gobanggame.pojo.vo.UserSelectByIdVO;

/**
 * @program: gobang
 * @description: 用户Service
 **/
public interface UserService {

    /**
     * @description 用户注册
     * @param userRegisterDTO
     * @return void
     **/
     void register(UserRegisterDTO userRegisterDTO);


     /**
      * @description 用户登录
      * @param userLoginDTO
      * @return com.gobanggame.pojo.vo.UserLoginVO
      **/
    UserLoginVO login(UserRegisterDTO userLoginDTO);

    /**
     * @description 根据id查询用户信息
     * @param id
     * @return com.gobanggame.pojo.vo.UserSelectByIdVO
     **/
    UserSelectByIdVO getById(Long id);

    /**
     * @description 更新用户信息
     * @param userUpdateDTO
     * @return void
     **/
    void update(UserUpdateDTO userUpdateDTO);


    /**
     * @description 用户注销
     * @param id
     * @return void
     **/
    void deleteById(Long id);
}
