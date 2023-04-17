package com.deusley.workmongoDb.services;

import com.deusley.workmongoDb.domain.Post;

import java.util.Date;
import java.util.List;


public interface PostService {
    Post findByPostId(String id);
    List<Post> findByTitle(String text);

    List<Post> allSearch(String text, Date dateMin, Date dateMax);
    }
