package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class PieceSquareTest {

    @Test
    public void CrearSquare(){
        PieceSquare PS = new PieceSquare();
        // FORMA INICIAL
        PS.getPosicionActual();
    }
    

    @Test
    public void piezaSquareCaidaLibreTest() {
        Board board = new Board();
        PieceSquare square = new PieceSquare();

        square.setFila(0);
        square.setColumna(4);

        int ticks = 0;
        int ultimaFila = board.getTablero().length - 1;

        while (square.getFila() < ultimaFila) {
            ticks++;
            if (ticks % 2 == 0) {
                square.bajar(board);
            }
        }

        assertEquals(ultimaFila, square.getFila());
    }
}





