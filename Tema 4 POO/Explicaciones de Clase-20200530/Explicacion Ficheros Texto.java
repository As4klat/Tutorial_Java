package com.company;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        // Escribir en un fichero de texto
        // FileWriter y BufferedWriter

        try
        {
            FileWriter fw = new FileWriter("fichero.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Hola mundo" + System.lineSeparator());
            //bw.write("Hola mundo\r\n"); para windows
            //bw.write("Hola mundo\n"); para linux
            //bw.write("Hola mundo\r"); para mac
            bw.write("Adiós mundo");

            bw.close();
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Leer de un fichero
        // FileReader y BufferedReader

        try
        {
            FileReader fr = new FileReader("fichero.txt");
            BufferedReader br = new BufferedReader(fr);

            String linea = br.readLine();
            System.out.println(linea);

            linea = br.readLine();
            System.out.println(linea);

            System.out.println(br.readLine());

            br.close();
            fr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            String linea;
            FileReader fr = new FileReader("fichero.txt");
            BufferedReader br = new BufferedReader(fr);

            linea = br.readLine();
            while(linea != null)
            {
                System.out.println(linea);
                linea = br.readLine();
            }

//            while((linea = br.readLine()) != null)
//            {
//                System.out.println(linea);
//            }

            br.close();
            fr.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
