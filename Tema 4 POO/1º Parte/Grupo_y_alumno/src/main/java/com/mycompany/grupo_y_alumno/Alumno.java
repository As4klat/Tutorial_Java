/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.grupo_y_alumno;

import java.security.InvalidParameterException;

/**
 *
 * @author Alejandro
 */
public class Alumno {
    private String nombre;
    private int edad;
    private double nota;

    public Alumno(String nombre, int edad, double nota) {
        setNombre(nombre);
        setEdad(edad);
        setNota(nota);
    }

    /*
    Getters
    */
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public double getNota() {
        return nota;
    }
    
    /*
    Setters
    */
    public void setNombre(String nombre) {
        if(!nombre.isBlank() && !nombre.isEmpty()){
            this.nombre = nombre;
        }
        else
        {
           throw new InvalidParameterException("El nombre no puede estar vacio");
        }
    }
    public void setEdad(int edad) {
        if(edad > 17 && edad < 100){
            this.edad = edad;
        }
        else
        {
            throw new InvalidParameterException("La edad no puede ser menor de 17 o mayor de 100");
        }
    }
    public void setNota(double nota) {
        if(nota >= 1 && nota <= 10){
            this.nota = nota;
        }
        else
        {
            throw new InvalidParameterException("Nota no esta entre 1 y 10");
        }  
    }
    
    /*
    Metodos
    */
    @Override
    public String toString() {
        return "--------------------------------------------" +
               "\nNombre: " + nombre +
               "\nEdad: " + edad + 
               "\nNota: " + nota;
    }
    
}
