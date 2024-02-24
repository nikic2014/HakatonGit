package com.AlertSystem.backendSiteDiplom.models;

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
    @Column(name = "infoToRep")
    private String infoToRep;

}
