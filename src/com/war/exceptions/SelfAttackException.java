package com.war.exceptions;

public class SelfAttackException extends Exception{

    public SelfAttackException(String errorMessage){
        super(errorMessage);
    }
}
