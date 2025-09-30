package com.mycompany.app;

public class Clock{
    private int ticks = 0;

    public void tick(){
        ticks++;
    }

    public int getTicks(){
        return ticks;
    }
    
    public void resetTicks(){
        ticks = 0;
    }
}
