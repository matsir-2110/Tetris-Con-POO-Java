package com.mycompany.app;

public class Board {
    private char[][] tablero;

    public Board() {
        setTablero(new char[10][20]);
    }
    

    public Board(int filas, int columnas) {
        tablero = new char[filas][columnas];
        for (int f = 0; f < filas; f++)
            for (int c = 0; c < columnas; c++)
                tablero[f][c] = 'o';
    }

    public char[][] getTablero(){
        return tablero;
    }
    public void setTablero(char[][] tablero){
        this.tablero = tablero;
    }

    public int filas(){
        return tablero.length;
    }
    
    public int columnas(){
        return tablero[0].length;
    }

    // colision
    public boolean colisiona(String forma, int fila, int columna) {
        String[] lineas = forma.split("\n");
        for (int i = 0; i < lineas.length; i++) {
            for (int j = 0; j < lineas[i].length(); j++) {
                if (lineas[i].charAt(j) == 'x') {
                    int filaFinal = fila + i;
                    int columnaFinal = columna + j;
                    if (filaFinal >= filas() || filaFinal < 0 || columnaFinal < 0 || columnaFinal >= columnas()) {
                        return true;
                    }
                    if (tablero[filaFinal][columnaFinal] == 'x') {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // deja la forma original de la pieza en el tablero
    public void fijar(String forma, int fila, int columna) {
        String[] lineas = forma.split("\n");
        for (int i = 0; i < lineas.length; i++) {
            for (int j = 0; j < lineas[i].length(); j++) {
                if (lineas[i].charAt(j) == 'x') {
                    tablero[fila + i][columna + j] = 'x';
                }
            }
        }
    }

    // cuenta filas completas
    public int lineCount() {
        int contador = 0;
        for (int fila = 0; fila < filas(); fila++) {
            boolean completa = true;
            for (int columna = 0; columna < columnas(); columna++) {
                if (tablero[fila][columna] == 'o'){
                    completa = false; 
                    break;
                }
            }
            if(completa){
                contador++;
            }
        }
        return contador;
    }

    // Elimina líneas completas y hace caer las superiores. Retorna el número eliminado.
    public int limpiarLineas() {
        int eliminadas = 0;
        for (int fila = filas() - 1; fila >= 0; fila--) {
            boolean completa = true;
            for (int columna = 0; columna < columnas(); columna++) {
                if (tablero[fila][columna] == 'o') {
                    completa = false;
                    break;
                }
            }
            if (completa) {
                eliminadas++;
                // Hacer caer las filas superiores
                for (int filaArriba = fila; filaArriba > 0; filaArriba--) {
                    tablero[filaArriba] = tablero[filaArriba - 1].clone();
                }
                // Limpia la fila superior
                for (int columna = 0; columna < columnas(); columna++) {
                    tablero[0][columna] = 'o';
                }
                fila++; // Re-chequea esta fila después de shift
            }
        }
        return eliminadas;
    }
}