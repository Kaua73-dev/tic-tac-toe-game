package com.javaTicTacToe.core;

import java.util.Arrays;

public class Board {


    public static final int SIZE = 3;
    private final Symbol[][] matrix = new Symbol[SIZE][SIZE];


    public Board(){

        // control of lines
        for(int i = 0; i< matrix.length; i++){

        // control of collum
           for(int j = 0; j< matrix[i].length; i++){
            matrix[i][j] = Symbol.NONE;
           }
        }
    }

    @Override
    public String toString() {
        /*
            x | x | x
            x | x | x
            x | x | x
         */


    }
}
