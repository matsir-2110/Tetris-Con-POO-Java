package com.mycompany.app;

public class PieceT extends Tetris{
    private String posiciones[];
    private int rotacionActual = 0;
    
    public PieceT(){
        super("oooo\n" + "oxoo\n" + "xxxo\n" + "oooo", "T");
    }

    public void movimientos(){
        posiciones[0] = "oooo\n"+
                        "oxoo\n"+
                        "xxxo\n"+
                        "oooo";
        posiciones[1] = "oooo\n"+
                        "xooo\n"+
                        "xxoo\n"+
                        "xooo";
        posiciones[2] = "oooo\n"+
                        "xxxo\n"+
                        "oxoo\n"+
                        "oooo";
        posiciones[3] = "oooo\n"+
                        "oxoo\n"+
                        "xxoo\n"+
                        "oxoo";
   }

   @Override
    public String getPosicionActual() {
        return posiciones[rotacionActual];
    }

    @Override
    public void rotarIzquierda() {
        rotacionActual = (rotacionActual - 1 + posiciones.length ) % posiciones.length;
    }

    @Override
    public void rotarDerecha() {
        rotacionActual = (rotacionActual + 1) % posiciones.length;
    }

    public int getRotacionActual() {
        return rotacionActual;
    }
}
