package com.example.checkpoint5.repository;

import com.example.checkpoint5.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long> {
    List<Task> findByStatus(String status);

    List<Task> findByDueDateBetween(LocalDate start, LocalDate end);

    List<Task> findByTitleContainingIgnoreCase(String title);
}
