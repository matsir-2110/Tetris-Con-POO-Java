package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public abstract class Tetris {
    private String forma;
    private String nombre;

    public Tetris(String formaInicial, String nombreP){
        setForma(formaInicial);
        setNombre(nombreP);
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

    public abstract void rotarIzquierda();
    public abstract void rotarDerecha();
    public abstract String getPosicionActual();

    public List<int[]> getCeldasOcupadas(int x, int y) {
        String m = getPosicionActual();   // String de 16 chars
        List<int[]> celdas = new ArrayList<>(); // cada celda: [columna, fila]

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                char c = m.charAt(i * 4 + j);
                if (c == 'x') {
                    celdas.add(new int[] {x + j, y + i});
                }
            }
        }
        return celdas;
    }

}
