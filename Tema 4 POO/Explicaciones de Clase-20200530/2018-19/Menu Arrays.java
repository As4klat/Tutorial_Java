package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("MENÚ");
        System.out.println("1- Ejercicio 1");
        System.out.println("2- Ejercicio 2");
        System.out.println("3- Ejercicio 3");
        System.out.print("Elige una opción: ");

        opcion = sc.nextInt();

        switch (opcion)
        {
            case 1:
            {
                int[] a = {1, 2, 3, 4, 5};
//                escribeArray5(a);
            }
            break;

            case 2:
            {
                int[] a = {1, 2, 3, 4, 5, 6, 7};
//                escribeArray(a);
            }
            break;

            case 3:
                break;
        }

    }
}
