package com.project.taskmanagerapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    @ManyToOne
    @JoinColumn(name = "task_owner")
    private User taskOwner;
    private String taskDescription;
    @Enumerated(EnumType.STRING)
    private Priority taskPriority;
    @OneToMany(mappedBy = "task")
    private List<SharedTask> sharedTasks = new ArrayList<>();

    @OneToMany(mappedBy = "task")
    private List<Subtask> subtasks = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public User getTaskOwner() {
        return taskOwner;
    }

    public void setTaskOwner(User taskOwner) {
        this.taskOwner = taskOwner;
    }

    public String getDescription() {
        return taskDescription;
    }

    public void setDescription(String description) {
        this.taskDescription = description;
    }


    public List<SharedTask> getSharedTasks() {
        return sharedTasks;
    }

    public void setSharedTasks(List<SharedTask> sharedTasks) {
        this.sharedTasks = sharedTasks;
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public Priority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(Priority taskPriority) {
        this.taskPriority = taskPriority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskOwner=" + taskOwner +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskPriority=" + taskPriority +
                ", sharedTasks=" + sharedTasks +
                ", subtasks=" + subtasks +
                '}';
    }
}
