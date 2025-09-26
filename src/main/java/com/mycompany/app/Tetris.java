package com.mycompany.app;

public class Tetris {
    private Board tablero;
    private IClock reloj;
    private PieceActual piezaActual;

    public Tetris() {
        setTablero(new Board(10,20));
        setReloj(new Clock());
    }

    public Board getTablero(){
        return tablero; 
    }
    public void setTablero(Board tablero) {
        this.tablero = tablero;
    }

    public IClock getReloj(){
        return reloj;
    }
    public void setReloj(IClock reloj) {
        this.reloj = reloj;
    }

    public PieceActual getCurrentPiece(){
        return piezaActual;
    }

    // inicia con una pieza general
    public void start(PieceActual primeraPieza) {
        this.piezaActual = primeraPieza;
        // si spawnea colisionando: game over
    }

    // avance, cada 2 ticks la pieza baja
    public void tick() {
        reloj.tick();
        if (piezaActual == null){
            return;
        }

        if (reloj.getTicks() % 2 == 0) {
            boolean moved = piezaActual.tryDown(tablero);
            if (!moved){
                piezaActual.fixOn(tablero);   // queda fijada en el board
                piezaActual = null;         // listo para setear otra pieza
                reloj.resetTicks();
            }
        }
    }
}
