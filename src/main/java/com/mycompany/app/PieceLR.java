package com.mycompany.app;

public class PieceLR extends Tetris{ 
    private String posiciones[];
    private int rotacionActual = 0;


    public PieceLR() {
        super("ooooxoooxoooxxoo", "LR");
        posiciones = new String [4];

        posiciones[0] = "ooooxoooxoooxxoo";
        posiciones[1] = "xxxoxooooooooooo";
        posiciones[2] = "ooxxoooxoooxoooo";
        posiciones[3] = "oooooooooooxoxxx";

    }

    @Override
    public String getPosicionActual() {
        return posiciones[rotacionActual];
    }

    @Override
    public void rotarIzquierda(){
        rotacionActual = (rotacionActual - 1 + posiciones.length) % posiciones.length;
    }

    @Override
    public void rotarDerecha(){
        rotacionActual = (rotacionActual +1) % posiciones.length;

    }
}
