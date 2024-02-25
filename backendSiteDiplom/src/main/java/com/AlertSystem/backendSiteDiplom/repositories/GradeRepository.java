package com.AlertSystem.backendSiteDiplom.repositories;

import com.AlertSystem.backendSiteDiplom.models.Grade;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer>{

    public List<Grade> findByIdTask(int idTask);
}
