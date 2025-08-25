package com.atyeti.quizapp.service;

import com.atyeti.quizapp.dao.QuestionDao;
import com.atyeti.quizapp.dto.QuestionDto;
import com.atyeti.quizapp.exception.QuestionNotFoundException;
import com.atyeti.quizapp.mapper.QuestionMapper;
import com.atyeti.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getByCategory(String category) {
        List<Question> questions=questionDao.findByCategory(category);
        if(questions.isEmpty()){
            throw new QuestionNotFoundException("No questions found in category: "+category);
        }
        return questions;
    }

    public boolean addQuestion(Question question) {

        if(question.getQuestion_title()==null || question.getQuestion_title().isBlank()){
            throw new IndexOutOfBoundsException("Question title cannot be empty");
        }
        questionDao.save(question);
        return true;
    }

    public boolean deleteQuestionById(Long id) {
        if (!questionDao.existsById(id)) {
            throw new QuestionNotFoundException("No question found with id: "+id);
        }
            questionDao.deleteById(id);
            return true;
    }



    public List<Question> getById(Long id) {
        List<Question> questions=questionDao.getQuestionById(id);

        if(questions.isEmpty()){
        throw new QuestionNotFoundException("No question found with id: "+id);
        }
        return questions;
    }

    public boolean updateQuestionById(Long id, QuestionDto dto) {
        Question existing = questionDao.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("No question found with id: " + id));

        Question updated = QuestionMapper.toEntity(dto);

        updated.setId(existing.getId());

        questionDao.save(updated);
        return true;
    }

    public Question saveQuestion(Question question) {
        if (question.getId() == null) {
            Long nextId = questionDao.findMaxId() + 1;
            question.setId(nextId);
        }
        return questionDao.save(question);
    }
}