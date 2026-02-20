package com.javaTicTacToe.core;

import com.javaTicTacToe.io.Input;
import com.javaTicTacToe.io.Output;

public class Game {
    private final Board board = new Board();
    private final Players players = new Players();

    public void start(){
        System.out.println("Game Started!");



        while(true){
            Output.write(board);
            Output.writeNewLine();

           play(players.next());

        }

    }


    private void play(Symbol symbol){
        while(true) {
            try{
                String play = Input.read(String.format("'%s' Play ->", symbol));
                Coord coord = Coord.parse(play);
                board.update(symbol, coord);
                break;
            } catch (RuntimeException e){
                Output.write("ERROR: " + e.getMessage());
            }

        }


    }

}
