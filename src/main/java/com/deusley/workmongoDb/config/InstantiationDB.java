package com.deusley.workmongoDb.config;

import com.deusley.workmongoDb.domain.User;
import com.deusley.workmongoDb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InstantiationDB implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        User user1 = new User(null, "Deusley Diego", "Dev@test.com");
        User user2 = new User(null, "Rosangela", "Rosangela@test.com");
        User user3 = new User(null, "Andreia", "Andreia@test.com");
        User user4 = new User(null, "Jéssica", "Jessica@test.com");
        User user5 = new User(null, "Marta", "Marta@test.com");

        repository.saveAll(List.of(user1, user2, user3,user4,user5));

    }
}
