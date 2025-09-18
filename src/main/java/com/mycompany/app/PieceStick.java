package com.mycompany.app;

public class PieceStick extends Tetris{
    private String posiciones[];
    

    public PieceStick(){
        super("oxoo\n" + "oxoo\n" + "oxoo\n" + "oxoo", "Stick");
        
        posiciones = new String[2]; 
        posiciones[0] = "oxoo\n"+
                        "oxoo\n"+
                        "oxoo\n"+
                        "oxoo";
        posiciones[1] = "xxxx\n"+
                        "oooo\n"+
                        "oooo\n"+
                        "oooo";
    }

    private int rotacionActual = 0;
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
