package com.example.demo.repos;

import com.example.demo.domen.Advice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdviceRepo extends JpaRepository<Advice, Long> {
}
