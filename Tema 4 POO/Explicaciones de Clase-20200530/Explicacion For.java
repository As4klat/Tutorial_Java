package com.company;

public class Main
{
    public static void main(String[] args)
    {
        int i;

        i = 0; // 1= valor inicial al contador
        while(i < 10) // 2= condición
        {
            System.out.println(i); // ... hacemos cosas

            i = i + 1; // 3= incrementar el contador
        }

        for(i = 0; i < 10; i++)
        {
            System.out.println(i);
        }

        for(i = 10; i >= 1; i--)
        {
            System.out.println(i);
        }

        i = i + 1;
        i++;

    }
}
