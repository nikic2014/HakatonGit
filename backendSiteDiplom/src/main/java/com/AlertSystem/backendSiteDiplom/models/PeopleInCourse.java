package com.AlertSystem.backendSiteDiplom.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PeopleInCourse")
public class PeopleInCourse {

    @EmbeddedId
    PeopleInCourseId peopleInCourseId;

    public PeopleInCourse(){}

    public PeopleInCourseId getPeopleInProjectId() {
        return peopleInCourseId;
    }

    public void setPeopleInCourseId(PeopleInCourseId peopleInCourseId) {
        this.peopleInCourseId = peopleInCourseId;
    }
}
