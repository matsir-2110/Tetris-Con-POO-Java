package com.mycompany.app;

public class PieceLL extends Tetris{
    private String posiciones[];

    public PieceLL(){
        super("oooooxoooxooxxoo");
    }


    public void movimientos(){
        posiciones[0] = "oooooxoooxooxxoo";
        posiciones[1] = "xoooxxxooooooooo";
        posiciones[2] = "ooxxooxoooxooooo";
        posiciones[3] = "oooooooooxxxooox";
    }
}

