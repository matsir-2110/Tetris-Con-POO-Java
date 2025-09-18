package com.mycompany.app;

public class PieceSquare extends Tetris{
    private String posiciones[];
    private int rotacionActual = 0;

    public PieceSquare(){
        super("oooo\n" + "oooo\n" + "xxoo\n" + "xxoo", "Square");

        posiciones = new String[1];
        
        posiciones[0] =
            "oooo\n" +
            "oooo\n" +
            "xxoo\n" +
            "xxoo";
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
