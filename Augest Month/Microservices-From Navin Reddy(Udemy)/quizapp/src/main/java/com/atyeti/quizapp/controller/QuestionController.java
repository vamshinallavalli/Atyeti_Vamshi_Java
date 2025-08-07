package com.atyeti.quizapp.controller;

import com.atyeti.quizapp.dto.QuestionDto;
import com.atyeti.quizapp.model.Question;
import com.atyeti.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
class QuestionController{

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public List<QuestionDto> getAllQuestions(){
        return questionService.getAllQuestions();
    }
}