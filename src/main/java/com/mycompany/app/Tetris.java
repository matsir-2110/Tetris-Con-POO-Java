package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public abstract class Tetris {
    private String forma;
    private String nombre;
    private int fila;
    private int col;
    private Board tablero;

    public Tetris(String formaInicial, String nombreP){
        setForma(formaInicial);
        setNombre(nombreP);
        setFila(0);
        setColumna(4);
    }

    public void setForma(String forma){
    this.forma = forma;
    }
    
    public String getForma() {
        return forma;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
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

    public void bajar(){
        fila++;
    }

    public void dibujarEnTablero() {
            char[][] tab = tablero.getTablero();
            String[] filasPieza = getPosicionActual().split("\n");

            for (int i = 0; i < filasPieza.length; i++) {
                for (int j = 0; j < filasPieza[i].length(); j++) {
                    if (filasPieza[i].charAt(j) == 'x') {
                        tab[fila + i][col + j] = 'x';
                    }
                }
            }
        }

    // borrar (antes de mover)
    public void borrarDelTablero() {
        char[][] tab = tablero.getTablero();
        String[] filasPieza = getPosicionActual().split("\n");

        for (int i = 0; i < filasPieza.length; i++) {
            for (int j = 0; j < filasPieza[i].length(); j++) {
                if (filasPieza[i].charAt(j) == 'x') {
                    tab[fila + i][col + j] = 'o';
                }
            }
        }
    }

    public abstract void rotarIzquierda();
    public abstract void rotarDerecha();
    public abstract String getPosicionActual();
}
