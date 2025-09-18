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

}