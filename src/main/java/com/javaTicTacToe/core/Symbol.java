package com.javaTicTacToe.core;

public enum Symbol {
    X('X'),
    O('O'),
    NONE(' ');

    private final char charSymbol;
    Symbol(char charSymbol){
        this.charSymbol = charSymbol;
    }

    // sobrescrito para retornar o construtor de NONE;
    @Override
    public String toString() {
        return String.valueOf(charSymbol);
    }


}
