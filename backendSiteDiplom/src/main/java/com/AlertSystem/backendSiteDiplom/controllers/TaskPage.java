package com.AlertSystem.backendSiteDiplom.controllers;

import com.AlertSystem.backendSiteDiplom.models.*;
import com.AlertSystem.backendSiteDiplom.services.*;
import com.AlertSystem.backendSiteDiplom.util.JWTUtil;
import com.AlertSystem.backendSiteDiplom.util.RequestUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true")
@RestController
@RequestMapping("/taskPage")
public class TaskPage {
    private TaskService taskService;
    private JWTUtil jwtUtil;
    private PeopleService peopleService;
    private GradeService gradeService;

    private RequestUtil requestUtil;

    private CourseService courseService;
    private PeopleInCourseService peopleInCourseService;

    public TaskPage(TaskService taskService, JWTUtil jwtUtil, PeopleService peopleService, GradeService gradeService, RequestUtil requestUtil, CourseService courseService, PeopleInCourseService peopleInCourseService) {
        this.taskService = taskService;
        this.jwtUtil = jwtUtil;
        this.peopleService = peopleService;
        this.gradeService = gradeService;
        this.requestUtil = requestUtil;
        this.courseService = courseService;
        this.peopleInCourseService = peopleInCourseService;
    }

    @GetMapping("/getGrade")
    public ResponseEntity<Map> getInfoToRep(@CookieValue(value = "jwt-token") String jwtCookie,
                                            @RequestParam(value = "taskId") int taskId,
                                            @RequestParam(value = "idPeople") int idPeople) throws IOException {
        String login = jwtUtil.validateToken(jwtCookie);
        People people = peopleService.getByLogin(login);

        Grade grade = gradeService.findGreadByTaskPeople(taskId, idPeople);
        Task task = taskService.findByTaskId(taskId).get();
        int courseId = task.getIdCourse();
        PeopleInCourseId peopleInCourseId = new PeopleInCourseId(courseId, idPeople);
        String infoToRep = peopleInCourseService.findInfoToRep(peopleInCourseId);
        String datePush = requestUtil.sendInfoToPush(people.getLogin(), infoToRep, task.getLabel());
        grade.setDateLastPush(datePush);
        gradeService.saveGrade(grade);

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
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime.toString());
        grade.setDateGrade(currentTime.toString());
        gradeService.saveGrade(grade);

        return ResponseEntity.ok(Map.of("status", "success"));
    }
}
