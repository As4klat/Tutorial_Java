package com.company;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void servidor()
    {
        try
        {
            ServerSocket server = new ServerSocket(1000);

            while(true)
            {
                Socket soc = server.accept();

                // Leer cosas: Scanner
                //Scanner sc = new Scanner(soc.getInputStream());

                // Para escribir cosas: PrintWriter
                PrintWriter pw = new PrintWriter(soc.getOutputStream(), true);

                pw.println("Hola - Bienvenidos al servidor");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void servidor2()
    {
        try
        {
            ServerSocket server = new ServerSocket(1001);

            while(true)
            {
                Socket soc = server.accept();

                PrintWriter pw = new PrintWriter(soc.getOutputStream(), true);

                for(int i = 1; i < 1000; i++)
                {
                    pw.println(i);
                    Thread.sleep(1000);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void servidor3()
    {
        try
        {
            ServerSocket server = new ServerSocket(1001);
            ExecutorService pool = Executors.newFixedThreadPool(20);

            while(true)
            {
                Socket soc = server.accept();
                pool.execute(new subProceso(soc));
                System.out.println("Conectado: " + soc);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static class subProceso implements Runnable
    {
        private Socket soc;

        public subProceso(Socket soc)
        {
            this.soc = soc;
        }

        public void run()
        {
            try
            {
                PrintWriter pw = new PrintWriter(soc.getOutputStream(), true);

                for (int i = 1; i < 1000; i++)
                {
                    pw.println(i);
                    Thread.sleep(1000);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void cliente()
    {
        try
        {
            Socket soc = new Socket("172.30.10.200", 1000);

            Scanner sc = new Scanner(soc.getInputStream());
            String linea = sc.nextLine();

            System.out.println(linea);

            soc.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void cliente2()
    {
        try
        {
            Socket soc = new Socket("172.30.10.200", 1001);

            Scanner sc = new Scanner(soc.getInputStream());

            while(true)
            {
                System.out.println(sc.nextInt());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        servidor3();
    }
}
