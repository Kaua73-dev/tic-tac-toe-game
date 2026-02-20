package com.javaTicTacToe.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

public class Board {


    public static final int SIZE = 3;
    private final Symbol[][] matrix = new Symbol[SIZE][SIZE];


    public Board(){

            // control of lines
        for(int i = 0; i< matrix.length; i++){

            // control of collum
           for(int j = 0; j< matrix[i].length; j++){
            matrix[i][j] = Symbol.NONE;
           }
        }

    }

    public void update(Symbol symbol, Coord coord){
        Objects.requireNonNull(symbol);
        Objects.requireNonNull(coord);

        if(symbol == Symbol.NONE){
            throw new IllegalArgumentException("None cannot be added to board");
        }

        if(matrix[coord.i()][coord.j()] != Symbol.NONE){
            throw new IllegalArgumentException("Play is not possible");
        }
        matrix[coord.i()][coord.j()] = symbol;
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

            boolean first = true;
            for(int j = 0; j < SIZE; j++){
                // linha vertical que separa tabuleiro
                if(!first){
                    out.print(" | ");
                }
                // iteração
                out.print(matrix[i][j]);
                first = false;
            }
            out.println();

            // linha horizontal que separa tabuleiro
            if(i + 1 < SIZE){
                for(int j = 0; j < SIZE; j++){
                    out.print("---");
                }
            }
            out.println();
        }

        return sw.toString();

    }
}
