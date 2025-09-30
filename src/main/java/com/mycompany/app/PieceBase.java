package com.mycompany.app;

public abstract class PieceBase implements IRotator {
    private String nombre;
    private String[] posiciones;
    private int rotacion;
    private int fila;
    private int columna;

    protected PieceBase(String nombre, String[] posiciones) {
        this.nombre = nombre;
        this.posiciones = posiciones;
        this.rotacion = 0;
        this.fila = 0;
        this.columna = 3; // Spawn en columna central
    }

    public String getNombre(){
        return nombre;
    }

    public String getForma(){
        return posiciones[rotacion];
    }

    public int getFila(){
        return fila;
    }
    public void setFila(int fila){
        this.fila = fila;
    }

    public int getColumna(){
        return columna;
    }
    public void setColumna(int columna){
        this.columna = columna;
    }
    
    // revierte si colisiona
    public boolean intentarRotarIzquierda(Board tablero) {
        int anterior = rotacion;
        rotacion = (rotacion - 1 + posiciones.length) % posiciones.length;
        if (tablero.colisiona(getForma(), fila, columna)){
            rotacion = anterior;
            return false;
        }
        return true;
    }
    
    public boolean intentarRotarDerecha(Board tablero) {
        int anterior = rotacion;
        rotacion = (rotacion + 1) % posiciones.length;
        if (tablero.colisiona(getForma(), fila, columna)){
            rotacion = anterior;
            return false;
        }
        return true;
    }

    // movimiento seguro
    public boolean intentarBajar(Board tablero) {
        if (!tablero.colisiona(getForma(), fila + 1, columna)){
            fila++;
            return true;
        }
        return false;
    }

    public boolean intentarIzquierda(Board tablero) {
        if (!tablero.colisiona(getForma(), fila, columna - 1)){
            columna--;
            return true;
        }
        return false;
    }

    public boolean intentarDerecha(Board tablero) {
        if (!tablero.colisiona(getForma(), fila, columna + 1)){
            columna++; 
            return true; 
        }
        return false;
    }

    // fijar pieza
    public void fijarEn(Board tablero){
        tablero.fijar(getForma(), fila, columna);
    }

    // caida libre
    public void caer(Board tablero) {
        while (intentarBajar(tablero));
    }

    @Override
    public boolean rotateLeft(Board tablero) {
        return intentarRotarIzquierda(tablero);
    }

    @Override
    public boolean rotateRight(Board tablero) {
        return intentarRotarDerecha(tablero);
    }
}