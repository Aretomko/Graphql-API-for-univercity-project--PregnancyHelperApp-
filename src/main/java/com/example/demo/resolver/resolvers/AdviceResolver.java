package com.example.demo.resolver.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.domen.Advice;
import com.example.demo.domen.User;
import com.example.demo.repos.UserRepo;

public class AdviceResolver implements GraphQLResolver<Advice> {
    private final UserRepo userRepo;


    public AdviceResolver(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUser(Advice advice){
        return userRepo.findById(advice.getUser().getId()).get();
    }

}
