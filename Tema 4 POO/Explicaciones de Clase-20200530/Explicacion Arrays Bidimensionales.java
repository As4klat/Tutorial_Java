package com.company;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        // Definición de Array Bidimensional

        int[][] array;

        array = new int[2][3];

        array[0][0] = 5;
        array[0][1] = 7;
        array[0][2] = 9;
        array[1][0] = -5;
        array[1][1] = -7;
        array[1][2] = -9;

        System.out.println(Arrays.toString(array[0]));
        System.out.println(Arrays.toString(array[1]));

        // Recorriendo un array bidimensional
        int i, j;

        for (i = 0; i < 2; i++) // recorremos las filas
        {
            for (j = 0; j < 3; j++) // recorremos las columnas
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Hay " + cuentaPositivos(array) + " positivos");

        // Inicializando el array con valores
        int[][] b = {{1, 2, 3}, {4, 5, 6}}; // dos filas y tres columnas
        int[][] c = {{1, 2}, {3, 4}, {4, 5}}; // tres filas y dos columnas

        int[][] d = {{1, 2, 3}, {4, 5}}; // NO!!!!

        String[][] e = {{"tomate", "pepino"}, {"naranja", "manzana"}};
        System.out.println(Arrays.toString(e[0]));
        System.out.println(Arrays.toString(e[1]));

        // EscribeArray
        // [  5,  7,  9 ]
        // [ -5, -7, -9 ]

        // ┌  5,  7,  9 ┐
        // │ 12,  0, 15 │
        // └ -5, -7, -9 ┘

    }

    public static int cuentaPositivos(int[][] a)
    {
        int cont = 0;
        int i, j;

        for (i = 0; i < a.length; i++) // a.length = número de filas
        {
            for(j = 0; j < a[i].length; j++) // a[x].length = número de columnas
            {
                if(a[i][j] > 0)
                {
                    cont++;
                }
            }
        }

        return cont;
    }
}
