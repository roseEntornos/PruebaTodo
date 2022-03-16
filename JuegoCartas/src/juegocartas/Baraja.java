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
public class Baraja {
    private Vector<Carta> baraja;
   
    
    public Baraja() {
        baraja=new Vector<Carta>(40);
        for (int p=0;p<4;p++){  //p=0 oros, p=1 copas, p=2 espadas p=3 bastos
            for (int n=1;n<11;n++) // n=8 sota, n=9 caballo, n=10 rey
                baraja.add(new Carta(p,n));         
        }
    }

    public void Barajar(){
        Collections.shuffle(baraja);
    }
    
    public Carta repartirCarta(){
        Carta c=baraja.get(0);
        baraja.remove(0);
        return c;
    }
    
    @Override
    public String toString() {
        String cadena="";
        for (int i=0;i<baraja.size();i++)
            cadena+="\n" + baraja.get(i).toString();
        return cadena;
    }

    public int getNumeroCartas(){
        return this.baraja.size();
    }
    
    
    
}
