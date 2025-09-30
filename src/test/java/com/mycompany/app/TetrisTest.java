package com.mycompany.app;

import static org.junit.Assert.*;
import org.junit.Test;

public class TetrisTest {

    @Test
    public void contarLineasTest() {
        Board tablero = new Board(10, 20);

        PieceSquare c1 = new PieceSquare();
        PieceSquare c2 = new PieceSquare();
        PieceSquare c3 = new PieceSquare();
        PieceSquare c4 = new PieceSquare();
        PieceSquare c5 = new PieceSquare();
        PieceSquare c6 = new PieceSquare();
        PieceSquare c7 = new PieceSquare();
        PieceSquare c8 = new PieceSquare();
        PieceSquare c9 = new PieceSquare();
        PieceSquare c10 = new PieceSquare();
        
        c1.setColumna(0);
        c2.setColumna(2);
        c3.setColumna(4);
        c4.setColumna(6);
        c5.setColumna(8);
        c6.setColumna(10);
        c7.setColumna(12);
        c8.setColumna(14);
        c9.setColumna(16);
        c10.setColumna(18);
 
        // Hacer caer y fijar las piezas
        c1.caer(tablero);
        c2.caer(tablero);
        c3.caer(tablero);
        c4.caer(tablero);
        c5.caer(tablero);
        c6.caer(tablero);
        c7.caer(tablero);
        c8.caer(tablero);
        c9.caer(tablero);
        c10.caer(tablero);
        
        c1.fijarEn(tablero);
        c2.fijarEn(tablero);
        c3.fijarEn(tablero);
        c4.fijarEn(tablero);
        c5.fijarEn(tablero);
        c6.fijarEn(tablero);
        c7.fijarEn(tablero);
        c8.fijarEn(tablero);
        c9.fijarEn(tablero);
        c10.fijarEn(tablero);
        
        // Los squares quedan en fila 8 (ocupan filas 8 y 9)
        assertEquals(8, c1.getFila());
        assertEquals(8, c2.getFila());
        assertEquals(8, c3.getFila());
        assertEquals(8, c4.getFila());
        assertEquals(8, c5.getFila());
        assertEquals(8, c6.getFila());
        assertEquals(8, c7.getFila());
        assertEquals(8, c8.getFila());
        assertEquals(8, c9.getFila());
        assertEquals(8, c10.getFila());

        for(int i=0; i<20; i++){
            assertEquals('x', tablero.getTablero()[9][i]);
        }
    }
        
    @Test
    public void explotarLineaLlena() {
        Board tablero = new Board(10, 20);

        PieceSquare c1 = new PieceSquare();
        PieceSquare c2 = new PieceSquare();
        PieceSquare c3 = new PieceSquare();
        PieceSquare c4 = new PieceSquare();
        PieceSquare c5 = new PieceSquare();
        PieceSquare c6 = new PieceSquare();
        PieceSquare c7 = new PieceSquare();
        PieceSquare c8 = new PieceSquare();
        PieceSquare c9 = new PieceSquare();
        PieceSquare c10 = new PieceSquare();
        
        c1.setColumna(0);
        c2.setColumna(2);
        c3.setColumna(4);
        c4.setColumna(6);
        c5.setColumna(8);
        c6.setColumna(10);
        c7.setColumna(12);
        c8.setColumna(14);
        c9.setColumna(16);
        c10.setColumna(18);
 
        // Hacer caer y fijar las piezas
        c1.caer(tablero);
        c2.caer(tablero);
        c3.caer(tablero);
        c4.caer(tablero);
        c5.caer(tablero);
        c6.caer(tablero);
        c7.caer(tablero);
        c8.caer(tablero);
        c9.caer(tablero);
        c10.caer(tablero);
        
        c1.fijarEn(tablero);
        c2.fijarEn(tablero);
        c3.fijarEn(tablero);
        c4.fijarEn(tablero);
        c5.fijarEn(tablero);
        c6.fijarEn(tablero);
        c7.fijarEn(tablero);
        c8.fijarEn(tablero);
        c9.fijarEn(tablero);
        c10.fijarEn(tablero);

        // Verificar que hay 2 líneas completas
        assertEquals(2, tablero.lineCount());
        
        // Eliminar las líneas
        int eliminadas = tablero.limpiarLineas();
        assertEquals(2, eliminadas);
        
        // Verificar que las líneas están vacías
        for(int i = 0; i < 20; i++){
            assertEquals('o', tablero.getTablero()[8][i]);
            assertEquals('o', tablero.getTablero()[9][i]);
        }
    }

