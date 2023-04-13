package com.deusley.workmongoDb.config;

import com.deusley.workmongoDb.domain.Post;
import com.deusley.workmongoDb.domain.User;
import com.deusley.workmongoDb.dto.AuthorDTO;
import com.deusley.workmongoDb.dto.CommentDTO;
import com.deusley.workmongoDb.repository.PostRepository;
import com.deusley.workmongoDb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class InstantiationDB implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        date.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Deusley Diego", "Dev@test.com");
        User user2 = new User(null, "Rosangela", "Rosangela@test.com");
        User user3 = new User(null, "Andreia", "Andreia@test.com");
        User user4 = new User(null, "Geraldo", "Geraldo@test.com");
        User user5 = new User(null, "Marta", "Marta@test.com");

        userRepository.saveAll(List.of(user1, user2, user3,user4,user5));

        Post post1 = new Post(null, date.parse("01/02/2022"),
                "Boa noite", "Aqui Treinando MongoDB! hehehe", new AuthorDTO(user1));

        Post post2 = new Post(null, date.parse("03/02/2023"),
                "Ola Devs", "Fazendo uma nova aplicação!", new AuthorDTO(user2));

        CommentDTO Cmm1 = new CommentDTO
                ("Isso aeee, Vai ficar top!",date.parse("2023/02/11"), new AuthorDTO(user5));

        CommentDTO Cmm2 = new CommentDTO
                ("Ja quero testar! :D ",date.parse("2023/03/14"), new AuthorDTO(user4));

        CommentDTO Cmm3 = new CommentDTO
                ("Me manda depois",date.parse("2023/03/12"), new AuthorDTO(user3));


        post1.getComments().addAll(Arrays.asList(Cmm1, Cmm2));
        post2.getComments().add(Cmm3);

        postRepository.saveAll(List.of(post1, post2));

        user1.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(user1);

    }
}
