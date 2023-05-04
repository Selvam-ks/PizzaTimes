package com.user.AuthService.service;

import com.user.AuthService.domain.UserInfo;
import com.user.AuthService.repository.UserRepo;
import com.user.AuthService.exception.UserAlreadyExists;
import com.user.AuthService.exception.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo repo;
    @Override
    public UserInfo saveNewUser(UserInfo userinfo) throws UserAlreadyExists {
        if(repo.findById(userinfo.getEmail()).isPresent()){
            throw new UserAlreadyExists();
        }
        return repo.save(userinfo);
    }

    @Override
    public UserInfo LoginUser(UserInfo userinfo) throws UserNotFound {
        return null;
    }

    @Override
    public UserInfo loginCheck(UserInfo user) {
        if(repo.findById(user.getEmail()).isPresent()){
            UserInfo userTemp = repo.findById(user.getEmail()).get();
            if(userTemp.getPassword().equals(user.getPassword())){
                return userTemp;
            }else
                return null;
        }else
            return null;
    }
}
