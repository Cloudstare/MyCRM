package com.feli.mycrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private UsersRepository usersRepository;

    @Autowired
    public DatabaseSeeder(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Users> users = new ArrayList<>();

        users.add(new Users("Wiktor", "Dudek", "03/03/2020", "wik", "dud" ));
        users.add(new Users("Felicity", "Cloudstare", "03/04/2020", "Feli", "dud" ));
        users.add(new Users("Jacob", "Weirdo", "03/05/2021", "fite", "you" ));

        usersRepository.saveAll(users);
    }
}