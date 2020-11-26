package com.example.demo.resolver.advice;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.domen.Advice;
import com.example.demo.domen.User;
import com.example.demo.repos.AdviceRepo;
import com.example.demo.repos.UserRepo;

public class AdviceMutation implements GraphQLMutationResolver {
    private final AdviceRepo adviceRepo;
    private UserRepo userRepo;

    public AdviceMutation(AdviceRepo adviceRepo, UserRepo userRepo) {
        this.adviceRepo = adviceRepo;
        this.userRepo = userRepo;
    }

    public Advice createAdvice(String text, Long userId){
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) return null;
        Advice advice = new Advice(text, user);
        adviceRepo.save(advice);
        return advice;
    }
    public Advice deleteAdvice(Long adviceId) {
        Advice advice = adviceRepo.findById(adviceId).orElse(null);
        if (advice == null) return null;
        adviceRepo.delete(advice);
        return advice;
    }
}
