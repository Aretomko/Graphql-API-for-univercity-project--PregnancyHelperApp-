package com.example.demo.resolver.historyRecord;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.domen.HistoryRecord;
import com.example.demo.repos.FileRepo;
import com.example.demo.repos.HistoryRecordRepo;

public class HistoryRecordMutation implements GraphQLMutationResolver {
    private final HistoryRecordRepo historyRecordRepo;
    private final FileRepo fileRepo;

    public HistoryRecordMutation(HistoryRecordRepo historyRecordRepo, FileRepo fileRepo) {
        this.historyRecordRepo = historyRecordRepo;
        this.fileRepo = fileRepo;
    }

    public HistoryRecord createHistoryRecord(String text){
        HistoryRecord historyRecord = new HistoryRecord(text);
        historyRecordRepo.save(historyRecord);
        return historyRecord;
    }
    public HistoryRecord  deleteHistoryRecord(Long historyRecordId){
        HistoryRecord historyRecord = historyRecordRepo.findById(historyRecordId).orElse(null);
        if (historyRecord == null) return null;
        historyRecordRepo.delete(historyRecord);
        return historyRecord;
    }
}
