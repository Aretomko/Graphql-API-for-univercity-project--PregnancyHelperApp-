package com.example.demo.domen;

import javax.persistence.*;
import java.util.List;

@Entity
public class HistoryRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @OneToMany(mappedBy="historyRecord")
    private List<File> files;

    public HistoryRecord() {
    }

    public HistoryRecord(String text) {
        this.text = text;
    }

    public HistoryRecord(String text, List<File> files) {
        this.text = text;
        this.files = files;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
