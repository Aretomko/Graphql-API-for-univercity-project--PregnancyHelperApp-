package com.example.demo.resolver.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.domen.Advice;
import com.example.demo.domen.File;
import com.example.demo.domen.HistoryRecord;
import com.example.demo.repos.HistoryRecordRepo;

public class FileResolver  implements GraphQLResolver<Advice> {
    private final HistoryRecordRepo historyRecordRepo;

    public FileResolver(HistoryRecordRepo historyRecordRepo) {
        this.historyRecordRepo = historyRecordRepo;
    }

    public HistoryRecord getHistoryRecord(File file){
        return historyRecordRepo.findById(file.getHistoryRecord().getId()).get();
    }
}
