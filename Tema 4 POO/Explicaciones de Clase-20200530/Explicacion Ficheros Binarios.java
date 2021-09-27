package com.company;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        // Escribiendo un fichero binario

        try
        {
            FileOutputStream fos = new FileOutputStream("fichero1.bin");
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeInt(5);
            dos.writeInt(100);
            dos.writeInt(1000);

            dos.writeDouble(0.1);

            dos.writeUTF("patata");

            dos.close();
            fos.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


        // Leyendo un fichero binario
        try
        {
            FileInputStream fis = new FileInputStream("fichero1.bin");
            DataInputStream dis = new DataInputStream(fis);

            int n1 = dis.readInt();
            int n2 = dis.readInt();
            int n3 = dis.readInt();
            System.out.println(n1 + ", " + n2 + ", " + n3);

            double d = dis.readDouble();
            System.out.println(d);

            String s = dis.readUTF();
            System.out.println(s);

            dis.close();
            fis.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        // Leyendo un fichero binario si no se sabe cuántos datos hay
        // Hay que saber al menos cuál es el tipo de los datos

        try
        {
            FileInputStream fis = new FileInputStream("fichero2.bin");
            DataInputStream dis = new DataInputStream(fis);
            int n;

            while(dis.available() > 0)
            {
                n = dis.readInt();
                System.out.println(n);
            }

            dis.close();
            fis.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
