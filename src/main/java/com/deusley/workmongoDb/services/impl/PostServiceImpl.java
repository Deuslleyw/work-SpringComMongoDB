package com.deusley.workmongoDb.services.impl;


import com.deusley.workmongoDb.domain.Post;
import com.deusley.workmongoDb.exceptions.ObjectNotFoundException;
import com.deusley.workmongoDb.repository.PostRepository;
import com.deusley.workmongoDb.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repPost;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Post findByPostId(String id) {
        Optional<Post> obj = repPost.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Id inexistente!"));

    }

    @Override
    public List<Post> findByTitle(String text) {
        return repPost.findByTitleContainingIgnoreCase(text);
    }
}
