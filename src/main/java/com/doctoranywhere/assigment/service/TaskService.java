package com.doctoranywhere.assigment.service;

import com.doctoranywhere.assigment.entity.Task;
import com.doctoranywhere.assigment.error.TaskNotFoundException;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long taskId) throws TaskNotFoundException;
    void deleteTaskById(Long taskId) throws TaskNotFoundException;
    Task updateTaskById(Long taskId, Task task) throws TaskNotFoundException;
}
