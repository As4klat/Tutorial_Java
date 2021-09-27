/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.grupo_y_alumno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alejandro
 */
public class Grupo {
    List<Alumno> listaAlumnos;
    
    public Grupo(){
        listaAlumnos = new LinkedList<>();
    }
    public Grupo(int nAlumnos, int nCreados){
        this();
        for(int i = 0; i < nAlumnos; i++){
            Alumno a = new Alumno(nombreRandom(),edadRandom(),notaRandom());
            this.listaAlumnos.add(a);
        }
        if(nCreados != 0){
            if(nCreados < 0){
                throw new InvalidParameterException("Numero de creados no puede ser negativo");
            }
            else{
                Scanner sc = new Scanner(System.in);
                for(int i = 0; i < nCreados; i++){
                    System.out.println("Datos del alumno numero " + (i+1));
                    System.out.println("Nombre: ");
                    String nombre = sc.next();
                    System.out.println("Edad: ");
                    int edad = sc.nextInt();
                    System.out.println("Nota: ");
                    double nota = sc.nextDouble();
                    Alumno a = new Alumno(nombre,edad,nota);
                    this.listaAlumnos.add(a);
                }
            }
        }
    }
    
    /*
    Metodos
    */
    private String nombreRandom(){
        Random r = new Random();
        String nombre = "";
        String[] nombreArray = {
            "Alejandro",
            "Juan",
            "Antonio",
            "Paco",
            "Santi",
            "Adrian",
            "Manolo",
            "Mario",
            "David",
            "Elena",
            "Ana",
            "Maribel",
            "Maria",
            "Laura",
            "Rocio",
            "Verónica",
            "Paula",
        };
        String[] apellidoArray = {
            "Gamaza",
            "Martínez",
            "Setó",
            "Rubio",
            "Amarillo",
            "García",
            "Rodríguez",
            "Fernández",
            "Sánchez",
            "Alonso",
            "Torres",
            "Blanco",
            "Suarez",
        };
        
        nombre += nombreArray[r.nextInt(nombreArray.length)];
        nombre += " " + apellidoArray[r.nextInt(apellidoArray.length)] + " ";
        nombre += apellidoArray[r.nextInt(apellidoArray.length)];
        
        return nombre;
    }
    private int edadRandom(){
        Random r = new Random();
     return r.nextInt(100-18)+18;
    }
    private double notaRandom(){
        Random r = new Random();
     return 1 + (10 - 1) * r.nextDouble();
    }
    
    public void insertarAlumnoLista(Alumno a){
        this.listaAlumnos.add(a);
    }
    public void insertarAlumnoLista(String nombre, int edad, double nota){
        Alumno a = new Alumno(nombre,edad,nota);
        insertarAlumnoLista(a);
    }
    public String toString(){
        String text="";
        
        for(int i=0; i<this.listaAlumnos.size();i++){
            
            text += "---------------------------------------" +
                    this.listaAlumnos.get(i).toString();
            
        }
        return text;
    }
    public void escribeFicheroBinario(String fichero){
         try
        {
            FileOutputStream fos = new FileOutputStream(fichero);
            DataOutputStream dos = new DataOutputStream(fos);

            int i;
            dos.writeInt(this.listaAlumnos.size());
            for (i=0;i<this.listaAlumnos.size();i++)
            {
                dos.writeUTF(this.listaAlumnos.get(i).getNombre());
                dos.writeInt(this.listaAlumnos.get(i).getEdad());
                dos.writeDouble(this.listaAlumnos.get(i).getNota());
            }

            dos.close();
            fos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void escribeFicheroTexto(String fichero){
        try
        {
            FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);

            int i;
            bw.write(this.listaAlumnos.size() + System.lineSeparator());

            for (i=0;i<this.listaAlumnos.size();i++)
            {
                bw.write(this.listaAlumnos.get(i).getNombre() + System.lineSeparator());
                bw.write(this.listaAlumnos.get(i).getEdad() + System.lineSeparator());
                bw.write(String.valueOf(this.listaAlumnos.get(i).getNota()) + System.lineSeparator());
            }

            bw.close();
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void leeFicheroTexto(String fichero){
        try
        {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            int i, temp;

            temp = Integer.parseInt(br.readLine());
            this.listaAlumnos.clear();

            for (i=0;i<temp;i++)
            {
                Alumno a = new Alumno(br.readLine(),Integer.parseInt(br.readLine()),Double.parseDouble(br.readLine()));
                this.listaAlumnos.add(a);
            }

            br.close();
            fr.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void escribeFicheroCSV(String fichero){
        try
        {
            FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);

            int i;

            for (i=0;i<this.listaAlumnos.size();i++)
            {
                bw.write(this.listaAlumnos.get(i).getNombre() + ";");
                bw.write(this.listaAlumnos.get(i).getEdad() + ";");
                bw.write(String.valueOf(this.listaAlumnos.get(i).getNota()) + System.lineSeparator());
            }

            bw.close();
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /*
    public void leeFicheroCSV(String fichero){
        try
        {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            this.listaAlumnos.clear();
            String linea = br.readLine();

            while (linea!=null)
            {
                Alumno a = new Alumno();
                String[] aAlumno = linea.split(";");
                a.setNombre(aAlumno[0]);
                a.setEdad(Integer.parseInt(aAlumno[1]));
                a.getNota(Double.parseDouble(aAlumno[2]));
                this.listaAlumnos.add(a);
                linea = br.readLine();
            }

            br.close();
            fr.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    */
    
}
