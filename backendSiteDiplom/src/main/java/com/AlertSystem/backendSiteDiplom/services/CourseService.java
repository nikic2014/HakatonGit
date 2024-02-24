package com.AlertSystem.backendSiteDiplom.services;


import com.AlertSystem.backendSiteDiplom.models.Course;
import com.AlertSystem.backendSiteDiplom.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CourseService {
    private final CourseRepository CourseRepository;

    public CourseService(CourseRepository CourseRepository) {
        this.CourseRepository = CourseRepository;
    }

    public void saveCourse(Course Course){
        this.CourseRepository.save(Course);
    }

    public Course findByIdCourse(int idCourse){
        return this.CourseRepository.findById(idCourse);
    }
}
