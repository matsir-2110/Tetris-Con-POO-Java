package com.mycompany.app;
import static org.junit.Assert.assertEquals;
import org.junit.Test;



public class PieceDogTest {

    @Test
    public void RotaBienDogL() {
        PieceDogL DL = new PieceDogL();
        // FORMA INICIAL
        assertEquals(
            "oooo\n" +
            "oooo\n" +
            "xxoo\n" +
            "oxxo", 
            DL.getPosicionActual());

        DL.rotarDerecha();
        assertEquals(
            "oxoo\n" +
            "xxoo\n" +
            "xooo\n" +
            "oooo",
             DL.getPosicionActual());

        DL.rotarIzquierda();
        assertEquals( 
            "oooo\n" +
            "oooo\n" +
            "xxoo\n" +
            "oxxo", 
            DL.getPosicionActual());

       
    }

    @Test
    public void RotaBienDogR() {
        PieceDogR DR = new PieceDogR();
        // FORMA INICIAL
        assertEquals ( 
            "oooo\n" +
            "oooo\n" +
            "oxxo\n" +
            "xxoo", 
            DR.getPosicionActual());
    
        DR.rotarDerecha();
        assertEquals(
            "xooo\n" +
            "xxoo\n" +
            "oxoo\n" +
            "oooo", 
            DR.getPosicionActual());

        DR.rotarIzquierda();
        assertEquals( 
            "oooo\n" +
            "oooo\n" +
            "oxxo\n" +
            "xxoo", 
             DR.getPosicionActual());
    }



    @Test
    public void piezaDogRCaidaLibreTest() {
        Board board = new Board(); 
        PieceDogR dogR = new PieceDogR();

        dogR.setFila(0);
        dogR.setColumna(4);

        int ticks = 0;
        int ultimaFila = board.getTablero().length - 1;

        
        while (dogR.getFila() < ultimaFila) {
            ticks++;
            if (ticks % 2 == 0) {
                dogR.bajar(board);
            }
        }

        assertEquals(ultimaFila, dogR.getFila());
    }

    @Test
    public void piezaDogLCaidaLibreTest() {
        
    }


}





