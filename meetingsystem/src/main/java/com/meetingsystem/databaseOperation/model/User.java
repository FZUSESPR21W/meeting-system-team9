package com.meetingsystem.databaseOperation.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * User用户model
 *
 * @author 221801318_黄贸之
 * @Date 2021/3/27
 */

@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String userid;
    private String password;
    private String role;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
