package com.mycompany.app;

public abstract class PieceBase implements IRotator {
    private String nombre;
    private String[] posiciones;
    private int rotacion;
    private int fila;
    private int columna;

    public PieceBase(String nombre, String[] posiciones) {
        setNombre(nombre);;
        setPosicion(posiciones);
        setRotacion(0);
        setFila(0);
        setColumna(3);
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPosicion(String[] posiciones){
        this.posiciones = posiciones;
    }

    public void setRotacion(int rotacion){
        this.rotacion = rotacion;
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