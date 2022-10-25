package com.project.taskmanagerapp.model;

import java.util.List;

public class TaskResponse {

    private String taskName;
    private UserResponse taskOwner;
    private List<UserResponse> taskParticipants;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public UserResponse getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(UserResponse taskOwner) {
        this.taskOwner = taskOwner;
    }

    public List<UserResponse> getTaskParticipants() {
        return taskParticipants;
    }

    public void setTaskParticipants(List<UserResponse> taskParticipants) {
        this.taskParticipants = taskParticipants;
    }
}
