package com.deusley.workmongoDb.controller;

import com.deusley.workmongoDb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    @GetMapping
    public ResponseEntity <List<User>> findAll() {

        User teste1 = new User("1", "Deusley Diego", "Deusley@Dev.test");
        User teste2 = new User("2", "Ruth", "Ruth@boot.test");
        User teste3 = new User("3", "Geraldo", "Geraldo@boot.test");

        List<User> list = new ArrayList<>(Arrays.asList(teste1, teste2, teste3));

        return ResponseEntity.ok().body(list);


    }
}