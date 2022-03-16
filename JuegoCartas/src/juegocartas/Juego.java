/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocartas;
import java.util.Vector;
/**
 *
 * @author rosa
 */
public class Juego {
    private Jugador [] jugadores;
    private Baraja b;
    private Vector<Carta> mazoMesa=new Vector<Carta>(40);
    

    public Juego(int numeroJugadores) {
        this.jugadores=new Jugador[numeroJugadores];
        this.b=new Baraja();
    }
     
    public void CrearJugador(String nombre, int posicion){
        this.jugadores[posicion]=new Jugador(nombre);
        
    }

    public Baraja getBaraja() {
        return b;
    }
    
    public Jugador getJugador(int posicion){
        return this.jugadores[posicion];
    }
    
   public void RepartirCartas(){
      int rondas=this.b.getNumeroCartas()/this.jugadores.length;
      for (int j=1;j<=rondas;j++){
        for (int i=0;i<this.jugadores.length;i++)
          this.jugadores[i].cogeCarta(b.repartirCarta());
      }    
       
   } 
   
   public Jugador Jugar(){
        System.out.println("");
        for (int ronda=1;ronda<21;ronda++){
            System.out.println("\nRonda "+ronda);
            System.out.println("\nJugadores echan carta");
            Carta c1=jugadores[0].sacaCarta();
            Carta c2=jugadores[1].sacaCarta();
            System.out.println("Jugador 1: "+c1.toString());
            System.out.println("Jugador 2: "+c2.toString());
            if (c1.getNumero()>c2.getNumero()) 
                GanarBaza(1,c1,c2);
            else {
                if (c2.getNumero()>c1.getNumero()) 
                    GanarBaza(2,c1,c2);       
                else {
                    System.out.println("Empate");
                    mazoMesa.add(c1);
                    mazoMesa.add(c2);		
                }
                
            }
        }
        for (int i=0;i<this.jugadores.length;i++)
            jugadores[i].setPuntos();
         
        int ganador= QuienGana();
        return  this.jugadores[ganador];
   }
            
   
   
   private void GanarBaza(int j, Carta c1, Carta c2){
        System.out.println("Gana jugador "+ j);
        jugadores[j-1].cogeCarta(c1);
        jugadores[j-1].cogeCarta(c2);        
        if(mazoMesa.size()!=0){
            for(int i=0;i<mazoMesa.size();i++) {
                jugadores[0].cogeCarta(mazoMesa.get(0));
                mazoMesa.remove(0);		 	
            }
                
        }
   }
   
   private int QuienGana(){
       int maxpuntos=0,j=0;
       for (int i=0;i<this.jugadores.length;i++){
           if (this.jugadores[i].getPuntosTotales()>maxpuntos)
           {
               maxpuntos=this.jugadores[i].getPuntosTotales();
               j=i;
               
               
           }
       }
       return j;
   }
    
}
