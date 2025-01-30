package com.web.quiz.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String questionTitle;
    @Column
    private String option1;
    @Column
    private String option2;
    @Column
    private String option3;
    @Column
    private String option4;
    @Column
    private String rightAnswer;
    @Column
    private String difficultyLevel;
    @Column
    private String category;
}
