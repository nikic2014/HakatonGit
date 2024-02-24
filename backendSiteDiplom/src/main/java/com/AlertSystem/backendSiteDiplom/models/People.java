package com.AlertSystem.backendSiteDiplom.models;

import jakarta.persistence.*;

@Entity
@Table(name = "People")
public class People {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "Nname")
    private String Nname;
    @Column(name = "serName")
    private String serName;
    @Column(name = "role")
    private String role;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return Nname;
    }

    public void setName(String name) {
        Nname = name;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public People(){}

    public People(String login, String password, String email, String name, String serName) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.Nname = name;
        this.serName = serName;
    }
}
