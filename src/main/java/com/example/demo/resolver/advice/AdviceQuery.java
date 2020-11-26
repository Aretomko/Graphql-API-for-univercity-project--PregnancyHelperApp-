package com.example.demo.resolver.advice;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.domen.Advice;
import com.example.demo.repos.AdviceRepo;
import com.example.demo.repos.UserRepo;

public class AdviceQuery  implements GraphQLQueryResolver {
    private final AdviceRepo adviceRepo;

    public AdviceQuery(AdviceRepo adviceRepo) {
        this.adviceRepo = adviceRepo;
    }

    public Iterable<Advice> findAllAdvices(){
        return adviceRepo.findAll();
    }
    public Advice findAdviceById(Long id){
        return adviceRepo.findById(id).orElse(null);
    }
}
