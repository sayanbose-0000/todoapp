package com.app.todoapp.respository;

import com.app.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

// A repository in Spring is a mechanism to interact with a database without writing SQL. It's part of the Spring Data JPA abstraction.
// Automatically gives us basic CRUD operations for the Todo entity (like save, findById, findAll, delete).
public interface TaskRepository extends JpaRepository<Task, Long> {}
