package com.phrase.demo.models;

import java.util.List;

public class CommonResponse <T> {

    private int totalElements;
    private List<T> content;


    public CommonResponse() {}

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "totalElements=" + totalElements +
                ", content=" + content +
                '}';
    }
}
