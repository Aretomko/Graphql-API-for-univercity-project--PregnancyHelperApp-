package com.example.demo.resolver.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.domen.Advice;
import com.example.demo.domen.Appointment;
import com.example.demo.domen.User;
import com.example.demo.repos.UserRepo;

public class AppointmentResolver  implements GraphQLResolver<Advice> {
    private final UserRepo userRepo;


    public AppointmentResolver(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUser(Appointment appointment){
        return userRepo.findById(appointment.getUser().getId()).get();
    }

}
