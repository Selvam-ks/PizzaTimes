package com.user.AuthService.service;

import com.user.AuthService.domain.UserInfo;
import com.user.AuthService.exception.UserAlreadyExists;
import com.user.AuthService.exception.UserNotFound;

public interface UserService {
    UserInfo saveNewUser(UserInfo userinfo)throws UserAlreadyExists;
    UserInfo LoginUser(UserInfo userinfo)throws UserNotFound;
    UserInfo loginCheck(UserInfo userinfo);
}
