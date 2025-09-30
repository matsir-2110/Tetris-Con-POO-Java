package com.mycompany.app;

import static org.junit.Assert.*;
import org.junit.Test;

public class PieceSquareTest {

    @Test
    public void CrearSquare(){
        PieceSquare PS = new PieceSquare();
        assertEquals("xx\nxx", PS.getForma());
    }
    
    @Test
    public void piezaSquareCaidaLibreTest() {
        Board tablero = new Board();
        PieceSquare cuadrado = new PieceSquare();

        cuadrado.setFila(0);
        cuadrado.setColumna(4);

        cuadrado.caer(tablero);

        assertEquals(tablero.filas() - 2, cuadrado.getFila()); // Altura 2
    }

    // Test adicional: Movimiento lateral
    @Test
    public void mueveLateralSquare() {
        Board tablero = new Board();
        PieceSquare cuadrado = new PieceSquare();
        cuadrado.setColumna(4);

        assertTrue(cuadrado.intentarIzquierda(tablero));
        assertEquals(3, cuadrado.getColumna());

        assertTrue(cuadrado.intentarDerecha(tablero));
        assertEquals(4, cuadrado.getColumna());
    }
}