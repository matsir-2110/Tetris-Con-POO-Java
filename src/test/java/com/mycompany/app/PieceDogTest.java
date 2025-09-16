package com.mycompany.app;
import static org.junit.Assert.assertEquals;
import org.junit.Test;



public class PieceDogTest {

    @Test
    public void RotaBienDogL() {
        PieceDogL DL = new PieceDogL();
        // FORMA INICIAL
        assertEquals("ooooooooxxoooxxo", DL.getPosicionActual());

        DL.rotarDerecha();
        assertEquals("oxooxxooxooooooo", DL.getPosicionActual());

        DL.rotarIzquierda();
        assertEquals("ooooooooxxoooxxo", DL.getPosicionActual());

       
    }

    @Test
    public void RotaBienDogR() {
        PieceDogR DR = new PieceDogR();
        // FORMA INICIAL
        assertEquals ("oooooooooxxoxxoo", DR.getPosicionActual());
    
        DR.rotarDerecha();
        assertEquals("xoooxxoooxoooooo", DR.getPosicionActual());

        DR.rotarIzquierda();
        assertEquals("oooooooooxxoxxoo", DR.getPosicionActual());
    }

}