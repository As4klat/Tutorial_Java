/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejercicio1;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Bot {
    private List<Carta> mano;
    
    public Bot(){
        this.mano = new LinkedList<>();
    }
    
    public void robar(Carta c){
        this.mano.add(c);
    }
    /*
    public boolean pensar(){
        
    }*/
}
