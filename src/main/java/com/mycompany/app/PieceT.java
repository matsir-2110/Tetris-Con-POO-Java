package com.mycompany.app;

public class PieceT extends Tetris{
    private String posiciones[];
    
    public PieceT(){
        super("oooooooooxooxxxo");
    }

    public void movimientos(){
        posiciones[0] = "oooooooooxooxxxo";
        posiciones[1] = "ooooxoooxxooxooo";
        posiciones[2] = "ooooxxxooxoooooo";
        posiciones[3] = "oooooxooxxoooxoo";
   }

}
