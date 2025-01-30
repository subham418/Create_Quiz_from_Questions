package com.web.quiz.dao;

import com.web.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionDao extends JpaRepository<Question,Integer> {
    // this will automatically provide all methods
    // I can also define and implement my custom method here
    List<Question> findByCategory(String category);

    @Query(value = "select * from Question q where q.category=:category order by Rand() limit :numQ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
