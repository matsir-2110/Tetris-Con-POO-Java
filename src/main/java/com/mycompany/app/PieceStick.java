package com.mycompany.app;

public class PieceStick extends Tetris{
    private String posiciones[];
    

    public PieceStick(){
        super("oxoooxoooxoooxoo", "Stick");
        posiciones = new String[2]; 
        posiciones[0] = "oxoooxoooxoooxoo";
        posiciones[1] = "xxxxoooooooooooo";
    }

    private int rotacionActual = 0;
    public String getPosicionActual() {
        return posiciones[rotacionActual];
    }

    @Override
    public void rotarIzquierda() {
        rotacionActual = (rotacionActual + 1) % posiciones.length;
    }

    public void rotarDerecha() {
        rotacionActual = (rotacionActual + 1) % posiciones.length;
    }

    public int getRotacionActual() {
        return rotacionActual;
    }

}
