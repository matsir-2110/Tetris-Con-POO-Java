package com.mycompany.app;

public class PieceLL extends Tetris{
    private String [] posiciones;
    private int rotacionActual = 0;

    public PieceLL(){
        super("oooo\n" + "oxoo\n" + "oxoo\n" + "xxoo", "LL");

        posiciones = new String [4];

        posiciones[0] = "oooo\n"+
                        "oxoo\n"+
                        "oxoo\n"+
                        "xxoo";
        posiciones[1] = "xooo\n"+
                        "xxxo\n"+
                        "oooo\n"+
                        "oooo";
        posiciones[2] = "ooxx\n"+
                        "ooxo\n"+
                        "ooxo\n"+
                        "oooo";
        posiciones[3] = "oooo\n"+
                        "oooo\n"+
                        "oxxx\n"+
                        "ooox";

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

