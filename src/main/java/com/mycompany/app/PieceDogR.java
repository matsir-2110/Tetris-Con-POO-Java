package com.mycompany.app;

public class PieceDogR extends Tetris{
    private final String  posiciones[];
    private int rotacionActual = 0;

    public PieceDogR(){
            super("oooooooooxxoxxoo", "DogR");

        posiciones = new String [2];

        posiciones[0]= 
            "oooo\n" +
            "oooo\n" +
            "oxxo\n" +
            "xxoo";
        posiciones[1]= 
            "xooo\n" +
            "xxoo\n" +
            "oxoo\n" +
            "oooo";
        }

    @Override
    public String getPosicionActual() {
        return posiciones[rotacionActual];
    }

    @Override
    public void rotarIzquierda(){
        rotacionActual = (rotacionActual -1 + posiciones.length) % posiciones.length;
    }

    @Override
    public void rotarDerecha(){
        rotacionActual = (rotacionActual + 1) %posiciones.length;
    }

    public int getRotacionActual() {
        return rotacionActual;
    }

}
