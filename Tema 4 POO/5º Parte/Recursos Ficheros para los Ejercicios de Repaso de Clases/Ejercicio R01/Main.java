package com.company;

import java.util.Scanner;

enum Plataforma
{
    PC, PlayStation_4, Xbox_One, Switch
}

enum TipoJuego
{
    Accion, Aventura, Puzzle, Rol, Deportes, Estrategia
}

public class Main
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        String opcion = "";
        Coleccion c = new Coleccion();

        while(!opcion.equals("0"))
        {
            System.out.println("Colección de Videojuegos");
            System.out.println("------------------------");
            System.out.println();
            System.out.println("1- Insertar videojuego");
            System.out.println("2- Borrar videojuego");
            System.out.println("3- Listado de la colección");
            System.out.println("0- Salir");
            System.out.println();
            System.out.print("Opción: ");
            opcion = sc.nextLine();
            System.out.println("\n");

            switch (opcion)
            {
                case "1":
                    System.out.println("Escribe el nombre:");
                    String nombre = sc.nextLine();
                    System.out.println("Escribe el año:");
                    int anno = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Elige la plataforma:");
                    Plataforma plat = eligePlataforma();
                    System.out.println("Elige el tipo de juego:");
                    TipoJuego tj = eligeTipoJuego();
                    System.out.println("Escribe la valoración:");
                    int valoracion = sc.nextInt();
                    sc.nextLine();

                    Videojuego v = new Videojuego(nombre, anno, plat, tj, valoracion);
                    c.insertaVideojuego(v);

                    break;
                case "2":
                    System.out.println("Elige el videojuego a borrar");
                    System.out.println(c.toStringNum());
                    System.out.print("Opción: ");
                    int op = sc.nextInt();
                    sc.nextLine();

                    System.out.println(c.getVideojuego(op-1).getNombre() + " eliminado correctamente");
                    c.eliminaVideojuego(op-1);

                    break;
                case "3":
                    System.out.println(c.toString());
                    break;
                case "0":
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
            System.out.println("\n");
        }
    }

    public static Plataforma eligePlataforma()
    {
        Plataforma[] plat = Plataforma.values();
        for(int i = 0; i < plat.length; i++)
        {
            System.out.print(i+1);
            System.out.println("- " + plat[i]);
        }

        System.out.print("Opción: ");
        int op = sc.nextInt();
        sc.nextLine();

        return plat[op-1];
    }

    public static TipoJuego eligeTipoJuego()
    {
        TipoJuego[] tipoj = TipoJuego.values();
        for(int i = 0; i < tipoj.length; i++)
        {
            System.out.print(i+1);
            System.out.println("- " + tipoj[i]);
        }

        System.out.print("Opción: ");
        int op = sc.nextInt();
        sc.nextLine();

        return tipoj[op-1];
    }

}

