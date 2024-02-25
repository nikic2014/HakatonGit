package com.AlertSystem.backendSiteDiplom.services;

import com.AlertSystem.backendSiteDiplom.models.Grade;
import com.AlertSystem.backendSiteDiplom.repositories.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public void saveGrade(Grade grade){
        this.gradeRepository.save(grade);
    }

    public Grade findGreadByTaskPeople(int idTask,int idPeople){
        List<Grade> gradeList = this.gradeRepository.findByIdTask(idTask);

        for (int i=0;i<gradeList.size();i++){
            if (gradeList.get(i).getIdPeople() == idPeople){
                return gradeList.get(i);
            }
        }
        Grade grade = new Grade();
        grade.setIdPeople(idPeople);
        grade.setIdTask(idTask);
        grade.setGrade(0);
        this.gradeRepository.save(grade);
        return grade;
    }
}
