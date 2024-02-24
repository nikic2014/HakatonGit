package com.AlertSystem.backendSiteDiplom.repositories;

import com.AlertSystem.backendSiteDiplom.models.PeopleInCourse;
import com.AlertSystem.backendSiteDiplom.models.PeopleInCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleInCourseRepository extends JpaRepository<PeopleInCourse, PeopleInCourseId> {

    List<PeopleInCourse> findByPeopleInCourseIdIdPeople(int idPeople);
    List<PeopleInCourse> findByPeopleInCourseIdIdCourse(int idCourse);
}
