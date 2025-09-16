package com.mycompany.app;

public class PieceLL extends Tetris{
    private String [] posiciones;
    private int rotacionActual = 0;

    public PieceLL(){
        super("oooooxoooxooxxoo", "LL");

        posiciones = new String [4];

        posiciones[0] = "oooooxoooxooxxoo";
        posiciones[1] = "xoooxxxooooooooo";
        posiciones[2] = "ooxxooxoooxooooo";
        posiciones[3] = "oooooooooxxxooox";

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
        rotacionActual = (rotacionActual + 1) % posiciones.length;
    }
    public int getRotacionActual() {
        return rotacionActual;
    }


    
}

