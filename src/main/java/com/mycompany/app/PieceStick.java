package com.mycompany.app;

public class PieceStick extends Tetris{
    private String posiciones[];


    public PieceStick(){
        super("oxoooxoooxoooxoo", "Stick");
    }

   public void movimientos(){
        posiciones[0] = "oxoooxoooxoooxoo";
        posiciones[1] = "xxxxoooooooooooo";
   }

}