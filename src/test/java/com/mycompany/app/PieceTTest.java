package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PieceTTest {
    
    @Test
    public void rotaBienT() {
        PieceT t = new PieceT();
        Board tablero = new Board();

        assertEquals("oxoo\nxxxo", t.getForma());

        assertTrue(t.intentarRotarDerecha(tablero));
        assertEquals("xooo\nxxoo\nxooo", t.getForma());

        assertTrue(t.intentarRotarDerecha(tablero));
        assertEquals("xxxo\noxoo", t.getForma());

        assertTrue(t.intentarRotarDerecha(tablero));
        assertEquals("oxoo\nxxoo\noxoo", t.getForma());
    }

    @Test
    public void caidaLibreTTest() {
        Board tablero = new Board();
        PieceT t = new PieceT();

        t.caer(tablero);

        assertEquals(tablero.filas() - 2, t.getFila()); // Altura 2
    }
}