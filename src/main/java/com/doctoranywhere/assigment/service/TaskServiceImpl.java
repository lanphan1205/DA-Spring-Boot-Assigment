package com.doctoranywhere.assigment.service;

import com.doctoranywhere.assigment.constants.TaskConstants;
import com.doctoranywhere.assigment.entity.Task;
import com.doctoranywhere.assigment.error.TaskNotFoundException;
import com.doctoranywhere.assigment.repository.TaskRepository;
import com.doctoranywhere.assigment.util.TaskUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long taskId) throws TaskNotFoundException {
       Optional<Task> task = taskRepository.findById(taskId);
       if(!task.isPresent()) {
           throw new TaskNotFoundException(TaskConstants.TASK_NOT_FOUND_EXCEPTION_MESSAGE);
       }
        return task.get();
    }

    @Override
    public void deleteTaskById(Long taskId) throws TaskNotFoundException
    {
        Optional<Task> taskDB = taskRepository.findById(taskId);
        if(!taskDB.isPresent()) {
            throw new TaskNotFoundException(TaskConstants.TASK_NOT_FOUND_EXCEPTION_MESSAGE);
        }
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task updateTaskById(Long taskId, Task task) throws TaskNotFoundException {
        Optional<Task> taskDB = taskRepository.findById(taskId);

        if(!taskDB.isPresent()) {
            throw new TaskNotFoundException(TaskConstants.TASK_NOT_FOUND_EXCEPTION_MESSAGE);
        }

        // Assumption: Task is only updated with non-null or non-empty value
        if(TaskUtil.isStrNotNullOrEmpty(task.getTitle())) {
            taskDB.get().setTitle(task.getTitle());
        }
        if(TaskUtil.isStrNotNullOrEmpty(task.getDescription())) {
            taskDB.get().setDescription(task.getDescription());
        }
        if(TaskUtil.isNotNull(task.getCompleted())) {
            taskDB.get().setCompleted(task.getCompleted());
        }
        return taskRepository.save(taskDB.get());
    }


}
