package com.atyeti.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "question")
@Data
@Getter
@Setter
public class Question {

    @Id
    private Long id;
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String question_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String right_answer;
    private String difficultylevel;
    private String category;

}