package com.javaTicTacToe.core;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Board {


    public static final int SIZE = 3;
    private final Symbol[][] matrix = new Symbol[SIZE][SIZE];


    public Board(){

        // control of lines
        for(int i = 0; i< matrix.length; i++){

        // control of collum
           for(int j = 0; j< matrix[i].length; j++){
            matrix[i][j] = Symbol.X;
           }
        }
    }

    @Override
    public String toString() {
        /*
            x | x | x
            ---------
            x | x | x
            ---------
            x | x | x
         */
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);

        for(int i = 0; i < SIZE; i++){

            for(int j = 0; j < SIZE; j++){
                out.print(matrix[i][j] + " ");
            }
        }

        return sw.toString();

    }
}
