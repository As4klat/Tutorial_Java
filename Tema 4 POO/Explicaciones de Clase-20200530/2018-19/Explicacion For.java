package com.company;

public class Main
{

    public static void main(String[] args)
    {
        // Bucle FOR
        // Un bucle for es básicamente un bucle while pero más compacto

        // Ejemplo: nº 1 al 10

        int i;
        i = 1; // Inicialización
        while(i <= 10) // Comparación
        {
            System.out.println(i);
            i++; // Incremento
        }

        // Versión en for:
        // for( <Inicialización> ; <Comparación> ; <Incremento> )

        for(i = 1; i <= 10; i++)
        {
            System.out.println(i);
        }


    }
}
