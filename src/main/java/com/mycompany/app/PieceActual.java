package com.mycompany.app;

public abstract class PieceActual {
    protected final String name;
    protected final String[] posiciones; // 4 rotaciones (o 1 si no rota)
    protected int rot;                   // índice de rotación
    protected int fila;                  // posición actual
    protected int col;

    protected PieceActual(String name, String[] posiciones) {
        this.name = name;
        this.posiciones = posiciones;
        this.rot = 0;
        this.fila = 0;
        this.col = 3; // centrado aproximado en un tablero de 10
    }

    public String getName() { return name; }
    public String getShape() { return posiciones[rot]; }
    public int getFila() { return fila; }
    public int getColumna() { return col; }
    public void setFila(int f) { this.fila = f; }
    public void setColumna(int c) { this.col = c; }

    // --- rotación segura (revierte si colisiona) ---
    public boolean tryRotateLeft(Board board) {
        int prev = rot;
        rot = (rot - 1 + posiciones.length) % posiciones.length;
        if (board.collides(getShape(), fila, col)) { rot = prev; return false; }
        return true;
    }
    public boolean tryRotateRight(Board board) {
        int prev = rot;
        rot = (rot + 1) % posiciones.length;
        if (board.collides(getShape(), fila, col)) { rot = prev; return false; }
        return true;
    }

    // --- movimiento seguro ---
    public boolean tryDown(Board board) {
        if (!board.collides(getShape(), fila + 1, col)) { fila++; return true; }
        return false;
    }
    public boolean tryLeft(Board board) {
        if (!board.collides(getShape(), fila, col - 1)) { col--; return true; }
        return false;
    }
    public boolean tryRight(Board board) {
        if (!board.collides(getShape(), fila, col + 1)) { col++; return true; }
        return false;
    }

    // --- fijado / caída libre ---
    public void fixOn(Board board) { board.fix(getShape(), fila, col); }

    public void drop(Board board) {
        while (tryDown(board)) { /* nada */ }
    }
}
