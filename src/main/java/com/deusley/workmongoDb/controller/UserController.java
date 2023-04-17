package com.deusley.workmongoDb.controller;

import com.deusley.workmongoDb.domain.Post;
import com.deusley.workmongoDb.domain.User;
import com.deusley.workmongoDb.dto.UserDTO;
import com.deusley.workmongoDb.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    public static final String ID = "/{id}";
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
    @GetMapping(value = ID)
    public ResponseEntity <UserDTO> findById(@PathVariable String id){
        var user = service.findById(id);
        var mapperResponse = mapper.map(user, UserDTO.class);

        return ResponseEntity.ok().body(mapperResponse);
    }
    @PostMapping
    public ResponseEntity<Void> Insert(@RequestBody UserDTO userDTO){

        var mapperInsert = mapper.map(userDTO, User.class);
        var user = service.Insert(userDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path(ID).buildAndExpand((user).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(value = ID)
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = ID)
    public ResponseEntity<UserDTO> update(@PathVariable String id , @RequestBody UserDTO userDTO){
        userDTO.setId(id);

        var user = service.update(userDTO);
        var responseMapper = mapper.map(userDTO, UserDTO.class);
        return ResponseEntity.ok().body(userDTO);
    }
    @GetMapping(value = "{id}/posts")
    public ResponseEntity <List<Post>> findByPost(@PathVariable String id) {
        var user = service.findById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }
}
