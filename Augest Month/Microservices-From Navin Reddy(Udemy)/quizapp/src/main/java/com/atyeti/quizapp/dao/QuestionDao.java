package com.atyeti.quizapp.dao;

import com.atyeti.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Long> {

    List<Question> findByCategory(String category);

    List<Question> getQuestionById(Long id);


    @Query("SELECT COALESCE(MAX(q.id), 0) FROM Question q")
    Long findMaxId();
}