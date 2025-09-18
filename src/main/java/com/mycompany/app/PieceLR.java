package com.mycompany.app;

public class PieceLR extends Tetris{ 
    private String posiciones[];
    private int rotacionActual = 0;


    public PieceLR() {
        super("oooo\n" + "xooo\n" + "xooo\n" + "xxoo", "LR");
        posiciones = new String [4];

        posiciones[0] = "oooo\n"+
                        "xooo\n"+
                        "xooo\n"+
                        "xxoo";
        posiciones[1] = "xxxo\n"+
                        "xooo\n"+
                        "oooo\n"+
                        "oooo";
        posiciones[2] = "ooxx\n"+
                        "ooox\n"+
                        "ooox\n"+
                        "oooo";
        posiciones[3] = "oooo\n"+
                        "oooo\n"+
                        "ooox\n"+
                        "oxxx";

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
