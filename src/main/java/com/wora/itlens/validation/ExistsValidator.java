package com.wora.itlens.validation;

import com.wora.itlens.annotations.Exists;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;


@Component
public class ExistsValidator implements ConstraintValidator<Exists, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> entity;
    private String field;

    @Override
    public void initialize(Exists constraintAnnotation){
        this.entity = constraintAnnotation.entity();
        this.field = constraintAnnotation.field();
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context){
        if (id == null) return true;
        String queryStr = "SELECT count(e) FROM " + entity.getName() + " e WHERE e." + field + " = :id";
        Query query = entityManager.createQuery(queryStr);
        query.setParameter("id" , id);
        Long count = (Long) query.getSingleResult();
        return count != null && count > 0;
    }
}
