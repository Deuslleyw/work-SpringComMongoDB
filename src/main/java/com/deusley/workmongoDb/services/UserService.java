package com.deusley.workmongoDb.services;

import com.deusley.workmongoDb.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
}