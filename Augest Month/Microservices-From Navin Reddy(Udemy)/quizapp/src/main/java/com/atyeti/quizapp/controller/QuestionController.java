package com.atyeti.quizapp.controller;


import com.atyeti.quizapp.dto.QuestionDto;
import com.atyeti.quizapp.model.Question;
import com.atyeti.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/question")
class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(questionService.getByCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Question>> getById(@PathVariable Long id) {
        List<Question> result = questionService.getById(id);
        return result.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question) ?
                ResponseEntity.status(HttpStatus.CREATED).body("Question added") :
                ResponseEntity.badRequest().body("Failed to add question");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable Long id) {
        return questionService.deleteQuestionById(id) ?
                ResponseEntity.ok("Deleted") :
                ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateQuestionById(@PathVariable Long id,
                                                     @RequestBody QuestionDto question) {
        return questionService.updateQuestionById(id, question) ?
                ResponseEntity.ok("Updated") :
                ResponseEntity.notFound().build();
    }
}