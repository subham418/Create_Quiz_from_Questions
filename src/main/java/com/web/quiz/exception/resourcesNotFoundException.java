package com.web.quiz.exception;

public class resourcesNotFoundException extends RuntimeException{
    public resourcesNotFoundException(String message){
        super(message);
    }
}
