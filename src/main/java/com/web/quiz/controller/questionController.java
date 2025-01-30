package com.web.quiz.controller;

import com.web.quiz.model.Question;
import com.web.quiz.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class questionController {
    @Autowired
    questionService  questionService=new questionService();
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestions();
    }
    @GetMapping("{id}")
    public Question getQuestionById(@PathVariable Integer id){
        return questionService.getByQuestionId(id);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
