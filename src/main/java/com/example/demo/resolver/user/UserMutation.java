package com.example.demo.resolver.user;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.domen.User;
import com.example.demo.repos.UserRepo;

import java.util.Optional;

public class UserMutation implements GraphQLMutationResolver {
    private final UserRepo userRepo;

    public UserMutation(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(String name, String surname, String email){
        User newUser = new User(name, surname, email);
        return userRepo.save(newUser);
    }
    public User deleteUser(Long id){
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            userRepo.delete(user.get());
            return user.get();
        }else return null;
    }
}
