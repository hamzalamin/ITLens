package com.wora.itlens.models.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    @JoinColumn(name = "survey_edition_id" , nullable = true)
    private SurveyEdition surveyEdition;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false, columnDefinition = "integer default 0")
    private Subject subject;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Subject> subSubjects;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    @NotNull
    private List<Question> questions;
}
