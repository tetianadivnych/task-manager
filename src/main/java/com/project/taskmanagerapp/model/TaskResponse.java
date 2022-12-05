package com.project.taskmanagerapp.model;

import java.util.ArrayList;
import java.util.List;

public class TaskResponse {

    private String name;
    private UserResponse owner;
    private List<UserResponse> participants = new ArrayList<>();

    private Priority priority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserResponse getOwner() {
        return owner;
    }

    public void setOwner(UserResponse owner) {
        this.owner = owner;
    }

    public List<UserResponse> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserResponse> participants) {
        this.participants = participants;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
