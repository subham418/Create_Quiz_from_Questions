package com.web.quiz.controller;

import com.web.quiz.model.Response;
import com.web.quiz.model.questionWrapper;
import com.web.quiz.service.quizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class quizController {
    @Autowired
    quizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<questionWrapper>> getQuizById(@PathVariable Integer id){
        return quizService.getQuizById(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<String> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateScore(id,responses);
    }
}
