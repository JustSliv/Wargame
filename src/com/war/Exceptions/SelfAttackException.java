package com.war.Exceptions;

public class SelfAttackException extends Exception{

    public SelfAttackException(String errorMessage){
        super(errorMessage);
    }
}
