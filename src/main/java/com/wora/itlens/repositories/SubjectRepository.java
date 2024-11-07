package com.wora.itlens.repositories;

import com.wora.itlens.models.entites.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAllBySurveyEditionId(Long surveyEditionId);
}
