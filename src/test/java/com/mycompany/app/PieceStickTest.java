package com.mycompany.app;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PieceStickTest {

    @Test
    
    public void RotarBienStick(){
        PieceStick ST = new PieceStick();

        // FORMA INICIAL
        assertEquals("oxoooxoooxoooxoo", ST.getPosicionActual());

        ST.rotarDerecha();

        assertEquals("xxxxoooooooooooo", ST.getPosicionActual());

        ST.rotarIzquierda();
        assertEquals("oxoooxoooxoooxoo", ST.getPosicionActual());
    }

    
}
