package com.mycompany.app;

import java.util.Random;

public class Tetris {
    private Board tablero;
    private Clock reloj;
    private PieceBase piezaActual;
    private Random aleatorio;
    private int lineasEliminadas;
    private boolean juegoTerminado;

    public Tetris(){
        setTablero(new Board(10,20));
        setReloj(new Clock());
        aleatorio = new Random();
        setLineasEliminadas(0);
        setJuegoTerminado(false);
    }

    public Board getTablero(){
        return tablero; 
    }
    public void setTablero(Board tablero) {
        this.tablero = tablero;
    }

    public void setLineasEliminadas(int lineasEliminadas){
        this.lineasEliminadas = lineasEliminadas;
    }

    public void setJuegoTerminado(boolean juegoTerminado){
        this.juegoTerminado = juegoTerminado;
    }

    public Clock getReloj(){
        return reloj;
    }
    public void setReloj(Clock reloj) {
        this.reloj = reloj;
    }

    public PieceBase getCurrentPiece(){
        return piezaActual;
    }

    public boolean isGameOver() {
        return juegoTerminado;
    }

    public int getLinesCleared() {
        return lineasEliminadas;
    }

    public void addLinesCleared(int eliminadas) {
        this.lineasEliminadas += eliminadas;
    }

    // Genera una pieza aleatoria
    public PieceBase generarPiezaAleatoria() {
        int indice = aleatorio.nextInt(7);
        switch (indice) {
            case 0: 
                return new PieceDogL();
            case 1: 
                return new PieceDogR();
            case 2: 
                return new PieceLL();
            case 3: 
                return new PieceLR();
            case 4: 
                return new PieceSquare();
            case 5: 
                return new PieceT();
            case 6: 
                return new PieceStick();
            default: 
                return new PieceSquare();
        }
    }

    // inicia con una pieza (random o dada)
    public void start(PieceBase primeraPieza) {
        if (primeraPieza != null) {
            this.piezaActual = primeraPieza;
        } else {
            this.piezaActual = generarPiezaAleatoria();
        }
        if (tablero.colisiona(piezaActual.getForma(), piezaActual.getFila(), piezaActual.getColumna())) {
            juegoTerminado = true;
        }
    }

    // avance, cada 2 ticks la pieza baja
    public void tick() {
        if (juegoTerminado || piezaActual == null) {
            return;
        }

        reloj.tick();
        if (reloj.getTicks() % 2 == 0) {
            boolean seMovi = piezaActual.intentarBajar(tablero);
            if (!seMovi) {
                piezaActual.fijarEn(tablero);
                int eliminadas = tablero.limpiarLineas();
                lineasEliminadas += eliminadas;
                if (lineasEliminadas >= 5) {
                    juegoTerminado = true;
                }
                piezaActual = generarPiezaAleatoria();
                if (tablero.colisiona(piezaActual.getForma(), piezaActual.getFila(), piezaActual.getColumna())) {
                    juegoTerminado = true;
                }
                reloj.resetTicks();
            }
        }
    }
}