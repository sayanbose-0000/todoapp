package com.app.todoapp.controller;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @Controller returns views (like HTML), while @RestController returns data (like JSON) directly in the response body.
// Since we are using thymeleaf and not making a REST API, we use @Controller here rather than @RestController
// Thymeleaf is a Java template engine used to generate HTML (or XML) views on the server side, we we don't have seperate frontend
@Controller
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    // We need to do this because taskService is final
    this.taskService = taskService;
  }

  @GetMapping(path = "/")
  public String getTasks(Model model) {
    List<Task> tasks = taskService.getAllTasks();
    model.addAttribute("tasks", tasks); // Makes tasks accessible in the tasks.html via the variable tasks.
    return "tasks"; // searches for tasks.html under resources/templates
  }

  @PostMapping(path = "/")
  public String createTask(@RequestParam String title) { // Request params is used to get data from url
    taskService.createTask(title);
    return "redirect:/"; // after work of the method is dont, it redirects page to "/"
  }

  @PostMapping(path = "/{id}/delete") // dynamic id
  public String deleteTask(@PathVariable Long id) {
    taskService.deleteTask(id);
    return "redirect:/";
  }

  @PostMapping(path = "/{id}/toggle") // dynamic id
  public String toggleTask(@PathVariable Long id) {
    taskService.toggleTask(id);
    return "redirect:/";
  }
}
