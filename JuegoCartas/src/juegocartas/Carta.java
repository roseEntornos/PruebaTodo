/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocartas;

/**
 *
 * @author rosa
 */
public class Carta {
    private int palo;
    private int numero;

    final String numeros[]={"As","Dos","Tres","Cuatro","Cinco","Seis","Siete","Sota","Caballo","Rey"};
    final String palos[]={"oros","copas","espadas","bastos"};

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public String getPalo() {
        return palos[palo];
    }
    
     public int getNumero() {
        int n=this.numero;
        switch(numero){
            case 8:
                n=10;
                break;
            case 9:
                n=11;
                break;
            case 10:
                n=12;    
                break;
            }
        return n;
 
    }

    @Override
    public String toString() {
        return numeros[numero-1] + " de " + palos[palo];
    }
     
     
    
}
