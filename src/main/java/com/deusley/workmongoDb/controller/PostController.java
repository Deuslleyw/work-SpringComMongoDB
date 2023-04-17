package com.deusley.workmongoDb.controller;

import com.deusley.workmongoDb.controller.util.URL;
import com.deusley.workmongoDb.domain.Post;
import com.deusley.workmongoDb.dto.PostDTO;
import com.deusley.workmongoDb.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/posts")
public class PostController {

    public static final String ID = "/{id}";

    @Autowired
    private PostService postService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = ID)
    public ResponseEntity<PostDTO> findById(@PathVariable String id) {
        var post = postService.findByPostId(id);
        var mapPostResponse = mapper.map(post, PostDTO.class);
        return ResponseEntity.ok().body(mapPostResponse);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        var mapperDto = mapper.map(list, PostDTO.class);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/allsearch")
    public ResponseEntity<List<Post>> allSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "dateMin", defaultValue = "") String dateMin,
            @RequestParam(value = "dateMax", defaultValue = "") String dateMax) {

        text = URL.decodeParam(text);
        var date = URL.convertDates(dateMin, new Date(0L));
        var date2 = URL.convertDates(dateMax, new Date());

        List<Post> list = postService.allSearch(text, date, date2);
        return ResponseEntity.ok().body(list);
    }
}