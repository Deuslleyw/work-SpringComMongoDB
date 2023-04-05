package com.deusley.workmongoDb.services.impl;

import com.deusley.workmongoDb.domain.User;
import com.deusley.workmongoDb.exceptions.ObjectNotFoundException;
import com.deusley.workmongoDb.repository.UserRepository;
import com.deusley.workmongoDb.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository rep;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<User> findAll() {
        return rep.findAll();
    }

    @Override
    public User findById(String id) {
        Optional<User> obj = rep.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Id de  Usuario inexistente!"));
    }


}
