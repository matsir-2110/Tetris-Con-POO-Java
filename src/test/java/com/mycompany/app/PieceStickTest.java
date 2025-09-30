package com.mycompany.app;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PieceStickTest {

    @Test
    public void RotarBienStick(){
        PieceStick ST = new PieceStick();
        Board tablero = new Board();

        // FORMA INICIAL
        assertEquals("x\nx\nx\nx", ST.getForma());

        assertTrue(ST.intentarRotarDerecha(tablero));
        assertEquals("xxxx", ST.getForma());

        assertTrue(ST.intentarRotarIzquierda(tablero));
        assertEquals("x\nx\nx\nx", ST.getForma());
    }

    // Test caída libre
    @Test
    public void caidaLibreStickTest() {
        Board tablero = new Board();
        PieceStick palo = new PieceStick();

        palo.caer(tablero);

        assertEquals(tablero.filas() - 4, palo.getFila());
    }
}