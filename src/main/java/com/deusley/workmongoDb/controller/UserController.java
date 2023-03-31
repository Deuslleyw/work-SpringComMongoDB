package com.deusley.workmongoDb.controller;

import com.deusley.workmongoDb.domain.User;
import com.deusley.workmongoDb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity <List<User>> findAll() {
                List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }
}