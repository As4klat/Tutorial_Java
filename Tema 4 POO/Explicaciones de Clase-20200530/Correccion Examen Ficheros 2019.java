package com.company;

import jdk.jfr.DataAmount;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
//        String fichero = "quijote.txt";
//        cuatrovocales(fichero);

//        int[][] sudoku =
//                {{3,7,1,2,8,9,5,4,6},
//                {4,8,6,1,3,5,9,7,2},
//                {2,9,5,4,7,6,8,3,1},
//                {7,3,2,6,9,8,1,5,4},
//                {8,6,9,5,1,4,3,2,7},
//                {5,1,4,7,2,3,6,9,8},
//                {9,4,3,8,6,7,2,1,5},
//                {6,2,7,9,5,1,4,8,3},
//                {1,5,8,3,4,2,7,6,9}};

//        escribeSudoku("sudoku1.bin", sudoku);
//        int[][] sudoku2 = leeSudoku("sudoku1.bin");

        List<String> ciudades = new ArrayList<>(Arrays.asList("Jerez", "La línea", "Tarifa", "Barbate"));
        List<Double> temperaturas = new ArrayList<>(Arrays.asList(18.9, 13.0, 14.1, 18.6));

        haceCalor(ciudades, temperaturas);

        System.out.println(ciudades);
        System.out.println(temperaturas);
    }

    private static void haceCalor(List<String> ciudades, List<Double> temperaturas)
    {
        if(ciudades.size() == temperaturas.size())
        {
            int i;
            double suma = 0;
            double media;

            for(i = 0; i < temperaturas.size(); i++)
            {
                suma = suma + temperaturas.get(i);
            }
            media = suma / temperaturas.size();

            for(i = 0; i < temperaturas.size(); i++)
            {
                if(temperaturas.get(i) < media)
                {
                    temperaturas.remove(i);
                    ciudades.remove(i);
                    i--;
                }
            }




        }
        else
        {
            System.out.println("Las listas tienen distinto tamaño");
        }
    }

    private static int[][] leeSudoku(String fichero)
    {
        boolean bien = true;
        int i, j, cont;
        List<Integer> lista = new ArrayList<>();
        int[][] sudoku = null;

        if(Files.exists(Path.of(fichero)) && Files.isRegularFile(Path.of(fichero)))
        {
            try
            {
                FileInputStream fis = new FileInputStream(fichero);
                DataInputStream dis = new DataInputStream(fis);

                if(dis.readUTF().equals("SUDOKU"))
                {
                    while(dis.available() > 0)
                    {
                        lista.add(dis.readInt());
                    }

                    if(lista.size() == 81)
                    {
                        for(i = 0; i < lista.size(); i++)
                        {
                            if(lista.get(i) > 9 || lista.get(i) < 0)
                            {
                                bien = false;
                                i = lista.size();
                            }
                        }

                        if(bien)
                        {
                            sudoku = new int[9][9];

                            cont = 0;
                            for (i = 0; i < 9; i++)
                            {
                                for (j = 0; j < 9; j++)
                                {
                                    sudoku[i][j] = lista.get(cont);
                                    cont++;
                                }
                            }
                        }
                    }
                    else
                    {
                        bien = false;
                    }
                }
                else
                {
                    bien = false;
                }

                dis.close();
                fis.close();

            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            bien = false;
        }

        if(!bien)
        {
            System.out.println("Error");
        }

        return sudoku;
    }

    private static void escribeSudoku(String fichero, int[][] sudoku)
    {
        int i, j;
        boolean bien;

        if(sudoku.length == 9 && sudoku[0].length == 9)
        {
            bien = true;

            for(i = 0; i < 9; i++)
            {
                for(j = 0; j < 9; j++)
                {
                    if(sudoku[i][j] > 9 || sudoku[i][j] < 0)
                    {
                        bien = false;
                        i = 9;
                        j = 9;
                    }
                }
            }

            if(bien)
            {
                try
                {
                    FileOutputStream fos = new FileOutputStream(fichero);
                    DataOutputStream dos = new DataOutputStream(fos);

                    dos.writeUTF("SUDOKU");
                    for(i = 0; i < 9; i++)
                    {
                        for(j = 0; j < 9; j++)
                        {
                            dos.writeInt(sudoku[i][j]);
                        }
                    }

                    dos.close();
                    fos.close();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }

            }
        }
        else
        {
            bien = false;
        }

        if(!bien)
        {
            System.out.println("No se ha podido escribir el fichero porque el array no es válido");
        }
    }

    private static void cuatrovocales(String fichero)
    {
        List<String> cuatroVocales = new ArrayList<>();
        String linea;
        String[] palabras;
        int i;

        try
        {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            linea = br.readLine();
            while(linea != null)
            {
                linea = limpiaCadena(linea);
                palabras = linea.split(" ");

                for(i = 0; i < palabras.length; i++)
                {
                    if(tiene4vocales(palabras[i]))
                    {
                        if(!cuatroVocales.contains(palabras[i]))
                        {
                            cuatroVocales.add(palabras[i]);
                        }
                    }
                }

                linea = br.readLine();
            }

            br.close();
            fr.close();

            FileWriter fw = new FileWriter("4vocales.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for(i = 0; i < cuatroVocales.size(); i++)
            {
                bw.write(cuatroVocales.get(i));
                bw.newLine();
            }

            bw.close();
            fw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private static boolean tiene4vocales(String palabra)
    {
        int nVocales = 0, i;
        palabra = palabra.toLowerCase();

        for(i = 0; i< palabra.length(); i++)
        {
            if(esVocal(palabra.charAt(i)))
            {
                nVocales++;
            }
        }

        if(nVocales >= 4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static boolean esVocal(char charAt)
    {
        String vocales = "aeiouáéíóúü";
        if(vocales.indexOf(charAt) != -1)
        {
            return true;
        }
        else
        {
            return false;
        }
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
