package com.atyeti.quizapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("question_title")
    @Column(name="question_title")
    private String question_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @JsonProperty("right_answer")
    @Column(name="right_answer")
    private String right_answer;

    @JsonProperty("difficultylevel")
    @Column(name="difficultylevel")
    private String difficultylevel;
    private String category;

}