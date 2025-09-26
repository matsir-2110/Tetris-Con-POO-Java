package com.mycompany.app;

public class Board {
    private char[][] tablero;

    public Board(){
        this(10, 20); 
    }

    public Board(int fila, int columna) {
        tablero = new char[fila][columna];
        for (int f = 0; f < fila; f++)
            for (int c = 0; c < columna; c++)
                tablero[f][c] = 'o';
    }

    public char[][] getTablero(){
        return tablero;
    }

    public int rows(){
        return tablero.length;
    }
    
    public int cols(){
        return tablero[0].length;
    }

    // colision
    public boolean collides(String forma, int fila, int col) {
        String[] lineas = forma.split("\n");
        for (int i = 0; i < lineas.length; i++) {
            for (int j = 0; j < lineas[i].length(); j++) {
            if (lineas[i].charAt(j) == 'x') {
                int ff = fila + i;
                int cc = col + j;
                if (ff >= rows() || ff < 0 || cc < 0 || cc >= cols()) {
                    return true;
                }
                if (tablero[ff][cc] == 'x') {
                    return true;
                }
            }
            }
        }
        return false;
    }

    // deja la forma en el tablero
    public void fix(String forma, int fila, int col) {
        String[] lineas = forma.split("\n");
        for (int i = 0; i < lineas.length; i++) {
            for (int j = 0; j < lineas[i].length(); j++) {
                if (lineas[i].charAt(j) == 'x') {
                    tablero[fila + i][col + j] = 'x';
                }
            }
        }
    }

    // cuenta filas completas
    public int lineCount() {
        int cont = 0;
        for (int r = 0; r < rows(); r++) {
            boolean full = true;
            for (int c = 0; c < cols(); c++) {
                if (tablero[r][c] == 'o'){
                    full = false; 
                    break;
                }
            }
            if(full == true){
                cont++;
            }
        }
        return cont;
    }
}