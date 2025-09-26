package com.mycompany.app;

public abstract class PieceActual implements IRotator {
    private String nombre;
    private String[] posiciones;
    private int rot;
    private int fila;
    private int col;
    private String[] rotations;
    private int rotationIndex;

    protected PieceActual(String nombre, String[] posiciones) {
        setNombre(nombre);
        setPosicion(posiciones);
        setRot(0);
        setFila(0);
        setColumna(3);
        this.rotationIndex = 0;

    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setRot(int rot) {
        this.rot = rot;
    }

    public void setPosicion(String[] posiciones){
        this.posiciones = posiciones;
    }

    public String getForma(){
        return posiciones[rot];
    }

    public int getFila(){
        return fila;
    }
    public void setFila(int fila){
    this.fila = fila;
    }

    public int getColumna(){
        return col;
    }
    public void setColumna(int col){
        this.col = col;
    }

    // revierte si colisiona
    public boolean tryRotateLeft(Board tablero) {
        int prev = rot;
        rot = (rot - 1 + posiciones.length) % posiciones.length;
        if (tablero.collides(getForma(), fila, col)){
            rot = prev;
            return false;
        }
        return true;
    }
    public boolean tryRotateRight(Board tablero) {
        int prev = rot;
        rot = (rot + 1) % posiciones.length;
        if (tablero.collides(getForma(), fila, col)){
            rot = prev;
            return false;
        }
        return true;
    }

    // movimiento seguro
    public boolean tryDown(Board tablero) {
        if (!tablero.collides(getForma(), fila , col)){
            fila++;
            return true;
        }
        return false;
    }

    public boolean tryLeft(Board tablero) {
        if (!tablero.collides(getForma(), fila, col - 1)){
            col--;
            return true;
        }
        return false;
    }

    public boolean tryRight(Board tablero) {
        if (!tablero.collides(getForma(), fila, col + 1)){
            col++; 
            return true; 
        }
        return false;
    }

    // fijar pieza
    public void fixOn(Board tablero){
        tablero.fix(getForma(), fila, col);
    }

    // caida libre
    public void drop(Board tablero) {
        while(tryDown(tablero));
    }

    @Override
    public boolean rotateLeft(Board tablero) {
        int prev = rotationIndex;
        rotationIndex = (rotationIndex - 1 + rotations.length) % rotations.length;
        if (canPlace(tablero)) {
            return true;
        } else {
            rotationIndex = prev; // vuelve atrás si no entra
            return false;
        }
    }

    @Override
    public boolean rotateRight(Board tablero) {
        int prev = rotationIndex;
        rotationIndex = (rotationIndex + 1) % rotations.length;
        if (canPlace(tablero)) {
            return true;
        } else {
            rotationIndex = prev;
            return false;
        }
    }

    private boolean canPlace(Board tablero) {
        // acá iría la validación de colisiones
        return true;
    }
}
