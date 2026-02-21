package com.javaTicTacToe.core;

import com.javaTicTacToe.io.Input;
import com.javaTicTacToe.io.Output;

public class Game {
    private final Board board = new Board();
    private final Players players = new Players();

    public void start(){
        System.out.println("Game Started!");


    Symbol winner = null;


        while(winner == null && !board.isFull()){
            Output.write(board);
            Output.writeNewLine();

          winner = play(players.next());

        }

        Output.write(board);

        if(board.isFull()){
            Output.write("With no winner, it was a toe");
        } else {
            Output.write(String.format("'%s' is the winner!", winner));
        }

    }

    private Symbol play(Symbol symbol){
        while(true) {
            try{
                String play = Input.read(String.format("'%s' Play ->", symbol));
                Coord coord = Coord.parse(play);
                return board.update(symbol, coord);
            } catch (RuntimeException e){
                Output.write("ERROR: " + e.getMessage());
            }

        }


    }

}
