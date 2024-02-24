package com.AlertSystem.backendSiteDiplom.repositories;


import com.AlertSystem.backendSiteDiplom.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    public Course findById(int idCourse);
}
