/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocartas;
import java.util.Scanner;
/**
 *
 * @author rosa
 */
public class JuegoCartas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numeroJugadores=2;
        
        Juego j=new Juego(numeroJugadores); //podremos facilmente añadir más jugadores
        
        for (int i=0; i< numeroJugadores; i++){
            System.out.println("Introduzca nombre jugador: ");
            String nombre=sc.nextLine();
            j.CrearJugador(nombre, i);          
        }
    
        System.out.println("\nGENERANDO BARAJA.....");
        Baraja miBaraja=j.getBaraja();
        miBaraja.Barajar();
        System.out.println( miBaraja.toString());
        
        System.out.println("\nREPARTIENDO CARTAS....");     
        j.RepartirCartas();     
        for (int i=0;i<numeroJugadores;i++)
            System.out.println(j.getJugador(i).toString());
      
        Jugador ganador=j.Jugar();
        System.out.println("\nGANA LA PARTIDA EL JUGADOR.....");   
        System.out.println(ganador.toString());
        System.out.println("CON UNA PUNTUACIÓN DE: "+ganador.getPuntosTotales());
    }
        
        
    
    
    
}
