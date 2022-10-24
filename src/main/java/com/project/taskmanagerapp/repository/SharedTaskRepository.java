package com.project.taskmanagerapp.repository;

import com.project.taskmanagerapp.model.SharedTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedTaskRepository extends JpaRepository<SharedTask, Long> {
}
