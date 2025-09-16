package com.mycompany.app;
    
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

}
