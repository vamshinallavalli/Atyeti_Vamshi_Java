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

        existing.setQuestion_title(dto.getQuestionTitle());
        existing.setOption1(dto.getOption1());
        existing.setOption2(dto.getOption2());
        existing.setOption3(dto.getOption3());
        existing.setOption4(dto.getOption4());
        existing.setRight_answer(dto.getRightAnswer());
        existing.setDifficultylevel(dto.getDifficultyLevel());
        existing.setCategory(dto.getCategory());

        questionDao.save(existing);
        return true;
    }


}