package com.AlertSystem.backendSiteDiplom.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Course")
public class Course {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "label")
    private String label;
    @Column(name = "description")
    private String description;

    public Course(){
    }


}
