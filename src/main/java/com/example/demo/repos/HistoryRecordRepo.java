package com.example.demo.repos;

import com.example.demo.domen.HistoryRecord;
import com.example.demo.domen.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRecordRepo extends JpaRepository<HistoryRecord, Long> {
}
