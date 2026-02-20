package com.javaMySQL.core;

public class Game {
    private final Board board = new Board();
    private final Players players = new Players();

    public void start(){
        System.out.println("Game Started!");
        System.out.println("-----------");

        System.out.println(players.next());
        System.out.println(players.next());
        System.out.println(players.next());
        System.out.println(players.next());

    }




}
