package com.mycompany.app;

public class Clock implements IClock {
    private int ticks = 0;

    public void tickear(Board tablero, Tetris pieza) {
        if (ticks % 2 == 0) {
        pieza.bajar(tablero);
        }
    }


    @Override
    public int getTicks() {
        return ticks;
    }

    @Override
    public void tick() {
        ticks++;
    }

    @Override
    public void resetTicks() {
        ticks = 0;
    }
}

