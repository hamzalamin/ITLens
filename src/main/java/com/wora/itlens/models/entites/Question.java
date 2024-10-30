package com.wora.itlens.models.entites;


import com.wora.itlens.models.enumes.QuestionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "text", nullable = false)
    private String text;

    @NotNull
    @Column(name = "answer_count")
    private Integer answerCount;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

}
