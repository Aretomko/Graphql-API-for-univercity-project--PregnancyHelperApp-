package com.example.demo.resolver.file;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.domen.File;
import com.example.demo.repos.FileRepo;

public class FileQuery  implements GraphQLQueryResolver {
    private final FileRepo fileRepo;

    public FileQuery(FileRepo fileRepo) {
        this.fileRepo = fileRepo;
    }

    public Iterable<File> findAllFiles(){
        return fileRepo.findAll();
    }
    public File findFileById(Long fileId){
        return fileRepo.findById(fileId).orElse(null);
    }
}
