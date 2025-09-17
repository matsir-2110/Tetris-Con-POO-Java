package com.mycompany.app;

public class PieceT extends Tetris{
    private String posiciones[];
    private int rotacionActual = 0;
    
    public PieceT(){
        super("oooooxooxxxooooo", "T");
    }

    public void movimientos(){
        posiciones[0] = "oooooxooxxxooooo";
        posiciones[1] = "ooooxoooxxooxooo";
        posiciones[2] = "ooooxxxooxoooooo";
        posiciones[3] = "oooooxooxxoooxoo";
   }

   @Override
    public String getPosicionActual() {
        return posiciones[rotacionActual];
    }

    @Override
    public void rotarIzquierda() {
        rotacionActual = (rotacionActual + 1) % posiciones.length;
    }

    @Override
    public void rotarDerecha() {
        rotacionActual = (rotacionActual + 1) % posiciones.length;
    }

    public int getRotacionActual() {
        return rotacionActual;
    }
}
