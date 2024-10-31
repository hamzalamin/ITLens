package com.wora.itlens.repositories;

import com.wora.itlens.models.entites.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