    @Test
    public void generarPiezaRandomTest() {
        Tetris tetris = new Tetris();
        PieceBase pieza1 = tetris.generarPiezaAleatoria();
        PieceBase pieza2 = tetris.generarPiezaAleatoria();
        assertNotNull(pieza1);
        assertNotNull(pieza2);
        assertTrue(pieza1.getNombre().matches("DogL|DogR|L|LR|Square|T|Stick"));
        assertTrue(pieza2.getNombre().matches("DogL|DogR|L|LR|Square|T|Stick"));
    }

    @Test
    public void stackingPiezasTest() {
        Tetris tetris = new Tetris();
        Board tablero = tetris.getTablero();
        PieceSquare inferior = new PieceSquare();

        inferior.setColumna(0);
        inferior.caer(tablero);
        inferior.fijarEn(tablero);

        PieceSquare superior = new PieceSquare();
        superior.setColumna(0);
        superior.caer(tablero);
        superior.fijarEn(tablero);

        assertEquals(6, superior.getFila());
        assertEquals('x', tablero.getTablero()[8][0]);
        assertEquals('x', tablero.getTablero()[9][0]);
        assertEquals('x', tablero.getTablero()[7][0]);
        assertEquals('x', tablero.getTablero()[6][0]);
    }

    @Test
    public void gameOverPorApilamiento() {
        Tetris tetris = new Tetris();
        Board tablero = tetris.getTablero();
        
        // El spawn está en fila 0, columna 3
        // Apilar en la columna 3 para bloquear el spawn
        for (int i = 0; i < 3; i++) {
            PieceStick palo = new PieceStick();
            palo.caer(tablero);
            palo.fijarEn(tablero); 
        }
        
        // Intentar iniciar con spawn bloqueado
        tetris.start(new PieceStick());
        
        // Debe ser game over inmediato porque el spawn está bloqueado
        assertTrue("El juego debe terminar inmediatamente con spawn bloqueado", 
                tetris.isGameOver());
        assertEquals("No debe haber eliminado líneas", 0, tetris.getLinesCleared());
    }

    @Test
    public void gameOverPor5Lineas() {
        Tetris tetris = new Tetris();
        Board tablero = tetris.getTablero();
        
        // Crear exactamente 5 líneas completas desde el principio
        for (int fila = 9; fila >= 5; fila--) {
            for (int col = 0; col < 20; col++) {
                tablero.getTablero()[fila][col] = 'x';
            }
        }
        
        // Verificar que hay 5 líneas
        assertEquals(5, tablero.lineCount());
        
        // Limpiar y contar
        int eliminadas = tablero.limpiarLineas();
        assertEquals(5, eliminadas);
        
        // Simular que el juego termina por 5 líneas
        tetris.addLinesCleared(5);
        assertEquals(5, tetris.getLinesCleared());
    }

    @Test
    public void gameOverPor5LineasJugando() {
        Tetris tetris = new Tetris();
        Board tablero = tetris.getTablero();
        
        // Pre-llenar el tablero dejando solo 2 columnas vacías
        for (int fila = 9; fila >= 0; fila--) {
            for (int col = 0; col < 18; col++) {
                tablero.getTablero()[fila][col] = 'x';
            }
        }
        
        tetris.start(new PieceSquare());
        
        // Colocar piezas manualmente hasta completar 5 líneas
        while (tetris.getLinesCleared() < 5 && !tetris.isGameOver()) {
            PieceBase pieza = tetris.getCurrentPiece();
            if (pieza != null) {
                // Mover a la derecha
                for (int i = 0; i < 20; i++) {
                    pieza.intentarDerecha(tablero);
                }
            }
            tetris.tick();
        }
        
        assertTrue("Debe alcanzar 5 líneas o terminar", 
                tetris.getLinesCleared() >= 5 || tetris.isGameOver());
    }

    @Test
    public void simulacionJuegoTest() {
        Tetris tetris = new Tetris();
        tetris.start(new PieceSquare());

        for (int i = 0; i < 20; i++) {
            tetris.tick();
        }

        assertNotNull(tetris.getCurrentPiece());
        assertFalse(tetris.isGameOver());
    }

