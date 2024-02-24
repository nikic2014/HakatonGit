package com.AlertSystem.backendSiteDiplom.models;

import com.AlertSystem.backendSiteDiplom.dto.TaskDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "idCourse")
    private int idCourse;
    @Column(name = "label")
    private String label;
    @Column(name = "description")
    private String description;

    public Task(){}

    public Task(int idCourse, String label, String description) {
        this.idCourse = idCourse;
        this.label = label;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
