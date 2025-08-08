package com.atyeti.quizapp.mapper;

import com.atyeti.quizapp.dto.QuestionDto;
import com.atyeti.quizapp.model.Question;

public class QuestionMapper {

    public static QuestionDto toDto(Question question) {
        QuestionDto dto = new QuestionDto();
        dto.setQuestionTitle(question.getQuestion_title());
        dto.setOption1(question.getOption1());
        dto.setOption2(question.getOption2());
        dto.setOption3(question.getOption3());
        dto.setOption4(question.getOption4());
        dto.setRightAnswer(question.getRight_answer());
        dto.setDifficultyLevel(question.getDifficultylevel());
        dto.setCategory(question.getCategory());
        return dto;
    }

    public static Question toEntity(QuestionDto dto) {
        Question question = new Question();
        question.setQuestion_title(dto.getQuestionTitle());
        question.setOption1(dto.getOption1());
        question.setOption2(dto.getOption2());
        question.setOption3(dto.getOption3());
        question.setOption4(dto.getOption4());
        question.setRight_answer(dto.getRightAnswer());
        question.setDifficultylevel(dto.getDifficultyLevel());
        question.setCategory(dto.getCategory());
        return question;
    }
}