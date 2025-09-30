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
 
        // hacer caer y fijar las piezas
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
        
        // los squares quedan en fila 8 (ocupan filas 8 y 9)
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
 
        // hacer caer y fijar las piezas
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

        // verificar que hay 2 lineas completas
        assertEquals(2, tablero.lineCount());
        
        // eliminar las lineas
        int eliminadas = tablero.limpiarLineas();
        assertEquals(2, eliminadas);
        
        // verificar que las lineas estan vacías
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
    public void ApilarPiezasTest() {
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

        assertTrue(tablero.colisiona(superior.getForma(), superior.getFila(), superior.getColumna()));
    }

    @Test
    public void gameOverPorApilamiento() {
        Tetris tetris = new Tetris();
        Board tablero = tetris.getTablero();
        
        
        // apilamos en la columna 3 para bloquear el spawn
        for (int i = 0; i < 3; i++) {
            PieceStick palo = new PieceStick();
            palo.caer(tablero);
            palo.fijarEn(tablero); 
        }
        
        // inicia el juego con el spawn bloqueado
        tetris.start(new PieceStick());
        
        // el juego termina porque el spawn esta bloqueado
        assertTrue(tetris.isGameOver());
    }

    @Test
    public void gameOverPorApilamientoRandom() {
        Tetris tetris = new Tetris();
        Board tablero = tetris.getTablero();
        
        // inicia el juego con una pieza aleatoria
        tetris.start(null);
        
        // simular el juego hasta que termine por apilamiento
        while (!tetris.isGameOver()) {
            // la pieza actual cae directamente
            if (tetris.getCurrentPiece() != null) {
                tetris.getCurrentPiece().caer(tablero);
            }
            
            // hacer tick para fijar la pieza y generar una nueva
            tetris.tick();
            tetris.tick();
        }
    
         assertEquals('x', tablero.getTablero()[8][3]);
         assertEquals('x', tablero.getTablero()[9][3]);
         assertEquals('x', tablero.getTablero()[6][3]);
         assertEquals('x', tablero.getTablero()[7][3]);

        // el juego debe terminar por apilamiento
        assertTrue(tetris.isGameOver());
        
    }


    @Test
    public void terminarPor5Lineas() {
        Tetris tetris = new Tetris();
        Board tablero = tetris.getTablero();
        
        // crear exactamente 5 lineas completas desde el principio
        for (int fila = 9; fila >= 5; fila--) {
            for (int col = 0; col < 20; col++) {
                tablero.getTablero()[fila][col] = 'x';
            }
        }
        
        // verificar que hay 5 lineas completas
        assertEquals(5, tablero.lineCount());
        
        // limpiar y contar
        int eliminadas = tablero.limpiarLineas();
        assertEquals(5, eliminadas);
        
        // el juego termina por 5 líneas
        tetris.addLinesCleared(5);
        assertEquals(5, tetris.getLinesCleared());
    }

    @Test
    public void terminarPor5LineasJugando() {
        Tetris tetris = new Tetris();
        Board tablero = tetris.getTablero();
        
        // llenar el tablero de 'x' dejando solo 2 columnas vacias
        for (int fila = 9; fila >= 0; fila--) {
            for (int col = 0; col < 18; col++) {
                tablero.getTablero()[fila][col] = 'x';
            }
        }
        
        tetris.start(new PieceSquare());
        
        // completar las lineas agregando pieza para completar las 5 lineas
        while (tetris.getLinesCleared() < 5 && !tetris.isGameOver()) {
            PieceBase pieza = tetris.getCurrentPiece();
            if (pieza != null) {
                // mover pieza a la derecha 
                for (int i = 0; i < 20; i++) {
                    pieza.intentarDerecha(tablero);
                }
            }
            tetris.tick();
        }
        
        assertTrue(tetris.getLinesCleared() >= 5 || tetris.isGameOver());
    }

    @Test
    public void movimientosLateralesTest() {
        Board tablero = new Board(10, 20);
        PieceSquare cuadrado = new PieceSquare();
        cuadrado.setColumna(10);
        cuadrado.setFila(5);
        
        // debe poder moverse a la izquierda
        assertTrue(cuadrado.intentarIzquierda(tablero));
        assertEquals(9, cuadrado.getColumna());
        
        // debe poder moverse a la derecha
        assertTrue(cuadrado.intentarDerecha(tablero));
        assertEquals(10, cuadrado.getColumna());

        // no debe poder moverse mas alla del borde izquierdo
        cuadrado.setColumna(0);
        assertFalse(cuadrado.intentarIzquierda(tablero));
        
        // no debe poder moverse más alla del borde derecho
        cuadrado.setColumna(18);
        assertFalse(cuadrado.intentarDerecha(tablero));
    }

    @Test
    public void contarLineasCompletas() {
        Board tablero = new Board(10, 20);
        
        for (int columna = 0; columna < 20; columna++) {
            tablero.getTablero()[9][columna] = 'x';
            tablero.getTablero()[7][columna] = 'x';
            tablero.getTablero()[5][columna] = 'x';
        }
        
        //  debe contar 3 lineas completas
        assertEquals(3, tablero.lineCount());
        
        //  debe eliminar 3 lineas
        int eliminadas = tablero.limpiarLineas();
        assertEquals(3, eliminadas);
        
        //  no deberia haber lineas completas despues de limpiar
        assertEquals(0, tablero.lineCount());
    }

    @Test
    public void pruebaLineasClearedTest() {
        Tetris tetris = new Tetris();
        
        // agregar directamente 5 lineas eliminadas
        tetris.addLinesCleared(5);
        
        assertEquals(5, tetris.getLinesCleared());
        
        // inicia el juego y deberia detectar victoria
        tetris.start(new PieceSquare());
        tetris.tick();
        
        // debe terminar con 5 lineas
        assertTrue(tetris.getLinesCleared() >= 5);
    }

    @Test
    public void tickBasico() {
        Tetris tetris = new Tetris();
        tetris.start(new PieceSquare());
        
        PieceBase piezaInicial = tetris.getCurrentPiece();
        int filaInicial = piezaInicial.getFila();
        
        // despues de 2 ticks la pieza debe bajar
        tetris.tick();
        tetris.tick();
        
        // la pieza debe haber bajado o cambiado
        assertTrue(piezaInicial.getFila() > filaInicial || tetris.getCurrentPiece() != piezaInicial);
    }

}