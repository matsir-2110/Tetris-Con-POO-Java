package com.mycompany.app;

public class Tetris {
    private final Board board;
    private final IClock clock;
    private PieceActual current;

    public Tetris() {
        this.board = new Board(20, 10);
        this.clock = new Clock();
    }

    public Board getBoard() { return board; }
    public IClock getClock() { return clock; }
    public PieceActual getCurrentPiece() { return current; }

    /** Inicia con una pieza activa (general) */
    public void start(PieceActual firstPiece) {
        this.current = firstPiece;
        // si nace colisionando: podrías considerar game over; aquí lo dejamos pasar para tests
    }

    /** Rota a través del controlador (general) */
    public boolean rotateLeft()  { return current != null && current.tryRotateLeft(board); }
    public boolean rotateRight() { return current != null && current.tryRotateRight(board); }

    /** Avance de juego: cada 2 ticks, la pieza baja 1; si no puede, se fija y termina el ciclo */
    public void tick() {
        clock.tick();
        if (current == null) return;

        if (clock.getTicks() % 2 == 0) {
            boolean moved = current.tryDown(board);
            if (!moved) {
                current.fixOn(board);   // queda sólida en el board
                current = null;         // listo para que tests seteen otra o aserten estado
                clock.resetTicks();
            }
        }
    }
}
