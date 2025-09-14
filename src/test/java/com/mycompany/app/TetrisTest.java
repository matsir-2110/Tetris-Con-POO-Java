package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TetrisTest {
    
    @Test
    public void cantidadPiezasTest(){

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

    @Test
    public void moverAbajoTest(){
        PieceActual pdog1 = new PieceActual(new PieceDogL());

        assertEquals(0, pdog1.getFila());

        pdog1.moveDown(5);
        assertEquals(5, pdog1.getFila());
    }

    @Test
    public void moverDerechaTest(){
        PieceActual pdog1 = new PieceActual(new PieceDogL());

        assertEquals(5, pdog1.getColumna());

        pdog1.moveRight(3);
        assertEquals(8, pdog1.getColumna());
    }

    @Test
    public void moverIzquierdaTest(){
        PieceActual pdog1 = new PieceActual(new PieceDogL());

        assertEquals(5, pdog1.getColumna());

        pdog1.moveLeft(2);
        assertEquals(3, pdog1.getColumna());
    }





}
