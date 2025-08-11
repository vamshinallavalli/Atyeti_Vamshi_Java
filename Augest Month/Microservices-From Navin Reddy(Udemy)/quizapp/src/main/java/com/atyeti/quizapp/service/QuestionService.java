package com.atyeti.quizapp.service;

import com.atyeti.quizapp.dao.QuestionDao;
import com.atyeti.quizapp.dto.QuestionDto;
import com.atyeti.quizapp.mapper.QuestionMapper;
import com.atyeti.quizapp.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuestionService{

    private static final Logger logger=LoggerFactory.getLogger(QuestionService.class);

    @Autowired
    private QuestionDao questionDao;


//    public List<QuestionDto> getAllQuestions() {
//       List<Question> questions= questionRepository.findAll();
//
//       return questions.stream()
//               .map(QuestionMapper::toDto)
//               .collect(Collectors.toList());
//    }
public ResponseEntity<List<Question>> getAllQuestions() {
    try {
        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
    }catch (Exception e){
        e.printStackTrace();
    }
    return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
}

//    public List<Question> getByCategory(String category) {
//        List<Question> questions = questionRepository.findAll();
//        return questions.stream()
//                .filter(s -> s.getCategory().equalsIgnoreCase(category))
//                .collect(Collectors.toList());
//    }

    public List<Question> getByCategory(String category) {
    return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        if (question == null
                || question.getQuestion_title() == null || question.getQuestion_title().isBlank()
                || question.getOption1() == null || question.getOption2() == null
                || question.getOption3() == null || question.getOption4() == null
                || question.getRight_answer() == null || question.getRight_answer().isBlank()
                || question.getCategory() == null || question.getCategory().isBlank()) {

            logger.error("Failed to add question - validation failed: {}", question);
            return "Failed to add question: missing required fields";
        }

        questionDao.save(question);
        logger.info("Question added successfully: {}", question);
        return "success";
    }


    public String deleteQuestionById(Long id) {
    questionDao.deleteById(id);
        logger.info("Deleted question with id: {}", id);
    return "Successfully deleted";
    }

    public String updateQuestionById(Long id, QuestionDto questionDto) {
        if (!questionDao.existsById(id)) {
            logger.warn("Question with ID {} not found", id);
            return "Question not found";
        }
        Question question = QuestionMapper.toEntity(questionDto);
        question.setId(id);
        questionDao.save(question);

        logger.info("Question successfully updated with id: {}", id);
        return "Question successfully updated";
    }

    public List<Question> getById(Long id) {
    return questionDao.getQuestionById(id);
    }
}