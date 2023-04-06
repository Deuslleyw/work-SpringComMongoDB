package com.deusley.workmongoDb.services;

import com.deusley.workmongoDb.domain.User;
import com.deusley.workmongoDb.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String id);

    User Insert(UserDTO userDTO);

    void delete(String id);

    User update(UserDTO userDTO);
}
