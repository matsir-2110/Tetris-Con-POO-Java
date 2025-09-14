package com.mycompany.app;

public class PieceActual {
    private Tetris piece;
    private int fila;
    private int columna;
    

    public PieceActual(Tetris piece){
        setPiece(piece);
        setFila(0);   
        setColumna(5);
    }

    public void moveDown(int bajar){
        setFila(bajar);
    }

    public void moveLeft(int moverI){
        setColumna(columna - moverI);
    }

    public void moveRight(int moverD){
        setColumna(columna + moverD);
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

    public Tetris getPiece(){
        return piece;
    }

    public void setPiece(Tetris piece) {
        this.piece = piece;
    }


}
