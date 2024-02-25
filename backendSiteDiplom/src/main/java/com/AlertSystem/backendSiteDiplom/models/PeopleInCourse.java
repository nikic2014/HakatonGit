package com.AlertSystem.backendSiteDiplom.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PeopleInCourse")
public class PeopleInCourse {

    @EmbeddedId
    PeopleInCourseId peopleInCourseId;

    @Column(name = "infoToRep")
    private String infoToRep;

    public PeopleInCourse(){}

    public PeopleInCourseId getPeopleInCourseId() {
        return peopleInCourseId;
    }

    public String getInfoToRep() {
        return infoToRep;
    }

    public void setInfoToRep(String infoToRep) {
        this.infoToRep = infoToRep;
    }

    public void setPeopleInCourseId(PeopleInCourseId peopleInCourseId) {
        this.peopleInCourseId = peopleInCourseId;
    }
}
