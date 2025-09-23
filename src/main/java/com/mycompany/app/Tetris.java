package com.mycompany.app;

public abstract class Tetris {
    private String forma;
    private String nombre;
    private int fila;
    private int col;

    public Tetris(String formaInicial, String nombreP){
        setForma(formaInicial);
        setNombre(nombreP);
        setFila(0);
        setColumna(4); // centro inicial
    }

    public void setForma(String forma){
        this.forma = forma;
    }

    public String getForma() {
        return forma;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFila(){
        return fila;
    }
    public void setFila(int fila){
        this.fila = fila;
    }

    public int getColumna(){
        return col;
    }
    public void setColumna(int col){
        this.col = col;
    }

    // Baja una fila si no hay colisión
    public boolean bajar(Board board) {
        if (!hayColision(board, fila + 1, col)) {
            fila++;
            return true;
        }
        return false; // no puede bajar más
    }

    // Movimiento lateral
    public boolean moverIzquierda(Board board) {
        if (!hayColision(board, fila, col - 1)) {
            col--;
            return true;
        }
        return false;
    }
    public boolean moverDerecha(Board board) {
        if (!hayColision(board, fila, col + 1)) {
            col++;
            return true;
        }
        return false;
    }

    // Dibuja o borra en tablero
    private void aplicarEnTablero(Board board, char simbolo) {
        char[][] tab = board.getTablero();
        String[] filasPieza = getPosicionActual().split("\n");

        for (int i = 0; i < filasPieza.length; i++) {
            for (int j = 0; j < filasPieza[i].length(); j++) {
                if (filasPieza[i].charAt(j) == 'x') {
                    tab[fila + i][col + j] = simbolo;
                }
            }
        }
    }

    public void dibujarEnTablero(Board board) {
        aplicarEnTablero(board, 'x');
    }

    public void borrarDelTablero(Board board) {
        aplicarEnTablero(board, 'o');
    }

    // Chequea si habría colisión en la posición indicada
    public boolean hayColision(Board board, int filaNueva, int colNueva) {
        char[][] tab = board.getTablero();
        String[] filasPieza = getPosicionActual().split("\n");

        for (int i = 0; i < filasPieza.length; i++) {
            for (int j = 0; j < filasPieza[i].length(); j++) {
                if (filasPieza[i].charAt(j) == 'x') {
                    int f = filaNueva + i;
                    int c = colNueva + j;

                    // fuera de límites
                    if (f < 0 || f >= tab.length ||  c < 0 || c >= tab[0].length) {
                        return true;
                    }
                    // colisión con otra pieza
                    if (tab[f][c] == 'x') {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public abstract void rotarIzquierda();
    public abstract void rotarDerecha();
    public abstract String getPosicionActual();
}
