package com.AlertSystem.backendSiteDiplom.services;


import com.AlertSystem.backendSiteDiplom.models.PeopleInCourse;
import com.AlertSystem.backendSiteDiplom.models.PeopleInCourseId;
import com.AlertSystem.backendSiteDiplom.repositories.PeopleInCourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleInCourseService {
    private PeopleInCourseRepository peopleInPCourseRepository;

    public PeopleInCourseService(PeopleInCourseRepository peopleInCourseRepository) {
        this.peopleInPCourseRepository = peopleInCourseRepository;
    }

    @Transactional
    public void savePeopleInCourse(PeopleInCourse peopleInCourse){
        this.peopleInPCourseRepository.save(peopleInCourse);
    }
    @Transactional
    public void savePeopleInCourse(PeopleInCourseId peopleInCourseId){
        this.peopleInPCourseRepository.save(peopleInCourseId);
    }

    public List<PeopleInCourse> findCoursesByPeopleId(int idPeople){
        return this.peopleInPCourseRepository.findByPeopleInCourseIdIdPeople(idPeople);
    }
    public List<PeopleInCourse> findPeopleByCourseId(int idCourse){
        return this.peopleInPCourseRepository.findByPeopleInCourseIdIdCourse(idCourse);
    }

    public void removeByIdId(PeopleInCourseId peopleInCourseId){
        Optional<PeopleInCourse> people =
                this.peopleInPCourseRepository.findById(peopleInCourseId);
        if (!people.isEmpty())
            this.peopleInPCourseRepository.delete(people.get());
        else
            throw new NullPointerException("Человек не состоит в данном " +
                    "проекте");
    }
}
