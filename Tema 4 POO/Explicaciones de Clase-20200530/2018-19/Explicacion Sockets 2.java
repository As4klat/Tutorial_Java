package com.company;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void servidor2()
    {
        try
        {
            ServerSocket server = new ServerSocket(1001);

            while(true)
            {
                Socket soc = server.accept();
                int n;

                HiloRecibirServidor hrs = new HiloRecibirServidor(soc);
                Thread th = new Thread(hrs);
                th.start();

                Scanner sc = new Scanner(soc.getInputStream());

                while(true)
                {
                    n = sc.nextInt();
                    System.out.println("Cambiando indice a: " + n);
                    hrs.cambiaIndice(n);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static class HiloRecibirServidor implements Runnable
    {
        Socket socket;
        private volatile int i;

        HiloRecibirServidor(Socket socket)
        {
            this.socket = socket;
        }

        public void run()
        {
            try
            {
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

                for(i = 1; i < 1000; i++)
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

        public void cambiaIndice(int i)
        {
            this.i = i;
        }
    }


    public static void cliente2()
    {
        try
        {
            int n;
            Socket soc = new Socket("172.30.10.200", 1001);

            HiloRecibirCliente hr = new HiloRecibirCliente(soc);
            Thread hilo = new Thread(hr);
            hilo.start();

            Scanner sc2 = new Scanner(System.in);
            Scanner sc = new Scanner(soc.getInputStream());
            PrintWriter pw = new PrintWriter(soc.getOutputStream(), true);

            while(true)
            {
                n = sc2.nextInt();
                pw.println(n);
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static class HiloRecibirCliente implements Runnable
    {
        Socket socket;

        HiloRecibirCliente(Socket socket)
        {
            this.socket = socket;
        }

        public void run()
        {
            try
            {
                Scanner sc = new Scanner(socket.getInputStream());

                while(true)
                {
                    System.out.println(sc.nextInt());
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        cliente2();
    }
}
