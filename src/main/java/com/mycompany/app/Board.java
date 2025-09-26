package com.mycompany.app;

public class Board {
    private final char[][] grid;

    public Board() { this(20, 10); }

    public Board(int rows, int cols) {
        grid = new char[rows][cols];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = 'o';
    }

    public char[][] getTablero() { return grid; }
    public int rows() { return grid.length; }
    public int cols() { return grid[0].length; }

    /** ¿Colisionaría la forma en (row,col)? */
    public boolean collides(String shape, int row, int col) {
        String[] lines = shape.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                if (lines[i].charAt(j) != 'x') continue;
                int rr = row + i, cc = col + j;
                if (rr < 0 || rr >= rows() || cc < 0 || cc >= cols()) return true;
                if (grid[rr][cc] == 'x') return true;
            }
        }
        return false;
    }

    /** Fija definitivamente la forma en el tablero (escribe 'x'). */
    public void fix(String shape, int row, int col) {
        String[] lines = shape.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                if (lines[i].charAt(j) == 'x') {
                    grid[row + i][col + j] = 'x';
                }
            }
        }
    }

    /** Cuenta filas completas (opcional para tests de líneas). */
    public int lineCount() {
        int count = 0;
        for (int r = 0; r < rows(); r++) {
            boolean full = true;
            for (int c = 0; c < cols(); c++) {
                if (grid[r][c] != 'x') { full = false; break; }
            }
            if (full) count++;
        }
        return count;
    }
}
