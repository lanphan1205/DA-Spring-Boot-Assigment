package com.doctoranywhere.assigment.controller;

import com.doctoranywhere.assigment.entity.Task;
import com.doctoranywhere.assigment.error.TaskNotFoundException;
import com.doctoranywhere.assigment.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks()
    {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable("id") Long taskId)
            throws TaskNotFoundException
    {
        return taskService.getTaskById(taskId);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTaskById(@PathVariable("id") Long taskId)
            throws TaskNotFoundException {
        taskService.deleteTaskById(taskId);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTaskById(@PathVariable("id") Long taskId, @RequestBody Task task)
            throws TaskNotFoundException {
        return taskService.updateTaskById(taskId, task);
    }
}
