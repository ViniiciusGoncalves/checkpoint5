package com.example.checkpoint5.service;

import com.example.checkpoint5.entity.Task;
import com.example.checkpoint5.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(task.getTitle());
                    existingTask.setDescription(task.getDescription());
                    existingTask.setStatus(task.getStatus());
                    existingTask.setDueDate(task.getDueDate());
                    return taskRepository.save(existingTask);
                }).orElseGet(() -> {
                    task.setId(id);
                    return taskRepository.save(task);
                });
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
