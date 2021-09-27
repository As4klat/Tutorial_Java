package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        //System.out.println(palabraMasRepite("quijote.txt"));

        clasificaFicheros();
    }

    private static void clasificaFicheros()
    {
        int i, pos;
        List<String> listaExtensiones = new ArrayList<>();
        List<Integer> listaVeces = new ArrayList<>();
        String extension, fich;

        File dir = new File(".");
        File[] ficheros = dir.listFiles();

        for (i = 0; i < ficheros.length; i++)
        {
            if (ficheros[i].isFile())
            {
                fich = ficheros[i].getName();
                if (fich.contains("."))
                {
                    pos = fich.lastIndexOf(".");
                    extension = fich.substring(pos + 1);
                }
                else
                {
                    extension = "(sin extensión)";
                }

                pos = listaExtensiones.indexOf(extension);
                if (pos == -1)
                {
                    listaExtensiones.add(extension);
                    listaVeces.add(1);
                }
                else
                {
                    listaVeces.set(pos, listaVeces.get(pos) + 1);
                }
            }
        }

        for (i = 0; i < listaExtensiones.size(); i++)
        {
            System.out.println(listaExtensiones.get(i) + " -> "
                    + listaVeces.get(i));
        }
    }

    private static String palabraMasRepite(String fichero)
    {
        List<String> listaPalabras = new ArrayList<>();
        List<Integer> listaVeces = new ArrayList<>();
        String linea;
        String[] palabras;
        int i, pos;

        try
        {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            linea = br.readLine();

            while(linea != null)
            {
                linea = limpiaCadena(linea);
                linea = linea.toLowerCase();
                palabras = linea.split(" ");

                for(i = 0; i < palabras.length; i++)
                {
                    pos = listaPalabras.indexOf(palabras[i]);
                    if(pos == -1)
                    {
                        // Si no está, la añado a la lista
                        listaPalabras.add(palabras[i]);
                        listaVeces.add(1);
                    }
                    else
                    {
                        // Si está, le sumo 1 a las veces que se repite
                        listaVeces.set(pos, listaVeces.get(pos) + 1);
                    }
                }

                linea = br.readLine();
            }

            br.close();
            fr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        int max = Collections.max(listaVeces);
        int posMax = listaVeces.indexOf(max);
        String palabraMax = listaPalabras.get(posMax);

        return palabraMax;
    }

    public static String limpiaCadena(String s)
    {
        int i;
        String res = "";

        for(i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == ' ' || Character.isLetter(s.charAt(i)))
            {
                res = res + s.charAt(i);
            }
        }

        return res;
    }
}
