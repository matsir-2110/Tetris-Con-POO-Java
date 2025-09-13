package com.mycompany.app;

public class Board {
    private String[][] tablero;

    public Board() {
        tablero = new String[20][10];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = "o";
            }
        }
    }

    public String[][] getTablero() {
        return tablero;
    }

}
