package com.AlertSystem.backendSiteDiplom.controllers;

import com.AlertSystem.backendSiteDiplom.models.People;
import com.AlertSystem.backendSiteDiplom.services.PeopleService;
import com.AlertSystem.backendSiteDiplom.util.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true")
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final JWTUtil jwtUtil;
    private PeopleService peopleService;

    public AdminController(JWTUtil jwtUtil, PeopleService peopleService) {
        this.jwtUtil = jwtUtil;
        this.peopleService = peopleService;
    }

    @GetMapping("/setRole")
    public ResponseEntity<Map> setRole(@CookieValue(value = "jwt-token") String jwtCookie,
                                       @RequestParam(value = "loginUser") String loginUser,
                                       @RequestParam(value = "role") String role) {
        String loginAdmin = jwtUtil.validateToken(jwtCookie);
        People admin = peopleService.getByLogin(loginAdmin);
        People user = peopleService.getByLogin(loginUser);

        if (admin.getRole().equals("admin")) {
            user.setRole(role);
            peopleService.save(user);
            return ResponseEntity.ok(Map.of("status", "Роль успешно изменина"));
        }
        return ResponseEntity.badRequest().body(Map.of("status", "У вас недостаточно прав"));
    }


}
