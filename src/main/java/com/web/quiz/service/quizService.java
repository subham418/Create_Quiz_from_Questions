package com.web.quiz.service;

import com.web.quiz.dao.questionDao;
import com.web.quiz.dao.quizDao;
import com.web.quiz.model.Question;
import com.web.quiz.model.Quiz;
import com.web.quiz.model.Response;
import com.web.quiz.model.questionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class quizService {
    @Autowired
    quizDao quizDao;
    @Autowired
    questionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<questionWrapper>> getQuizById(Integer id) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questions=quiz.get().getQuestions();
        List<questionWrapper> ans=new ArrayList<>();
        for(Question q:questions){
            questionWrapper questionWrapper=new questionWrapper(q.getId(),
                    q.getQuestionTitle(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4());
            ans.add(questionWrapper);
        }
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }

    public ResponseEntity<String> calculateScore(Integer id, List<Response> responses) {
        Quiz quiz=quizDao.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int right=0;
        int n=responses.size();
        for(int i=0;i<n;i++){
            if(responses.get(i).getResponse().equals(questions.get(i).getRightAnswer())) right+=1;
        }
        return new ResponseEntity<>("Your Score is "+right, HttpStatus.OK);
    }
}
