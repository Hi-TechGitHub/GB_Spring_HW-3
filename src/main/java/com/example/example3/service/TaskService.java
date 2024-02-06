package com.example.example3.service;

import com.example.example3.other.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(UUID uuid) {
        return tasks.stream().filter( t -> t.getId().equals(uuid)).findFirst().orElse(null);
    }

    public Task addTask(Task task){
        tasks.add(task);
        return task;
    }

    public void deleteTask(UUID uuid){
        tasks.removeIf(t -> t.getId().equals(uuid));
    }
    public Task updateTask(UUID uuid, Task task){
        Task taskToUpdate = getTaskById(uuid);
        if ( taskToUpdate!= null) {
            taskToUpdate.setName(task.getName());
            taskToUpdate.setDescription(task.getDescription());
            taskToUpdate.setCompletionTime(task.getCompletionTime());
        }
        return taskToUpdate;
    }

}