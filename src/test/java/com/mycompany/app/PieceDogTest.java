package com.mycompany.app;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PieceDogTest {

    @Test
    public void RotaBienDogL() {
        PieceDogL DL = new PieceDogL();
        Board tablero = new Board();

        // FORMA INICIAL
        assertEquals("oooo\nxxoo\noxxo\noooo", DL.getForma());

        assertTrue(DL.intentarRotarDerecha(tablero));
        assertEquals("ooxo\noxxo\nooxo\noooo", DL.getForma());

        assertTrue(DL.intentarRotarIzquierda(tablero));
        assertEquals("oooo\nxxoo\noxxo\noooo", DL.getForma());
    }

    @Test
    public void RotaBienDogR() {
        PieceDogR DR = new PieceDogR();
        Board tablero = new Board();

        // FORMA INICIAL
        assertEquals("oooo\noxxo\nxxoo\noooo", DR.getForma());

        assertTrue(DR.intentarRotarDerecha(tablero));
        assertEquals("oxoo\noxxo\nooxo\noooo", DR.getForma());

        assertTrue(DR.intentarRotarIzquierda(tablero));
        assertEquals("oooo\noxxo\nxxoo\noooo", DR.getForma());
    }

    @Test
    public void piezaDogRCaidaLibreTest() {
        Board tablero = new Board(); 
        PieceDogR dogR = new PieceDogR();

        dogR.setFila(0);
        dogR.setColumna(4);

        dogR.caer(tablero);

        assertEquals(tablero.filas() - 3, dogR.getFila()); 
    }

    @Test
    public void piezaDogLCaidaLibreTest() {
        Board tablero = new Board(); 
        PieceDogL dogL = new PieceDogL();

        dogL.setFila(0);
        dogL.setColumna(4);

        dogL.caer(tablero);

        assertEquals(tablero.filas() - 3, dogL.getFila());
    }
}