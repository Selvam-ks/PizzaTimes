package com.user.AuthService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserInfo {
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int user_id;
    @Id
    private String email;

    private String password;

    private String role;
}
