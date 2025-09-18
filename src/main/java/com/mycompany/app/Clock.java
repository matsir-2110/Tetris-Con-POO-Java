package com.mycompany.app;

public class Clock implements IClock {
    private int ticks = 0;

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

