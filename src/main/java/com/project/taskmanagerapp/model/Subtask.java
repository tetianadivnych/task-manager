package com.project.taskmanagerapp.model;

import javax.persistence.*;

@Entity
public class Subtask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subtaskName;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    private boolean completed;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubtaskName() {
        return subtaskName;
    }

    public void setSubtaskName(String subtaskName) {
        this.subtaskName = subtaskName;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + id +
                ", subtaskName='" + subtaskName + '\'' +
                ", task=" + task +
                ", completed=" + completed +
                ", priority=" + priority +
                '}';
    }
}
