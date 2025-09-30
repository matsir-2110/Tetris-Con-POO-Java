package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RelojTest {
    
    @Test
    public void FuncionaTicks(){
        Clock reloj = new Clock();
        assertEquals(0, reloj.getTicks());
        reloj.tick();
        assertEquals(1, reloj.getTicks());
        reloj.tick();
        assertEquals(2, reloj.getTicks());
        reloj.resetTicks();
        assertEquals(0, reloj.getTicks());
    }

    // Test adicional: Múltiples resets
    @Test
    public void multipleResetsTest() {
        Clock reloj = new Clock();
        reloj.tick();
        reloj.tick();
        reloj.resetTicks();
        assertEquals(0, reloj.getTicks());
        reloj.tick();
        assertEquals(1, reloj.getTicks());
    }
}