package com.AlertSystem.backendSiteDiplom.services;


import com.AlertSystem.backendSiteDiplom.models.Task;
import com.AlertSystem.backendSiteDiplom.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(Task task){
        taskRepository.save(task);
    }

    public List<Task> getTasksByCourseId(int courseId){
        return taskRepository.findByIdCourse(courseId);
    }
}
