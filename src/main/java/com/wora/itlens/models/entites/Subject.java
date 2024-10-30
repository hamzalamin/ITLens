package com.wora.itlens.models.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "subjects")
public class Subject {
    @Id
    @Positive
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "title")
    private String title;

    @ManyToOne
    @NotNull
    private SurveyEdition surveyEdition;

    @ManyToOne
    private Subject subject;
}