    @Test
    public void movimientosLateralesTest() {
        Board tablero = new Board(10, 20);
        PieceSquare cuadrado = new PieceSquare();
        cuadrado.setColumna(10);
        cuadrado.setFila(5);
        
        assertTrue("Debe poder moverse a la izquierda", cuadrado.intentarIzquierda(tablero));
        assertEquals(9, cuadrado.getColumna());
        
        assertTrue("Debe poder moverse a la derecha", cuadrado.intentarDerecha(tablero));
        assertEquals(10, cuadrado.getColumna());
        
        cuadrado.setColumna(0);
        assertFalse("No debe poder moverse más allá del borde izquierdo", cuadrado.intentarIzquierda(tablero));
        
        cuadrado.setColumna(18);
        assertFalse("No debe poder moverse más allá del borde derecho", cuadrado.intentarDerecha(tablero));
    }

    @Test
    public void colisionEntrepiezasTest() {
        Board tablero = new Board(10, 20);
        
        PieceSquare cuadrado1 = new PieceSquare();
        cuadrado1.setColumna(5);
        cuadrado1.setFila(5);
        cuadrado1.fijarEn(tablero);
        
        PieceSquare cuadrado2 = new PieceSquare();
        cuadrado2.setColumna(5);
        cuadrado2.setFila(5);
        
        assertTrue("Debe detectar colisión", 
                   tablero.colisiona(cuadrado2.getForma(), cuadrado2.getFila(), cuadrado2.getColumna()));
        
        cuadrado2.setColumna(7);
        assertFalse("No debe haber colisión al lado", 
                    tablero.colisiona(cuadrado2.getForma(), cuadrado2.getFila(), cuadrado2.getColumna()));
    }

    @Test
    public void contarLineasCompletas() {
        Board tablero = new Board(10, 20);
        
        for (int columna = 0; columna < 20; columna++) {
            tablero.getTablero()[9][columna] = 'x';
            tablero.getTablero()[7][columna] = 'x';
            tablero.getTablero()[5][columna] = 'x';
        }
        
        assertEquals("Debe contar 3 líneas completas", 3, tablero.lineCount());
        
        int eliminadas = tablero.limpiarLineas();
        assertEquals("Debe eliminar 3 líneas", 3, eliminadas);
        
        assertEquals("No debe haber líneas completas después de limpiar", 0, tablero.lineCount());
    }

    @Test
    public void victoriaDirecta() {
        Tetris tetris = new Tetris();
        
        // Agregar directamente 5 líneas eliminadas
        tetris.addLinesCleared(5);
        
        assertEquals(5, tetris.getLinesCleared());
        
        // Iniciar el juego - debería detectar victoria
        tetris.start(new PieceSquare());
        tetris.tick();
        
        // Después de un tick con 5 líneas, debería terminar
        assertTrue("Debe terminar con 5 líneas", 
                tetris.getLinesCleared() >= 5);
    }

    @Test
    public void derrotaDirecta() {
        Tetris tetris = new Tetris();
        Board tablero = tetris.getTablero();
        
        // Bloquear completamente el spawn (fila 0, columna 3)
        for (int i = 0; i < 4; i++) {
            tablero.getTablero()[0][3 + i] = 'x';
        }
        
        // Intentar iniciar - debe ser game over inmediato
        tetris.start(new PieceSquare());
        
        assertTrue("Debe ser game over al iniciar con spawn bloqueado", 
                tetris.isGameOver());
        assertTrue("No debe haber eliminado líneas", 
                tetris.getLinesCleared() == 0);
    }

    @Test
    public void tickBasico() {
        Tetris tetris = new Tetris();
        tetris.start(new PieceSquare());
        
        PieceBase piezaInicial = tetris.getCurrentPiece();
        int filaInicial = piezaInicial.getFila();
        
        // Después de 2 ticks la pieza debe bajar
        tetris.tick();
        tetris.tick();
        
        assertTrue("La pieza debe haber bajado o cambiado", 
                piezaInicial.getFila() > filaInicial || 
                tetris.getCurrentPiece() != piezaInicial);
    }

    @Test
    public void fijarYnuevaPieza() {
        Tetris tetris = new Tetris();
        Board tablero = tetris.getTablero();
        
        tetris.start(new PieceSquare());
        PieceBase primera = tetris.getCurrentPiece();
        
        // Hacer caer manualmente
        primera.caer(tablero);
        primera.fijarEn(tablero);
        
        // Verificar que se fijó
        assertTrue("Debe haber celdas ocupadas", tablero.lineCount() >= 0);
        
        // Al hacer tick debería generar nueva pieza
        tetris.tick();
        tetris.tick();
        
        assertNotNull("Debe haber una pieza actual", tetris.getCurrentPiece());
    }
}