package com.mycompany.app;

public class PieceDogR extends Tetris{
    private String posiciones[];
    
    public PieceDogR(){
            super("oooo oooo oxxo xxoo");
    }

    public void movimientos(){
        posiciones[0]= "oooooooooxxoxxoo";
        posiciones[1]= "oooooxooxxooxooo";
    }

}
