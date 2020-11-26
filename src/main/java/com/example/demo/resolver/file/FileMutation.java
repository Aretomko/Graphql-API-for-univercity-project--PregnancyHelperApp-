package com.example.demo.resolver.file;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.domen.File;
import com.example.demo.domen.HistoryRecord;
import com.example.demo.repos.FileRepo;
import com.example.demo.repos.HistoryRecordRepo;

public class FileMutation implements GraphQLMutationResolver {
    private final FileRepo fileRepo;
    private final HistoryRecordRepo historyRecordRepo;

    public FileMutation(FileRepo fileRepo, HistoryRecordRepo historyRecordRepo) {
        this.fileRepo = fileRepo;
        this.historyRecordRepo = historyRecordRepo;
    }

    public File createFile(String fileLink, Long historyRecordId ){
        HistoryRecord historyRecord = historyRecordRepo.findById(historyRecordId).orElse(null);
        if(historyRecord == null) return null;
        File file = new File(fileLink, historyRecord);
        fileRepo.save(file);
        return file;
    }
    public File deleteFile(Long fileId){
        File file = fileRepo.findById(fileId).orElse(null);
        if (file == null) return null;
        fileRepo.delete(file);
        return file;
    }
}
