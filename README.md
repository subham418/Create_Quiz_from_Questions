# Create_Quiz_from_Questions
- Initially this project has one DB (Question)
- Later on, one more DB will be created after Generating Quiz from questions only (Using POST).
- it has two controller, services and model (Quiz and Questions)
- Performed Operations are:-
- For Question
  1. http://localhost:8081/question/allQuestions - GET (this will return all questions)
  2. http://localhost:8081/question/id - GET (this will return question with that id)
  3. http://localhost:8081/question/category/{category} -  GET (will return all questions with given category,ex;- java, python)
  4. http://localhost:8081/question/add - POST (will add question to Question DB, taking JSON as RequestBody)
     
- For Quiz (Many to many , one id can have multiple questions and vice versa) 
  1. http://localhost:8081/quiz/create?category=?&numQ=?&title=? - POST (this will create DB of QUIZ, where ID and title will be changed every time).
  2. http://localhost:8081/quiz/get/id - GET (will return all questions with given quiz id)
  3. http://localhost:8081/quiz/submit/3 - POST (will return score based on answer correctness)
