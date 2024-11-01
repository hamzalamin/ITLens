package com.wora.itlens.repositories;

import com.wora.itlens.models.entites.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
