package com.mycompany.app;

public class PieceDogL extends Tetris  {

    private final String [] posiciones;
    private int rotacionActual = 0;
    
    public PieceDogL() {

        super("ooooooooxxoooxxo", "DogL");

        posiciones = new String [2];

        posiciones[0]= 
            "oooo\n" +
            "oooo\n" +
            "xxoo\n" +
            "oxxo";
        posiciones[1]=
            "oxoo\n" +
            "xxoo\n" +
            "xooo\n" +
            "oooo";
        }

        @Override
        public String getPosicionActual() {
            return posiciones[rotacionActual];
        }

        @Override
        public void rotarIzquierda(){
            rotacionActual = (rotacionActual - 1 + posiciones.length) % posiciones.length;
            
        }
      
        @Override
        public void rotarDerecha(){
            rotacionActual = (rotacionActual + 1 ) % posiciones.length;
           
        }

        public int getRotacionActual() {
            return rotacionActual;
        }


    
  


}
