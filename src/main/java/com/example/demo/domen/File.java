package com.example.demo.domen;

import javax.persistence.*;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileLink;

    @ManyToOne
    @JoinColumn(name="history_record_id")
    private HistoryRecord historyRecord;

    public File(String fileLink, HistoryRecord historyRecord ){
        this.fileLink = fileLink;
        this.historyRecord = historyRecord;
    }

    public File() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public HistoryRecord getHistoryRecord() {
        return historyRecord;
    }

    public void setHistoryRecord(HistoryRecord historyRecord) {
        this.historyRecord = historyRecord;
    }
}

