package com.phrase.demo.models;

import java.util.List;

public class Projects {

    private int numberOfProjects;
    private List<Project> projects;

    public Projects(int numberOfProjects, List<Project> projects) {
        this.numberOfProjects = numberOfProjects;
        this.projects = projects;
    }

    public int getNumberOfProjects() {
        return numberOfProjects;
    }

    public void setNumberOfProjects(int numberOfProjects) {
        this.numberOfProjects = numberOfProjects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "numberOfProjects=" + numberOfProjects +
                ", projects=" + projects +
                '}';
    }
}
