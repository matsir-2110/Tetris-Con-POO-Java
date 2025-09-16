package com.mycompany.app;

public class PieceDogR extends Tetris{
    private final String [] posiciones;
    private int rotacionActual = 0;

    public PieceDogR(){
            super("oooooooooxxoxxoo", "DogR");

        posiciones = new string [2];

        posiciones[0]= "oooooooooxxoxxoo";
        posiciones[1]= "xoooxxoooxoooooo";
    }

    @Override
    public string getPosicionActual() {
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
