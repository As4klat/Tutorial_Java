package com.mycompany.ejercicio1;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NewMain {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("""
                         -----------------------------------------------
                         Esto es una demo del 7 y medio.
                         -----------------------------------------------
                         Selecione tipo de baraja: 1 - 40 cartas | 2 - 80 cartas
                         ->
                         """);
        int tipoBaraja = sc.nextInt();
        
        Baraja b = new Baraja(tipoBaraja, true);
        
        System.out.println("Selecione el numero de jugadores (1-4):");
        int numeroJugadores = sc.nextInt();
        
        if(numeroJugadores > 1)
        {
            System.out.println("""
                             Esta opion no esta aun disponible.
                             Pasaras a modo un jugador""");
            /*
            List<Jugadores> listJugadores = new LinkedList<>();
            */
        }
        System.out.println("Se han generado:" + b.numeroCartas());
        
        boolean plantado=false;
        List<Carta> mano = new LinkedList<>();
        String respuesta;
        double cont=0;
        
        while(!plantado){
            System.out.println("¿Quieres robar? y/n");
            respuesta = sc.next();
            if(respuesta.equals("y")){
                mano.add(b.robar());
                cont = cont + mano.get(mano.size()-1).valor7ymedia();
                System.out.println(mano.get(mano.size()-1).nombreCarta() + " | valor: " + mano.get(mano.size()-1).valor7ymedia());
                System.out.println("Total:" + cont);
                if(gameOver(cont)){
                    plantado = true;
                    System.out.println("Lo sineto, has perdido");
                }
            }
            else
            {
                plantado = true;
                System.out.println("Te has plantado con: " + cont + " puntos.");
            }        
        }
    }
    public static boolean gameOver(double cont){
        boolean over=false;
        if(cont >= 7.5)
        {
            over=true;
        }
        return over;
    }
}
