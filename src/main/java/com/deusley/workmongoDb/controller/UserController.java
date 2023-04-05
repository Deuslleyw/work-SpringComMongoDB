package com.deusley.workmongoDb.controller;

import com.deusley.workmongoDb.domain.User;
import com.deusley.workmongoDb.dto.UserDTO;
import com.deusley.workmongoDb.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity <List<UserDTO>> findAll() {

        var response = service.findAll()
                .stream().map(x -> mapper.map(x, UserDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(response);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity <UserDTO> findById(@PathVariable String id){
        var userId = service.findById(id);
        var mapperResponse = mapper.map(userId, UserDTO.class);

        return ResponseEntity.ok().body(mapperResponse);

    }
}