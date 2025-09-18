package com.mycompany.app;

public class Board {
    private char[][] tablero;
    public int length;

    public Board() {
        tablero = new char[10][20];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                tablero[i][j] = 'o';
            }
        }
    }

    public char[][] getTablero() {
        return tablero;
    }

}
