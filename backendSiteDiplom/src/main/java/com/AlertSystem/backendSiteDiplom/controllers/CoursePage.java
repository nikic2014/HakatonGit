package com.AlertSystem.backendSiteDiplom.controllers;


import com.AlertSystem.backendSiteDiplom.dto.TaskDTO;
import com.AlertSystem.backendSiteDiplom.models.People;
import com.AlertSystem.backendSiteDiplom.models.Task;
import com.AlertSystem.backendSiteDiplom.services.PeopleService;
import com.AlertSystem.backendSiteDiplom.services.TaskService;
import com.AlertSystem.backendSiteDiplom.util.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true")
@RestController
@RequestMapping("/coursePage")
public class CoursePage {
    private JWTUtil jwtUtil;
    private PeopleService peopleService;

    private TaskService taskService;

    public CoursePage(JWTUtil jwtUtil, PeopleService peopleService, TaskService taskService) {
        this.jwtUtil = jwtUtil;
        this.peopleService = peopleService;
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> tasks(@CookieValue(value = "jwt-token") String jwtCookie,
                                            @RequestParam(value = "courseId") int courseId) {
        String login = jwtUtil.validateToken(jwtCookie);
        People people = peopleService.getByLogin(login);
        return ResponseEntity.ok(taskService.getTasksByCourseId(courseId));
    }

    @PostMapping("/createTask")
    public ResponseEntity<Map> tasks(@CookieValue(value = "jwt-token") String jwtCookie,
                                     @RequestBody TaskDTO taskDTO) {
        String login = jwtUtil.validateToken(jwtCookie);
        People people = peopleService.getByLogin(login);

        Task task = new Task(taskDTO.getIdCourse(), taskDTO.getLabel(), taskDTO.getDescription());
        taskService.save(task);

        return ResponseEntity.ok(Map.of("status", "success"));
    }
}
