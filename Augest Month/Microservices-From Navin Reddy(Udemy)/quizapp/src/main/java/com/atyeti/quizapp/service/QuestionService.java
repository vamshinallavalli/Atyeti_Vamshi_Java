package com.atyeti.quizapp.service;

import com.atyeti.quizapp.dao.QuestionRepository;
import com.atyeti.quizapp.dto.QuestionDto;
import com.atyeti.quizapp.mapper.QuestionMapper;
import com.atyeti.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService{

    @Autowired
    private QuestionRepository questionRepository;


    public List<QuestionDto> getAllQuestions() {
       List<Question> questions= questionRepository.findAll();

       return questions.stream()
               .map(QuestionMapper::toDto)
               .collect(Collectors.toList());
    }
}