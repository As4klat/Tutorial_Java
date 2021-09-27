package com.company;

import java.lang.reflect.Array;

public class Main
{
    public static void main(String[] args)
    {
        // Definición de una variable de tipo array

        int[] arrayEnteros;
        double[] arrayDoubles;
        char[] arrayChars;
        boolean[] arrayBooleanos;

        // Creación/Inicialización de un array vacío

        arrayEnteros = new int[10];
        arrayDoubles = new double[5];
        arrayChars = new char[15];
        arrayBooleanos = new boolean[100];

        // Creando un array con valores

        int[] miArray = {1, 2, 3, 4, 5};
        int[] monedas = {200, 100, 50, 20, 10, 5, 2, 1};

        // Normalmente esto se hace en un solo paso

        int[] a = new int[5];

        // Guardando valores en un array

        a[0] = 10;
        a[1] = 15;
        a[2] = 20;
        a[3] = 25;
        a[4] = 30;

        // Leyendo valores de un array

        //System.out.println(a[4]);
        int valor = a[0];

        // Recorriendo un array con un bucle (for)
        int i;
        for (i = 0; i < 5; i++)
        {
            System.out.println(a[i]);
        }

        System.out.println();

        for(i = 5-1; i >= 0; i--)
        {
            System.out.println(a[i]);
        }

        System.out.println();

        for(i = 0; i < 5; i++)
        {
            if(a[i] % 10 == 0)
            {
                System.out.println(a[i]);
            }
        }

        System.out.println();
        int cont = 0;

        for(i = 0; i < 5; i++)
        {
            if(a[i] % 10 == 0)
            {
                cont++;
            }
        }
        System.out.println("Hay " + cont + " números múltiplos de 10");

        // Funciones con arrays
        ModificaArray2(a);
        EscribeArrayChungo5(a);
    }

    public static void EscribeArrayChungo5(int[] a)
    {
        int i;
        for (i = 0; i < 5; i++)
        {
            System.out.println(a[i]);
        }
    }

    public static void EscribeArrayChungo(int[] a)
    {
        int i;
        for (i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }

    //public static int[] DevuelveArray()

    public static void ModificaArray(int[] a)
    {
        a[0] = -1;
        a[1] = -2;
        a[2] = -3;
        a[3] = -4;
        a[4] = -5;
    }

    public static void ModificaArray2(int[] a)
    {
        int[] b = new int[5];
        b[0] = 99;

        int i;
        for (i = 0; i < 5; i++)
        {
            a[i] = b[i];
        }
    }

}
