package com.user.AuthService.repository;

import com.user.AuthService.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserInfo,String> {

}
