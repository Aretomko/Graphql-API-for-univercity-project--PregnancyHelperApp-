package com.example.demo.resolver.appointment;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.domen.Appointment;
import com.example.demo.domen.User;
import com.example.demo.repos.AppointmentRepo;
import com.example.demo.repos.UserRepo;


import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentMutation  implements GraphQLMutationResolver {
    private final AppointmentRepo appointmentRepo;
    private final UserRepo userRepo;

    public AppointmentMutation(AppointmentRepo appointmentRepo, UserRepo userRepo) {
        this.appointmentRepo = appointmentRepo;
        this.userRepo = userRepo;
    }

    public Appointment addNewAppointment(String date, Long userId){
        User user = userRepo.findById(userId).orElse(null);
        Date dateObject;
        if (user == null) return null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            dateObject = formatter.parse(date);
        }catch (Exception ex){
            return null;
        }
        Appointment appointment = new Appointment(dateObject, user);
        appointmentRepo.save(appointment);
        return appointment;
    }
    public Appointment deleteAppointment(Long appointmentId){
        Appointment appointment = appointmentRepo.findById(appointmentId).orElse(null);
        if (appointment == null ) return null;
        appointmentRepo.delete(appointment);
        return appointment;
    }
}
