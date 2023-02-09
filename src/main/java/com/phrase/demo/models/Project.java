package com.phrase.demo.models;

import java.util.List;

public class Project {

    private String name;
    private String status;
    private String sourceLang;
    private List<String> targetLangs;

    public Project() {}

    public Project(String name, String status, String sourceLang, List<String> targetLangs) {
        this.name = name;
        this.status = status;
        this.sourceLang = sourceLang;
        this.targetLangs = targetLangs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(String sourceLang) {
        this.sourceLang = sourceLang;
    }

    public List<String> getTargetLangs() {
        return targetLangs;
    }

    public void setTargetLangs(List<String> targetLangs) {
        this.targetLangs = targetLangs;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", sourceLang='" + sourceLang + '\'' +
                ", targetLangs=" + targetLangs +
                '}';
    }
}
