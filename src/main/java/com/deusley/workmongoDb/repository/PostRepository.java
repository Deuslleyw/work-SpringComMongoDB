package com.deusley.workmongoDb.repository;

import com.deusley.workmongoDb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
