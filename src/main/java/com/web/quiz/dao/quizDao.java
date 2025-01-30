package com.web.quiz.dao;

import com.web.quiz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface quizDao extends JpaRepository<Quiz,Integer> {
    // this will automatically provide all methods
    // I can also define and implement my custom method here
}
