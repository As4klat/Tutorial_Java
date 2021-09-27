package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main
{
    // public static <tipo_que_devuelve> <Nombre> (<parámetros>)
    // parametro = variable con un valor inicial que nos mandan
    //             desde fuera de la función

    public static int Doble(int n)
    {
        int d;
        d = n * 2;
        n++;
        return d;
    }

    public static int Aleatorio1y100()
    {
        Random r = new Random();
        int n = r.nextInt(100) + 1;
        return n;
    }

    public static void HolaMundo()
    {
        System.out.println("Hola");
    }

    public static double truncate(double d)
    {
        double t;

        if(d > 0)
        {
            t = Math.floor(d);
        }
        else
        {
            t = Math.ceil(d);
        }

        return t;
    }

    public static void SumaMalz
    {
        Scanner sc = new Scanner(System.in);
        int a, b, suma;

        a = sc.nextInt();
        b = sc.nextInt();

        suma = a + b;

        System.out.println(suma);
    }

    public static double decimales(double d)
    {
        double entero, deci;

        entero = truncate(d);
        deci = d - entero;

        return deci;
    }

    public static boolean EsAprobado(double nota)
    {
        if(nota >= 5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean EsAprobado2(double nota)
    {
        boolean b;

        if(nota >= 5)
        {
            b = true;
        }
        else
        {
            b = false;
        }
        return b;
    }

    public static void main(String[] args)
    {
        double nota = 4.9;

        if(EsAprobado(nota))
        {
            System.out.println("Felicidades");
        }
        else
        {
            System.out.println("Inútil");
        }
    }
}
