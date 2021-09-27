package com.company;

import java.io.CharArrayReader;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        char c = 'a';

        String s = "hola";
        String s1 = "a";
        String s0 = "";

        // Como copiar una cadena

        String scopia = s;
        s = "patata";

        // Operaciones con cadenas

        String s2 = "hola" + "adiós";
        s2 = "el resultado es " + 5;
        s2 = "cadena" + 'a' + "cadena";

        String s3 = "hola";
        s3 = s3 + "adiós";

        // Para recorrer una cadena con un for

        String s4 = "patata";
        int i;

        for(i = 0; i < s4.length(); i++)
        {
            System.out.println(s4.charAt(i)); // lo mismo que s4[i]
        }

        // Contar el número de 'a' que aparecen en la cadena
        int cont = 0;
        for(i = 0; i < s4.length(); i++)
        {
            if(s4.charAt(i) == 'a')
            {
                cont++;
            }
        }

        // Quitar la letra a de una cadena
        String s5 = "";
        for(i = 0; i < s4.length(); i++)
        {
            if(s4.charAt(i) != 'a')
            {
                s5 = s5 + s4.charAt(i);
            }
        }
        System.out.println(s5);

        // Cómo se lee una cadena del teclado
        Scanner sc = new Scanner(System.in);
        //String s6 = sc.nextLine();
        //s6 = sc.next(); // Sólo lee hasta el siguiente separador

        //int n = sc.nextInt();
        //sc.nextLine(); // Para limpiar el buffer antes de leer
                       // una cadena

        // Funciones de cadenas
        String s7 = "patata";

        // equals = comparar cadenas
        // if(s5 == s7) // esto no funciona
        if(s5.equals(s7)) // esto ok
        {
            System.out.println("Son iguales");
        }

        //s7.compareTo() // Compara dos cadenas alfabéticamente
        // Devuelve 0 si son iguales
        // Devuelve <0 si la primera es más pequeña y >0 al contrario

        // Búsqueda dentro de la cadena
        //s7.contains() // nos dice si la cadena contiene algo
        if(s7.contains("a"))
        {
        }

        // s7.indexOf('a') // nos dice la posición de algo
        // devuelve -1 si no está

        int pos = s7.indexOf('a');
        int pos2 = s7.indexOf('a', pos+1);

        int posn = s7.lastIndexOf('a');

        // Para ver si una cadena está vacía
        if(s7.isEmpty())
        {
        }

        // Para ver si una cadena empieza por o acaba por
        if(s7.startsWith("<html>"))
        {
        }

        if(s7.endsWith(".exe"))
        {
        }

        // Para convertir una cadena a mayúsculas o minúsculas
        s7 = "Patata";
        System.out.println(s7.toUpperCase());
        System.out.println(s7.toLowerCase());

        char c1 = 'a';
        char cMay = Character.toUpperCase(c1);
        char cMin = Character.toLowerCase(c1);

        // Funciones de caracteres para ver qué tipo de caracter es
        if(Character.isLetter(c1))
        { }

        if(Character.isDigit(c1))
        { }

        if(Character.isUpperCase(c1))
        { }

        if(Character.isLowerCase(c1))
        { }

        // Una función muy chula que no quiero que uséis = replace
        String s8 = "hola    adiós  goodbye";
        s8 = s8.replace("  ", " ");
        s8 = s8.replace('a', 'u');

        System.out.println(s8);

        // Trim = Quita espacios de delante y detrás
        String s9 = "    hola y adiós  ";
        s9 = s9.trim();

        System.out.println(">"+s9+"<");

        // Convertir cadena en array y viceversa
        // Tampoco quiero que lo uséis
        String s10 = "hola qué tal";
        char[] array = s10.toCharArray(); // cadena a array
        array[0] = 'H';
        s10 = new String(array); // array a cadena
        System.out.println(s10);

        // SubString - recorta una subcadena
        String s11 = "hola qué tal";
        String s12 = s11.substring(0, 4); // la última no incluida
        System.out.println(s12);
        //String s13 = s11.substring(9, s11.length());
        String s13 = s11.substring(9); // desde 9 hasta el final
        System.out.println(s13);

        // Cambiar la q por una Q
        String s14 = s11.substring(0,5)+"Q"+s11.substring(6);
        System.out.println(s14);

        // Split y Join = trocear una cadena y pegarla de nuevo
        String s15 = "hola qué tal";
        String[] palabras = s15.split(" ");

        // Escribo la primera letra de la última palabra
        System.out.println(palabras[2].charAt(0));
        String ultimaPalabra = palabras[2];
        char primeraLetra = ultimaPalabra.charAt(0);

        // Cambio qué por QUÉ
        palabras[1] = "QUÉ";

        // Recomponemos la cadena
        String s16 = String.join(" ", palabras);

        System.out.println(s16);


        String s17 = quitaEspacios(s16);
    }

    public static String quitaEspacios(String s)
    {
        return s.replace(" ", "");
    }
}
