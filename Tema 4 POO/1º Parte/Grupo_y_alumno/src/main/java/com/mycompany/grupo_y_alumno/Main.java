/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.grupo_y_alumno;

import java.util.Scanner;

/**
 *
 * @author Alejandro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introducir alumnos generados aleatoriamente: ");
        int nAlumnos = sc.nextInt();
        System.out.println("Introducir alumnos generados manualmente: ");
        int nCreados = sc.nextInt();
        
        Grupo g = new Grupo(nAlumnos, nCreados);
        
        boolean exit = false;
        while(!exit){
            System.out.println("");
            System.out.println("----------------------------");
            System.out.println("Menu de selección");
            System.out.println("""
                               ----------------------------
                                1º Insertar un alumno
                                2º Mostrar alumnos
                                3º Crear binario
                                4º Leer binario
                                5º Crear fichero de texto
                                6º Leer fichero de texto
                                7º Crear CSV
                                8º Leer CSV
                                9º Exit
                               """);
            System.out.println("Marque opción (nº): ");
            int opcion = sc.nextInt();
            System.out.println("");
            
            switch(opcion){
                case 1:
                    System.out.println("Datos del alumno numero");
                    System.out.println("Nombre: ");
                    String nombre = sc.next();
                    sc.nextLine();
                    System.out.println("Edad: ");            
                    int edad = sc.nextInt();
                    System.out.println("Nota: ");
                    double nota = sc.nextDouble();
                    
                    g.insertarAlumnoLista(nombre, edad, nota);
                    
                    System.out.println("Alumno creado con exito!");
                    break;
                case 2:
                    System.out.println(g.toString());
                    break;
                case 3:
                    
                    break;
                case 4:
                    System.out.println("Esto es 4");
                    break;
                case 5:
                    System.out.println("Esto es 5");
                    break;
                case 6:
                    System.out.println("Esto es 6");
                    break;
                case 7:
                    System.out.println("Esto es 7");
                    break;
                case 8:
                    System.out.println("Esto es 8");
                    break;
                default:
                    System.out.println("Opcion no valida, volveras al menu");
                    break;
            }
            
            try {
                Thread.sleep(2*1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
}
