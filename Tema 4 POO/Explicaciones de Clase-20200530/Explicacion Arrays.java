package com.company;

public class Main
{
    public static void main(String[] args)
    {
        int[] a; // Definición de la variable del array
        a = new int[5]; // Inicialización del array

        int[] b = new int[5]; // Definición e inicialización

        a[0] = 1; // Guardamos el 1 en la posición 0 del array
        a[1] = 5;
        a[2] = 9;
        a[3] = 2;
        a[4] = 7;

        int[] a2 = {1, 5, 1, 2, 7};
        double[] a3 = {0.5, 1.5, 2.5};
        boolean[] a4 = {true, false, true, false};

        System.out.println(a[0]); // Escribimos por pantalla lo que
                                  // haya en la posición 0 del array
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println(a[3]);
        System.out.println(a[4]);

        int i;

        for(i = 0; i < 5; i++)
        {
            System.out.println(a[i]);
        }

        for(i = 0; i < a.length; i++) // hasta la longitud del array
        {
            System.out.println(a[i]);
        }

        escribeArray(a);

        int[] c = new int[5];
        leeArray(c);
        escribeArray(c);
    }

    public static void escribeArray(int[] a)
    {
        int i;

        for (i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }

    public static void leeArray(int[] a)
    {
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;
    }
}
