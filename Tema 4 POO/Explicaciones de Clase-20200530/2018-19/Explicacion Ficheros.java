package com.company;

import java.io.*;

public class Main
{

    public static void main(String[] args)
    {

        try
        {
            // ---- Escribir ficheros de texto ----
            FileWriter fw = new FileWriter("prueba.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Patata");
            bw.newLine();
            // Te pone el salto de línea correspondiente
            // a tu sistema operativo:
            // Windows: \r\n
            // Linux: \n
            // Mac: \r
            bw.write("Tomate");
            bw.newLine();

            bw.close();
            fw.close();


            // ---- Leer ficheros de texto ----
            FileReader fr = new FileReader("prueba.txt");
            BufferedReader br = new BufferedReader(fr);

            String linea1 = br.readLine();
            String linea2 = br.readLine();

            br.close();
            fr.close();

            System.out.println(linea1 + " - " + linea2);


            // ---- Leer ficheros de texto 2 ----
            String s;
            fr = new FileReader("prueba2.txt");
            br = new BufferedReader(fr);

            s = br.readLine();
            while(s != null)
            {
                System.out.println(s);
                s = br.readLine();
            }

            br.close();
            fr.close();


            // ---- Escribir ficheros binarios ----
            FileOutputStream fos = new FileOutputStream("prueba.bin");
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeInt(10);
            dos.writeInt(20);
            dos.writeInt(30);
            dos.writeInt(40);

            dos.close();
            fos.close();

            // ---- Leer ficheros binarios ----
            FileInputStream fis = new FileInputStream("prueba.bin");
            DataInputStream dis = new DataInputStream(fis);

            int n = dis.readInt();
//            double d = dis.readDouble();
//            char c = dis.readChar();
//            boolean b = dis.readBoolean();
//            String s1 = dis.readUTF();

            System.out.println(n);

            dis.close();
            fis.close();


            // ---- Leer ficheros binarios 2 ----
            fis = new FileInputStream("prueba.bin");
            dis = new DataInputStream(fis);

            while(dis.available() > 0)
            {
                n = dis.readInt();
                System.out.println(n);
            }

            dis.close();
            fis.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
