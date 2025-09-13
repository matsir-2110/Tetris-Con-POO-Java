package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TetrisTest {
    
    @Test
    public void cantidadPiezas(){

        ArrayList<Tetris> piezas = new ArrayList<Tetris>();

        piezas.add(new PieceDogL());
        piezas.add(new PieceDogR());
        piezas.add(new PieceLL());
        piezas.add(new PieceLR());
        piezas.add(new PieceSquare());
        piezas.add(new PieceStick());
        piezas.add(new PieceT());

        assertEquals(7, piezas.size());
    }
}
