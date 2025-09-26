package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class TetrisTest {
    
    @Test
    public void contarLineasTest() {
        Board board = (new Board(10, 20));

        PieceSquare c1 = new PieceSquare();
        PieceSquare c2 = new PieceSquare();
        PieceSquare c3 = new PieceSquare();
        PieceSquare c4 = new PieceSquare();
        PieceSquare c5 = new PieceSquare();
        PieceSquare c6 = new PieceSquare();
        PieceSquare c7 = new PieceSquare();
        PieceSquare c8 = new PieceSquare();
        PieceSquare c9 = new PieceSquare();
        PieceSquare c10 = new PieceSquare();
        c1.setColumna(0);
        c2.setColumna(2);
        c3.setColumna(4);
        c4.setColumna(6);
        c5.setColumna(8);
        c6.setColumna(10);
        c7.setColumna(12);
        c8.setColumna(14);
        c9.setColumna(16);
        c10.setColumna(18);
 
        while (c1.tryDown(board));
        while (c2.tryDown(board));
        while (c3.tryDown(board));
        while (c4.tryDown(board));
        while (c5.tryDown(board));
        while (c6.tryDown(board));
        while (c7.tryDown(board));
        while (c8.tryDown(board));
        while (c9.tryDown(board));
        while (c10.tryDown(board));
        
        assertEquals(9, c1.getFila());
        assertEquals(9, c2.getFila());
        assertEquals(9, c3.getFila());
        assertEquals(9, c4.getFila());
        assertEquals(9, c5.getFila());
        assertEquals(9, c6.getFila());
        assertEquals(9, c7.getFila());
        assertEquals(9, c8.getFila());
        assertEquals(9, c9.getFila());
        assertEquals(9, c10.getFila());
    }

    @Test
    public void explotarLineaLLena() {
        Board board = (new Board(10, 20));

        PieceSquare c1 = new PieceSquare();
        PieceSquare c2 = new PieceSquare();
        PieceSquare c3 = new PieceSquare();
        PieceSquare c4 = new PieceSquare();
        PieceSquare c5 = new PieceSquare();
        PieceSquare c6 = new PieceSquare();
        PieceSquare c7 = new PieceSquare();
        PieceSquare c8 = new PieceSquare();
        PieceSquare c9 = new PieceSquare();
        PieceSquare c10 = new PieceSquare();
        c1.setColumna(0);
        c2.setColumna(2);
        c3.setColumna(4);
        c4.setColumna(6);
        c5.setColumna(8);
        c6.setColumna(10);
        c7.setColumna(12);
        c8.setColumna(14);
        c9.setColumna(16);
        c10.setColumna(18);
 
        while (c1.tryDown(board));
        while (c2.tryDown(board));
        while (c3.tryDown(board));
        while (c4.tryDown(board));
        while (c5.tryDown(board));
        while (c6.tryDown(board));
        while (c7.tryDown(board));
        while (c8.tryDown(board));
        while (c9.tryDown(board));
        while (c10.tryDown(board));
        
        assertEquals(9, c1.getFila());
        assertEquals(9, c2.getFila());
        assertEquals(9, c3.getFila());
        assertEquals(9, c4.getFila());
        assertEquals(9, c5.getFila());
        assertEquals(9, c6.getFila());
        assertEquals(9, c7.getFila());
        assertEquals(9, c8.getFila());
        assertEquals(9, c9.getFila());
        assertEquals(9, c10.getFila());

        board.eliminarLineas();
        for(int i=0; i<20; i++){
            assertEquals('o', board.getTablero()[9][i]);
        }
    }
}   
