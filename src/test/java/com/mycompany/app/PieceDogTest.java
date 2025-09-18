package com.mycompany.app;

import org.junit.Test;

public class PieceDogTest {
    
    @Test
    public void testRotarDerecha() {
        PieceDogL PDL = new PieceDogL();
        public int getPosicionActual = 0;
        
        assertEquals(expected: "rotacionActual", PDL.getPosicionActual());
        PDL.rotarDerecha();
        assertEquals(expected: (rotacionActual + 1) % 2, PDL.getPosicionActual());
        
    }
}
