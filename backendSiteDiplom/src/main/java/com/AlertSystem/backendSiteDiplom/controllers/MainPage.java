package com.AlertSystem.backendSiteDiplom.controllers;

import com.AlertSystem.backendSiteDiplom.dto.CourseDTO;
import com.AlertSystem.backendSiteDiplom.models.Course;
import com.AlertSystem.backendSiteDiplom.models.People;
import com.AlertSystem.backendSiteDiplom.models.PeopleInCourse;
import com.AlertSystem.backendSiteDiplom.models.PeopleInCourseId;
import com.AlertSystem.backendSiteDiplom.services.CourseService;
import com.AlertSystem.backendSiteDiplom.services.PeopleInCourseService;
import com.AlertSystem.backendSiteDiplom.services.PeopleService;
import com.AlertSystem.backendSiteDiplom.util.JWTUtil;
import com.AlertSystem.backendSiteDiplom.util.RequestUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true")
@RestController
@RequestMapping("/mainPage")
public class MainPage {

    private JWTUtil jwtUtil;
    private PeopleService peopleService;
    private CourseService courseService;
    private PeopleInCourseService peopleInCourseService;
    private RequestUtil requestUtil;

    public MainPage(JWTUtil jwtUtil, PeopleService peopleService, CourseService courseService, PeopleInCourseService peopleInCourseService, RequestUtil requestUtil) {
        this.jwtUtil = jwtUtil;
        this.peopleService = peopleService;
        this.courseService = courseService;
        this.peopleInCourseService = peopleInCourseService;
        this.requestUtil = requestUtil;
    }

    @GetMapping("/userInfo")
    public ResponseEntity<Map> userInfo(@CookieValue(value = "jwt-token") String jwtCookie) {
        String login = jwtUtil.validateToken(jwtCookie);
        People people = peopleService.getByLogin(login);

        Map response = Map.of("login",people.getLogin(),
                "name", people.getName(),
                "serName", people.getSerName(),
                "role", people.getRole(),
                "email", people.getEmail());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/CourseInfo")
    public ResponseEntity<List> Courses(@CookieValue(value = "jwt-token") String jwtCookie) {
        String login = jwtUtil.validateToken(jwtCookie);
        People people = peopleService.getByLogin(login);
        List<PeopleInCourse> courses = peopleInCourseService.findCoursesByPeopleId(people.getId());
        return ResponseEntity.ok(courses);
    }

    @PostMapping("/createCourse")
    public ResponseEntity<Map> createCourse(@CookieValue(value = "jwt-token") String jwtCookie,
                                            @RequestBody CourseDTO courseDTO) throws IOException {
        String login = jwtUtil.validateToken(jwtCookie);
        People people = peopleService.getByLogin(login);

        Course course = new Course(courseDTO.getCourseName(),
                courseDTO.getCourseDescription(),
                people.getId());
        courseService.saveCourse(course);
        List<String> students = courseDTO.getStudents();
        for (int i=0;i<students.size();i++) {
            People student = peopleService.getByLogin(students.get(i));
            PeopleInCourseId peopleInCourseId = new PeopleInCourseId(course.getId(), student.getId());
            PeopleInCourse peopleInCourse = new PeopleInCourse();
            peopleInCourse.setPeopleInCourseId(peopleInCourseId);
            String infToRep = requestUtil.sendCreateRepo(student.getLogin(), course.getId(), course.getLabel(),
                    course.getDescription());
            peopleInCourse.setInfoToRep(infToRep);
            peopleInCourseService.savePeopleInCourse(peopleInCourse);
        }

        return ResponseEntity.ok(Map.of("status", "success"));
    }

}
