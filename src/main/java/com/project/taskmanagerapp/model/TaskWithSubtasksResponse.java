package com.project.taskmanagerapp.model;

import java.util.ArrayList;
import java.util.List;

public class TaskWithSubtasksResponse {
    private String taskName;

    private Long taskId;
    private List<SubtaskResponse> subtasks = new ArrayList<>();

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<SubtaskResponse> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<SubtaskResponse> subtasks) {
        this.subtasks = subtasks;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

}
