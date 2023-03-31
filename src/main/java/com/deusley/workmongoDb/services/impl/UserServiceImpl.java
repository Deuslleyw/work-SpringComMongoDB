package com.deusley.workmongoDb.services.impl;

import com.deusley.workmongoDb.domain.User;
import com.deusley.workmongoDb.repository.UserRepository;
import com.deusley.workmongoDb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository rep;

    @Override
    public List<User> findAll() {
        return rep.findAll();
    }
}
