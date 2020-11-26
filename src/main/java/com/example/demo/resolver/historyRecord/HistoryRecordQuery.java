package com.example.demo.resolver.historyRecord;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.domen.HistoryRecord;
import com.example.demo.repos.HistoryRecordRepo;

public class HistoryRecordQuery  implements GraphQLQueryResolver {
    private final HistoryRecordRepo historyRecordRepo;

    public HistoryRecordQuery(HistoryRecordRepo historyRecordRepo) {
        this.historyRecordRepo = historyRecordRepo;
    }

    public HistoryRecord  findHistoryRecordById(Long historyRecordId){
        return historyRecordRepo.findById(historyRecordId).orElse(null);
    }
    public Iterable<HistoryRecord> findAllHistoryRecords(){
        return historyRecordRepo.findAll();
    }
}
