package com.urvesh.Smart_Task_Management_System.service;

import com.urvesh.Smart_Task_Management_System.model.Task;
import com.urvesh.Smart_Task_Management_System.repository.TaskRepository;
import com.urvesh.Smart_Task_Management_System.repository.UserRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository ruserRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found."));
    }
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task newTask) {
        Task task = getTaskById(id);
        task.setName(newTask.getName());
        task.setDueDate(newTask.getDueDate());
        task.setPriority(newTask.getPriority());
        task.setAssignedTo(newTask.getAssignedTo());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
        System.out.println("Task deleted successfully.");
    }

    public List<Task> getOverdueTasks() {
        return taskRepository.findOverdueTasks(LocalDate.now());
    }
}
