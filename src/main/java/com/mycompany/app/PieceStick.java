package com.mycompany.app;

public class PieceStick extends Tetris{
    private String posiciones[];


    public PieceStick(){
        super("xoooxoooxoooxooo");
    }

   public void movimientos(){
        posiciones[0] = "xoooxoooxoooxooo";
        posiciones[1] = "oxoooxoooxoooxoo";
   }

}
