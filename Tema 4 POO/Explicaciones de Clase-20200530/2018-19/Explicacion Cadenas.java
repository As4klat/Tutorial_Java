package com.company;

public class Main
{
    public static void main(String[] args)
    {
        // Cadenas de caracteres

        String s = "patata";
        //char[] a = {'p', 'a', 't', 'a', 't', 'a'};

        // Concatenación

        String s2 = "hola" + "mundo";
        String s3 = s2 + s;

        // Ver que caracter hay en una posición

        char c = s.charAt(0); // sería equivalente a s[0]

        int i;
        for (i = 0; i < s.length(); i++)
        {
            System.out.println(s.charAt(i));
        }

        // Funciones de cadenas

        // IndexOf
        int pos = s.indexOf('a'); // Devuelve -1 si no está
        // Si aparece varias veces, devuelve la 1ª posición
        System.out.println(pos);

        int pos3 = s.indexOf('a', 2);
        System.out.println(pos3);

        // LastIndexOf
        int pos2 = s.lastIndexOf('a');
        System.out.println(pos2);

        // Buscar todas las veces que aparezca la a con IndexOf
        int pp = s.indexOf('a');

        while (pp != -1)
        {
            System.out.println(pp);
            pp = s.indexOf('a', pp + 1);
        }

        // O con un bucle
        for (i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == 'a')
            {
                System.out.println(i);
            }
        }

        // Replace = sustituye un caracter por otro

        String s4 = s.replace('a', 'o');
        System.out.println(s4);

        String s5 = s.replace("ta", "cha");
        System.out.println(s5);

        // Substring = SubArray
        String s6 = "camaleón";
        String s7 = s6.substring(0, 4);
        //String s8 = s6.substring(4, 8);
        String s8 = s6.substring(4); // desde 4 hasta el final
        System.out.println(s7);
        System.out.println(s8);

        String s9 = "P" + s.substring(1);
        System.out.println(s9);

        String s10 = s.substring(0, 2) + "T" + s.substring(3);
        System.out.println(s10);

        // ToUpperCase y ToLowerCase

        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());

        System.out.println(s.toUpperCase().substring(0, 3)
                + s.toLowerCase().substring(3));

        // Trabajando con cadenas con for y +

        String s11 = "P";

        for (i = 1; i < s.length(); i++)
        {
            s11 = s11 + s.charAt(i);
        }

        System.out.println(s11);

        // ------------------------------------------
        // StringBuilder -> para cuando es muy difícil modificar
        // la cadena, hacemos un chapú

        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(0, 'P');
        String s12 = sb.toString();

        System.out.println(s12);

        sb.reverse();
        String s13 = sb.toString();
        System.out.println(s13);

        // Cosas más interesantes de un StringBuilder

        StringBuilder sb2 = new StringBuilder("chocolate");

        //sb.toString();
        //sb.reverse();
        sb2.insert(0, "león");
        System.out.println(sb2);
        sb2.delete(2, 4); // desde la posición 2 (incluida)
        // hasta la 4 (no incluida)
        System.out.println(sb2);
        sb2.deleteCharAt(sb2.length() - 1);
        System.out.println(sb2);

        // ---------------------------------------
        // Split y Join

        String s20 = "mi mamá me mima";
        String[] trozos = s20.split(" ");

        trozos[1] = "papá";
        String s21 = String.join(" ", trozos);

        System.out.println(s21);

        System.out.println(trozos[0].charAt(1));
    }
}
