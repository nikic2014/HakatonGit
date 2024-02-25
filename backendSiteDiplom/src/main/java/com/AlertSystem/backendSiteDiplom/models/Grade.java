package com.AlertSystem.backendSiteDiplom.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Grade")
public class Grade {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idTask")
    private int idTask;
    @Column(name = "idPeople")
    private int idPeople;
    @Column(name = "dateGrade")
    private String dateGrade;
    @Column(name = "dateLastPush")
    private String dateLastPush;

    public String getDateGrade() {
        return dateGrade;
    }

    public void setDateGrade(String dateGrade) {
        this.dateGrade = dateGrade;
    }

    public String getDateLastPush() {
        return dateLastPush;
    }

    public void setDateLastPush(String dateLastPush) {
        this.dateLastPush = dateLastPush;
    }

    @Column(name = "grade")
    private int grade;

    public Grade(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public int getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(int idPeople) {
        this.idPeople = idPeople;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
