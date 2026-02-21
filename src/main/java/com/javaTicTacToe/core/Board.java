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

    public Symbol update(Symbol symbol, Coord coord){
        Objects.requireNonNull(symbol);
        Objects.requireNonNull(coord);

        if(symbol == Symbol.NONE){
            throw new IllegalArgumentException("None cannot be added to board");
        }

        if(matrix[coord.i()][coord.j()] != Symbol.NONE){
            throw new IllegalArgumentException("Play is not possible");
        }
        matrix[coord.i()][coord.j()] = symbol;
        return findSequence();
    }


    private Symbol findSequence(){
        Symbol symbol = findSequenceInRows();
        if(symbol != null){
            return symbol;
        }

        symbol = findSequenceInColumns();
        if(symbol != null){
            return symbol;
        }

        symbol = findSequenceInCDiagonals();
        return symbol;
    }

    private Symbol findSequenceInRow(int i){
        if(matrix[i][0] == matrix[i][1]
                && matrix[i][1] == matrix[i][2]
                && matrix[i][0] != Symbol.NONE) {
            return matrix[i][0];
        }
        return null;

    }

    private Symbol findSequenceInRows(){
        for(int i = 0; i < SIZE; i++){
            Symbol symbol = findSequenceInRow(i);
            if(symbol != null){
                return symbol;
            }
        }

        return null;
    }

    private Symbol findSequenceInColumn(int j){
        if(matrix[0][j] == matrix[1][j]
                && matrix[1][j] == matrix[2][j]
                && matrix[0][j] != Symbol.NONE) {
            return matrix[0][j];
        }
        return null;

    }

    private Symbol findSequenceInColumns(){
        for(int j = 0; j < SIZE; j++){
            Symbol symbol = findSequenceInColumn(j);
            if(symbol != null){
                return symbol;
            }
        }
        return null;
    }




    private Symbol findSequenceInCDiagonals(){
        if(matrix[0][0] == matrix[1][1]
                && matrix[1][1] == matrix[2][2]
                && matrix[0][0] != Symbol.NONE) {
            return matrix[0][0];
        }

        if(matrix[0][2] == matrix[1][1]
                && matrix[1][1] == matrix[2][0]
                && matrix[0][2] != Symbol.NONE) {
            return matrix[0][2];
        }

        return null;
    }




    // tie game
    public boolean isFull(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(matrix[i][j] == Symbol.NONE){
                    return false;
                }
            }
        }
        return true;
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
