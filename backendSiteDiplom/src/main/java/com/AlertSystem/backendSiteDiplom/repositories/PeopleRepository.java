package com.AlertSystem.backendSiteDiplom.repositories;

import com.AlertSystem.backendSiteDiplom.models.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
    Optional<People> findByLogin(String login);
}
