package com.project.taskmanagerapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    private Long id;
    private String taskName;
    private String taskOwner;
    private String taskDescription;
    private String taskPriority;


    public void setId(Long id) {
        this.id = id;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskOwner(String taskOwner) {
        this.taskOwner = taskOwner;
    }

    public Long getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskOwner() {
        return taskOwner;
    }

    public String getDescription() {
        return taskDescription;
    }

    public void setDescription(String description) {
        this.taskDescription = description;
    }

    public String getPriority() {
        return taskPriority;
    }

    public void setPriority(String priority) {
        this.taskPriority = priority;
    }

}
