package com.mycompany.ejercicio1;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Baraja {
    private List<Carta> listaCartas;
    
    public Baraja(){
        this.listaCartas = new LinkedList<>();
    }
    
    public Baraja(int tipoBaraja){
        this();
        switch(tipoBaraja){
            case 1:
                for (int i = 1; i <= 40; i++){
                    Carta c = new Carta(i);
                    this.listaCartas.add(c);
                }
                break;
            case 2:
                boolean comp = true;
                for (int i = 1; i <= 40; i++){
                    Carta c = new Carta(i);
                    this.listaCartas.add(c);
                    if(i == 40 && comp){
                        i=0;
                        comp=false;
                    }
                }
                break;

            default:
                throw new InvalidParameterException("El tipo de baraja es incorrecto. Pruebe 1 o 2");
        }
    }
    
    public Baraja(int tipoBaraja, boolean barajar){
        this(tipoBaraja);
        
        if (barajar || !barajar)
        {
            if(barajar)
            {
                Collections.shuffle(this.listaCartas);
            }
        }
        else
        {
            throw new InvalidParameterException("Boolean barajar no válido");
        }
    }
    
    public void barajar(){
        Collections.shuffle(this.listaCartas);
    }
    
    public void cortar(int numeroCartas){
        List<Carta> aux = new LinkedList<>();
        for(int i = numeroCartas; i < this.listaCartas.size(); i++){
            aux.add(this.listaCartas.get(i));
        }
        for(int i = 0; i < numeroCartas; i++){
            aux.add(this.listaCartas.get(i));
        }
        this.listaCartas.clear();
        this.listaCartas.addAll(aux);
    }
    
    public Carta robar(){
        Carta c = this.listaCartas.get(0);
        this.listaCartas.remove(0);
        return c;
    }
    
    public void insertarCartaFinal(int idCarta){
        Carta c = new Carta(idCarta);
        this.listaCartas.add(c);
    }
    
    public void insertarCartaPrincipio(int idCarta){
        Carta c = new Carta(idCarta);
        this.listaCartas.add(0, c);
    }
    
    public void insertarCartaFinal(Carta c){
        this.listaCartas.add(c);
    }
    
    public void insertarCartaPrincipio(Carta c){
        this.listaCartas.add(0, c);
    }
    
    public int numeroCartas(){
        return this.listaCartas.size();
    }
    
    public boolean vacia(){
        return this.listaCartas.isEmpty();
    }
    
    
    /*pruebas*/
   
    public void vaciar(){
        this.listaCartas.clear();
    }
    
    public List<Carta> getListaCartas(){
        return this.listaCartas;
    }
}
