/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocartas;
import java.util.*;
/**
 *
 * @author rosa
 */
public class Jugador {
    private String nombre;
    private Vector<Carta> mazo;
    private int puntosTotales;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mazo = new Vector<Carta>(40);
    }
    
    public Carta sacaCarta(){
        Carta c=mazo.get(0);
        mazo.remove(0);
        return c;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }
    
    public void setPuntos(){
        int puntos=0;
        for (int i=0;i<mazo.size();i++){
            puntos=mazo.get(i).getNumero();
            switch(puntos){
                case 8:
                    puntos=10;
                    break;
                case 9:
                    puntos=11;
                    break;
                case 10:
                    puntos=12;
                    break;
            }
            this.puntosTotales+=puntos;
         }
    }
    
    public void cogeCarta(Carta c){
        mazo.add(c);
    }

    @Override
    public String toString() {
        String cadena="";   
        for (int i=0;i<mazo.size();i++)
            cadena+="\n" + mazo.get(i).toString();
        return "\nJUGADOR " +  nombre + cadena;
    }
    
    
    
}
