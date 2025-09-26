package com.mycompany.app;

public class IRotator {
    private PieceActual piezaActual;
    private Board tablero;
    public IRotator(PieceActual piezaActual, Board tablero) {
        this.piezaActual = piezaActual;
        this.tablero = tablero;
    }

    public boolean rotateLeft(){
        if(piezaActual != null && piezaActual.tryRotateLeft(tablero)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean rotateRight(){
        if(piezaActual != null && piezaActual.tryRotateRight(tablero)){
            return true;
        }
        else{
            return false;
        }
    }
}
