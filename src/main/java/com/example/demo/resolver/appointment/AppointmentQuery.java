package com.example.demo.resolver.appointment;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.domen.Appointment;
import com.example.demo.repos.AppointmentRepo;

public class AppointmentQuery implements GraphQLQueryResolver {
    private final AppointmentRepo appointmentRepo;

    public AppointmentQuery(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }
    public Iterable<Appointment>  findAllAppointments(){
        return appointmentRepo.findAll();
    }
}
