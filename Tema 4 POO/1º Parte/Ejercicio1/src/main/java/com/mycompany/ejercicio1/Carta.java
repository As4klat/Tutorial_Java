package com.mycompany.ejercicio1;

import java.security.InvalidParameterException;

public class Carta {
    private int numero;
    private int palo;
    
    public Carta(int numeroCarta, int paloCarta){
        if ((numeroCarta >= 1 && numeroCarta <= 10) && (paloCarta >= 0 && paloCarta <= 3)){
            this.numero = numeroCarta;
            this.palo = paloCarta;
        }
        else{
            throw new InvalidParameterException("El numero o el palo son incorrectos");
        }
    }
    
    public Carta(int cartaId){

        if (cartaId >= 1 && cartaId <= 40){
            
            if (cartaId % 10 == 0)
            {
                this.numero = 10;
            }
            else
            {
                this.numero = cartaId % 10;
            }
            if (cartaId / 11 == 0)
            {
                this.palo = 0;
            }
            else
            {
                if(cartaId % 10==0){
                    this.palo = cartaId/10 - 1;
                }
                else{
                    this.palo = cartaId/10;
                }   
            }
        }
        else{
            throw new InvalidParameterException("El id de la carta no es correcto");
        }
    }
    
    /*
    * Getters
    */
    public int getNumero(){
        return this.numero;
    }
    public int getPalo(){
        return this.palo;
    }
    
    public String nombreNumero(){
        enumNumero[] e = enumNumero.values();
        return e[this.numero-1].getNombreBien();
    }
    
    public String nombrePalo(){
        enumPalo[] e = enumPalo.values();
        return e[this.palo].getPaloBien();
    }
    
    public String nombreCarta(){
        return nombreNumero() + " de " + nombrePalo();
    }
    
    public int valorTute(){
        int[] tuteArray = {11,0,10,0,0,0,0,2,3,4};
        return tuteArray[this.numero-1];
    }
    
    public int valorMus(){
        int[] tuteArray = {1,1,10,4,5,6,7,10,10,10};
        return tuteArray[this.numero-1];
    }
    
    public double valor7ymedia(){
        double valor;
        if(this.numero >= 8 && this.numero <= 10){
            valor = 0.5;
        }
        else
        {
            valor = this.numero;
        }
        return valor;
    }
}
