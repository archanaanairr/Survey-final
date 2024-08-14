package com.pilotproject.SurveyMicro.Exceptions;

public class AssessmentNotFoundException extends RuntimeException{
    public AssessmentNotFoundException(String message) {
        super(message);
    }
}
