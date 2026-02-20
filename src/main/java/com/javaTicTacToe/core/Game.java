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

            String play = Input.read("Play ->");
            Coord coord = Coord.parse(play);
            board.update(players.next(), coord);


        }

    }




}
