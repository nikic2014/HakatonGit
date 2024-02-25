package com.AlertSystem.backendSiteDiplom.controllers;

import com.AlertSystem.backendSiteDiplom.models.Grade;
import com.AlertSystem.backendSiteDiplom.models.People;
import com.AlertSystem.backendSiteDiplom.services.GradeService;
import com.AlertSystem.backendSiteDiplom.services.PeopleService;
import com.AlertSystem.backendSiteDiplom.services.TaskService;
import com.AlertSystem.backendSiteDiplom.util.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true")
@RestController
@RequestMapping("/taskPage")
public class TaskPage {
    private TaskService taskService;
    private JWTUtil jwtUtil;
    private PeopleService peopleService;
    private GradeService gradeService;

    public TaskPage(TaskService taskService, JWTUtil jwtUtil, PeopleService peopleService, GradeService gradeService) {
        this.taskService = taskService;
        this.jwtUtil = jwtUtil;
        this.peopleService = peopleService;
        this.gradeService = gradeService;
    }

    @GetMapping("/getGrade")
    public ResponseEntity<Map> setInfoToRep(@CookieValue(value = "jwt-token") String jwtCookie,
                                            @RequestParam(value = "taskId") int taskId,
                                            @RequestParam(value = "taskId") int idPeople) {
        String login = jwtUtil.validateToken(jwtCookie);
        People people = peopleService.getByLogin(login);

        Grade grade = gradeService.findGreadByTaskPeople(taskId, idPeople);

        return ResponseEntity.ok(Map.of("grade", grade.getGrade()));
    }

    @GetMapping("/setGrade")
    public ResponseEntity<Map> setGrade(@CookieValue(value = "jwt-token") String jwtCookie,
                                            @RequestParam(value = "taskId") int taskId,
                                            @RequestParam(value = "taskId") int idPeople,
                                            @RequestParam(value = "newGrade") int newGrade) {
        String login = jwtUtil.validateToken(jwtCookie);
        People people = peopleService.getByLogin(login);

        Grade grade = gradeService.findGreadByTaskPeople(taskId, idPeople);
        grade.setGrade(newGrade);
        gradeService.saveGrade(grade);

        return ResponseEntity.ok(Map.of("status", "success"));
    }
}
