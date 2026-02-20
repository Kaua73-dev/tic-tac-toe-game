package com.javaTicTacToe.util;

public final class ValidationUtils {

    private ValidationUtils(){}


    public void require(boolean condition, String errorMessage){
        if(!condition){
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
