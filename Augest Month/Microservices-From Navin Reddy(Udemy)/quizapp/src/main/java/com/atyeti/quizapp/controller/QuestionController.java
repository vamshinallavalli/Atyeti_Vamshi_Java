package com.atyeti.quizapp.controller;


import com.atyeti.quizapp.dto.QuestionDto;
import com.atyeti.quizapp.model.Question;
import com.atyeti.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Get all questions
    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
       List<Question> question= questionService.getAllQuestions().getBody();
       return ResponseEntity.ok(question);
    }

    // Get questions filtered by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getByCategory(@PathVariable String category) {
        List<Question> questions = questionService.getByCategory(category);
        return ResponseEntity.ok(questions);
    }

    // Get by id
    @GetMapping("/{id}")
    public List<Question> getById(@PathVariable Long id) {
        return questionService.getById(id);
    }

    // Add a new question
    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    // Deleting Question by ID
    @DeleteMapping("/delete/{id}")
    public String deleteQuestionById(@PathVariable Long id) {
        return questionService.deleteQuestionById(id);
    }

    // Update Question Using ID
    @PutMapping("/update/{id}")
    public String updateQuestionById(@PathVariable Long id,@RequestBody QuestionDto question){
        return questionService.updateQuestionById(id,question);
    }
}