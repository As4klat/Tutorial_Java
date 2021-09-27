package com.company;

public class Main
{
    public static void main(String[] args)
    {
        int valor, a, b;
        a = 4;
        b = 5;
        valor = suma2(a, b);
        System.out.println(valor);

        System.out.println(resta2(10, 5));

        System.out.println(restaMayorMenor(15, 5));
        System.out.println(restaMayorMenor(5, 15));

        if(suspenso(4))
        {
            System.out.println("Muy mal, nos vemos el año que viene");
        }

        imprimeNumeros(5);
        holaMundo();
    }

    public static int suma2(int a, int b)
    {
        int n = a + b;
        return n;
    }

    public static int resta2(int a, int b)
    {
        int n = a - b;
        return n;
    }

    public static int restaMayorMenor(int a, int b) // resta el mayor menos el menor
    {
        int n;
        if(a > b)
        {
            n = a - b;
        }
        else
        {
            n = b - a;
        }
        return n;
    }

    public static double euroADolar(double euros)
    {
        double dolares = euros * 1.1116;
        return dolares;
    }

    public static boolean suspenso(double nota)
    {
        boolean resultado;
        if(nota < 5)
        {
            resultado = true;
        }
        else
        {
            resultado = false;
        }
        return resultado;
    }

    public static void imprimeNumeros(int tope)
    {
        int i;
        for (i = 1; i <= tope; i++)
        {
            System.out.println(i);
        }
    }

    public static void holaMundo()
    {
        System.out.println("hola mundo");
    }

//    public static int funcion(int parametro)
//    {
//
//    }
}
