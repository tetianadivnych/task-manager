package com.project.taskmanagerapp.repository;

import com.project.taskmanagerapp.model.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtaskRepository extends JpaRepository<Subtask, Long> {

}
