package com.urvesh.Smart_Task_Management_System.repository;

import com.urvesh.Smart_Task_Management_System.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    @Query("SELECT t FROM Task t WHERE t.dueDate < :currentDate AND t.isCompleted = false")
    List<Task> findOverdueTasks(@Param("currentDate") LocalDate currentDate);

}
