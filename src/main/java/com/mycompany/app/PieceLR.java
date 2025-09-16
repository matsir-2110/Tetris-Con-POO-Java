package com.mycompany.app;

public abstract class PieceLR extends Tetris{ 
    private String posiciones[];

    public PieceLR() {
        super("ooooxoooxoooxxoo", "LR");
    }

    public void movimientos(){
        posiciones[0] = "ooooxoooxoooxxoo";
        posiciones[1] = "xxxoxooooooooooo";
        posiciones[2] = "ooxxoooxoooxoooo";
        posiciones[3] = "oooooooooooxoxxx";

    }
}
