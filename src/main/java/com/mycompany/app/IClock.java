package com.mycompany.app;

public interface IClock {
    void tick();
    //Cada dos ticks, la pieza baja una posicion
    int getTicks();
    void resetTicks();

}