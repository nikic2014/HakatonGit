package com.AlertSystem.backendSiteDiplom.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PeopleInCourseId implements Serializable {
    @Column(name = "idCourse")
    private int idCourse;

    @Column(name = "idPeople")
    private int idPeople;

    public PeopleInCourseId(){}

    public PeopleInCourseId(int idCourse, int idPeople){
        this.idCourse = idCourse;
        this.idPeople = idPeople;
    }

    public int getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(int idPeople) {
        this.idPeople = idPeople;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PeopleInCourseId that = (PeopleInCourseId) o;

        return Objects.equals(this.idCourse, that.idCourse) &&
                Objects.equals(this.idPeople, that.idPeople);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.idCourse, this.idPeople);
    }
}
