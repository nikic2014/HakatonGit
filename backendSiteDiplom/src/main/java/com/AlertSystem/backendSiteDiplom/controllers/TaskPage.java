package com.AlertSystem.backendSiteDiplom.controllers;

import com.AlertSystem.backendSiteDiplom.models.People;
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

    public TaskPage(TaskService taskService, JWTUtil jwtUtil, PeopleService peopleService) {
        this.taskService = taskService;
        this.jwtUtil = jwtUtil;
        this.peopleService = peopleService;
    }

//    @GetMapping("/getInfoToRep/{id}")
//    public ResponseEntity<Map> getInfoToRep(@CookieValue(value = "jwt-token") String jwtCookie,
//                                            @PathVariable Integer id) {
//        String login = jwtUtil.validateToken(jwtCookie);
//        People people = peopleService.getByLogin(login);
//
//        return ResponseEntity.ok(response);
//    }

}
