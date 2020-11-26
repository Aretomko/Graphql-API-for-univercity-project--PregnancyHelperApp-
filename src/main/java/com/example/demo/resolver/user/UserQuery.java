package com.example.demo.resolver.user;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.domen.User;
import com.example.demo.repos.UserRepo;

import java.util.Optional;

public class UserQuery  implements GraphQLQueryResolver {
    private final UserRepo userRepo;

    public UserQuery(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Iterable<User>  getAllUsers(){
        return userRepo.findAll();
    }

    public User findUserById(Long id){
        Optional<User> user = userRepo.findById(id);
        return user.orElse(null);
    }
    public User findUserByUsername(String username){
        return userRepo.findByUsername(username);
    }
}
