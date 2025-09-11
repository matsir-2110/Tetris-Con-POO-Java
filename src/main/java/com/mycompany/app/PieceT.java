package com.mycompany.app;

public class PieceT extends Tetris{
    private String posiciones[];
    
    public PieceT(){
        super("oooooxooxxxooooo");
    }

    public void movimientos(){
        posiciones[0] = "oooooxooxxxooooo";
        posiciones[1] = "ooooxoooxxooxooo";
        posiciones[2] = "ooooxxxooxoooooo";
        posiciones[3] = "oooooxooxxoooxoo";
   }

}
