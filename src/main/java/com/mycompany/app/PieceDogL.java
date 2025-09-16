package com.mycompany.app;

public class PieceDogL extends Tetris  {

    private final String [] posiciones;
    private int rotacionActual = 0;
    
    public PieceDogL() {

        super("ooooooooxxoooxxo", "DogL");

        posiciones = new String [2];

        posiciones[0]= "ooooooooxxoooxxo";
        posiciones[1]= "oxooxxooxooooooo";
    
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
