package com.mycompany.app;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PieceLTest {

    @Test
    public void RotaBienPieceLL(){
        PieceLL pll = new PieceLL();
        Board tablero = new Board();

        assertEquals("oooo\nxooo\nxxxo\noooo", pll.getForma());

        assertTrue(pll.intentarRotarDerecha(tablero));
        assertEquals("oooo\nxxoo\nxooo\nxooo", pll.getForma());

        assertTrue(pll.intentarRotarDerecha(tablero));
        assertEquals("oooo\nxxxo\nooox\noooo", pll.getForma());

        assertTrue(pll.intentarRotarDerecha(tablero));
        assertEquals("oooo\nooxo\nooxo\nxxoo", pll.getForma());

        assertTrue(pll.intentarRotarDerecha(tablero));
        assertEquals("oooo\nxooo\nxxxo\noooo", pll.getForma()); // Vuelve
    }

    // Caída libre
    @Test
    public void caidaLibreLLTest() {
        Board tablero = new Board();
        PieceLL pll = new PieceLL();

        pll.caer(tablero);

        assertEquals(tablero.filas() - 3, pll.getFila());
    }

    @Test
    public void RotaBienPieceLR() {
        PieceLR plr = new PieceLR();
        Board tablero = new Board();

        assertEquals("oooo\nooox\nxxxo\noooo", plr.getForma());

        assertTrue(plr.intentarRotarDerecha(tablero));
        assertEquals("oooo\nxooo\nxooo\nxxoo", plr.getForma());

        assertTrue(plr.intentarRotarDerecha(tablero));
        assertEquals("oooo\nxxxo\nxooo\noooo", plr.getForma());

        assertTrue(plr.intentarRotarDerecha(tablero));
        assertEquals("oooo\nxxoo\nooxo\nooxo", plr.getForma());

        assertTrue(plr.intentarRotarDerecha(tablero));
        assertEquals("oooo\nooox\nxxxo\noooo", plr.getForma()); // Vuelve
    }

    // Caída libre
    @Test
    public void caidaLibreLRTest() {
        Board tablero = new Board();
        PieceLR plr = new PieceLR();

        plr.caer(tablero);

        assertEquals(tablero.filas() - 3, plr.getFila());
    }
}