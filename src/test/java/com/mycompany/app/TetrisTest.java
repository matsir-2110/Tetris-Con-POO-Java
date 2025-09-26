package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TetrisTest {
    
    @Test
    public void cantidadPiezasTest(){

        ArrayList<Tetris> piezas = new ArrayList<Tetris>();

        piezas.add(new PieceDogL());
        piezas.add(new PieceDogR());
        piezas.add(new PieceLL());
        piezas.add(new PieceLR());
        piezas.add(new PieceSquare());
        piezas.add(new PieceStick());
        piezas.add(new PieceT());

        assertEquals(7, piezas.size());
    }

    @Test
    public void moverAbajoTest(){
        PieceDogL pdog1 = new PieceDogL();
        Board tablero = new Board();

        assertEquals(0, pdog1.getFila());
        
        pdog1.bajar(tablero);
        assertEquals(1, pdog1.getFila());
    }

    @Test
    public void moverDerechaTest(){
        PieceDogL pdog1 = new PieceDogL();
        Board tablero = new Board();

        assertEquals(4, pdog1.getColumna());

        pdog1.moverDerecha(tablero);
        assertEquals(5, pdog1.getColumna());
    }

    @Test
    public void moverIzquierdaTest(){
        PieceDogL pdog1 = new PieceDogL();
        Board tablero = new Board();

        assertEquals(4, pdog1.getColumna());

        pdog1.moverIzquierda(tablero);
        assertEquals(3, pdog1.getColumna());
    }

    @Test
    public void testPiezaNoSaleDelTablero() {
        Board board = new Board();
        PieceDogL pDL1 = new PieceDogL();

        // Intentar mover la pieza mucho a la izquierda
        boolean pudoMover = true;
        while (pudoMover) {
            pudoMover = pDL1.moverIzquierda(board);
        }

        // No puede tener columna negativa
        assertEquals(true, pDL1.getColumna() >= 0);

        // Intentar mover la pieza mucho a la derecha
        pudoMover = true;
        while (pudoMover) {
            pudoMover = pDL1.moverDerecha(board);
        }

        // No puede salir del tablero
        assertEquals(true, pDL1.getColumna() < board.getTablero()[0].length);
    }

    @Test
    public void testDosPiezasUnaSobreOtra() {
        Board board = new Board();
        PieceDogL pL1 = new PieceDogL();
        PieceSquare pc1 = new PieceSquare();
        
        // Baja la primera pieza hasta el fondo
        while (pL1.bajar(board)) {
            pL1.dibujarEnTablero(board);
        }

        // Colocamos la segunda pieza arriba de la primera
        while (pc1.bajar(board)) {
            pc1.dibujarEnTablero(board);
        }

        // El cuadrado debería haber quedado apoyado sobre la L, no atravesarla
        assertEquals(true, pc1.getFila() < board.getTablero().length - 1);
        assertEquals(true, pc1.getFila() < pL1.getFila());
        assertEquals(true, pc1.getFila() + 1 == pL1.getFila());
       

    
        
    }

 

}
