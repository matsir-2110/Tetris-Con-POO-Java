package com.mycompany.app;

public class PieceSquare extends Tetris{
    private String posiciones[];
    private int rotacionActual = 0;

    public PieceSquare(){
        super("ooooooooxxooxxoo", "Square");
    }

    @Override
    public String getPosicionActual() {
        return posiciones[rotacionActual];
    }

    @Override
    public void rotarIzquierda() {
        rotacionActual = 0;
    }

    @Override
    public void rotarDerecha() {
        rotacionActual = 0;
    }

    public int getRotacionActual() {
        return rotacionActual;
    }
}
