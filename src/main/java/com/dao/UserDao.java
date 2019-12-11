package com.dao;

import com.models.User;

public interface UserDao {

    User findByUserName(String username);

}