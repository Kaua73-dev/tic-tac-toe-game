package com.javaTicTacToe.core;

import java.util.Objects;

public record Coord(int j, int i) {

    public static Coord parse(String text){
        Objects.requireNonNull(text);


        String[] tokens = text.split(",");

        if(tokens.length != 2){
            throw new IllegalArgumentException("Invalid format");
        }

        try {
            return new Coord(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));

        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid number");
        }

    }

}
