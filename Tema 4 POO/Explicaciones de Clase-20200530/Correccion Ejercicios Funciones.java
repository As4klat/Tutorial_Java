package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
//        int i, n;
//
//        n = leeNatural();
//
//        for (i = 1; i <= n; i++)
//        {
//            System.out.println(i);
//        }

        //System.out.println(diaSemanaFecha(5, 11, 2019));

//        escribeHoraBonita(3, 14, 9);
//        escribeSegundosBonito(86399);

        //calderilla2(4.96);

        romboRec(4);

        //calendarioGrafico(9, 2019);

        //cuadradoEstrellitas(1);

        //romboide(5, 15);

        //factoresPrimos(999);
    }

    public static int leeNatural()
    {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("Escribe un número natural");
        n = sc.nextInt();

        while(n <= 0)
        {
            System.out.println("Error, el número tiene que ser natural. Escríbelo de nuevo");
            n = sc.nextInt();
        }

        return n;
    }

    public static int diasMes(int mes)
    {
        int n;
        switch (mes)
        {
            case 1: n = 31; break;
            case 2: n = 28; break;
            case 3: n = 31; break;
            case 4: n = 30; break;
            case 5: n = 31; break;
            case 6: n = 30; break;
            case 7: n = 31; break;
            case 8: n = 31; break;
            case 9: n = 30; break;
            case 10: n = 31; break;
            case 11: n = 30; break;
            case 12: n = 31; break;
            default: n = 0; break;
        }
//        switch (mes)
//        {
//            case 1:
//            case 3:
//            case 5:
//            case 7:
//            case 8:
//            case 10:
//            case 12: n = 31; break;
//            case 2: n = 28; break;
//            case 4:
//            case 6:
//            case 9:
//            case 11: n = 30; break;
//            default: n = 0; break;
//        }
        return n;
    }

    public static boolean bisiesto(int anno)
    {
        if(anno % 4 == 0 && anno != 100 || anno % 400 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int diasMes2(int mes, int anno)
    {
        int n;
        if(bisiesto(anno) && mes == 2)
        {
            n = 29;
        }
        else
        {
            n = diasMes(mes);
        }
        return n;
    }

    public static int diasTranscurridos(int dia, int mes, int anno)
    {
        int i, suma;
        suma = 0;

        for(i = 1; i < mes; i++)
        {
            suma = suma + diasMes2(i, anno);
        }

        suma = suma + dia;
        return suma;
    }

    public static int diasTranscurridos1980(int dia, int mes, int anno)
    {
        int suma, i;
        suma = 0;

        for(i = 1980; i < anno; i++)
        {
            if(bisiesto(i))
            {
                suma = suma + 366;
            }
            else
            {
                suma = suma + 365;
            }
        }
        suma = suma + diasTranscurridos(dia, mes, anno);

        return suma;
    }

    public static int diasEntreFechas(int dia1, int mes1, int anno1, int dia2, int mes2, int anno2)
    {
        int diasTotal1, diasTotal2, diferencia;

        diasTotal1 = diasTranscurridos1980(dia1, mes1, anno1);
        diasTotal2 = diasTranscurridos1980(dia2, mes2, anno2);

        diferencia = diasTotal2 - diasTotal1;
        return diferencia;

        // return diasTranscurridos1980(dia2, mes2, anno2) - diasTranscurridos1980(dia1, mes1, anno1);
    }

    public static int diaSemanaFecha(int dia, int mes, int anno)
    {
        int i, diaSemana, diasTotales;

        diasTotales = diasTranscurridos1980(dia, mes, anno);
        diasTotales = diasTotales - 1;
        diasTotales = diasTotales % 7; // obviamos las semanas completas
        diaSemana = 2;

        for(i = 0; i < diasTotales; i++)
        {
            diaSemana = diaSemana + 1;

            if(diaSemana == 8)
            {
                diaSemana = 1;
            }
        }

        return diaSemana;
    }

    public static void escribeHoraBonita(int hora, int minuto, int segundo)
    {
        if(minuto < 60 && segundo < 60 && hora >= 0 && minuto >= 0 && segundo >= 0)
        {
            System.out.print(hora + ":");

            if (minuto < 10)
            {
                System.out.print("0");
            }

            System.out.print(minuto + ":");

            if (segundo < 10)
            {
                System.out.print("0");
            }

            System.out.println(segundo);
        }
        else
        {
            System.out.println("Hora errónea");
        }
    }

    public static void escribeSegundosBonito(int segundosTotales)
    {
        int hora, minuto, segundo, minutosTotales;

        minutosTotales = segundosTotales / 60;
        segundo = segundosTotales % 60;

        hora = minutosTotales / 60;
        minuto = minutosTotales % 60;

        escribeHoraBonita(hora, minuto, segundo);
    }

    public static void calderilla(double dinero)
    {
        if(dinero <= 5)
        {
            while(dinero >= 2.0)
            {
                System.out.println("2€");
                dinero = dinero - 2.0;
            }

            while(dinero >= 1.0)
            {
                System.out.println("1€");
                dinero = dinero - 1.0;
            }

            while(dinero >= 0.50)
            {
                System.out.println("50cent");
                dinero = dinero - 0.50;
            }

            while(dinero >= 0.20)
            {
                System.out.println("20cent");
                dinero = dinero - 0.20;
            }

            while(dinero >= 0.10)
            {
                System.out.println("10cent");
                dinero = dinero - 0.10;
            }

            while(dinero >= 0.05)
            {
                System.out.println("5cent");
                dinero = dinero - 0.05;
            }

            while(dinero >= 0.02)
            {
                System.out.println("2cent");
                dinero = dinero - 0.02;
            }

            while(dinero >= 0.01)
            {
                System.out.println("1cent");
                dinero = dinero - 0.01;
            }

        }
        else
        {
            System.out.println("Cantidad demasiado grande");
        }
    }

    public static void calderilla2(double dinero)
    {
        int centimos, monedas;

        centimos = (int) Math.round(dinero * 100);

        monedas = centimos / 200;
        System.out.println(monedas + " de 2€");
        centimos = centimos % 200;

        monedas = centimos / 100;
        System.out.println(monedas + " de 1€");
        centimos = centimos % 100;

        monedas = centimos / 50;
        System.out.println(monedas + " de 50cent");
        centimos = centimos % 50;

        monedas = centimos / 20;
        System.out.println(monedas + " de 20cent");
        centimos = centimos % 20;

        monedas = centimos / 10;
        System.out.println(monedas + " de 10cent");
        centimos = centimos % 10;

        monedas = centimos / 5;
        System.out.println(monedas + " de 5cent");
        centimos = centimos % 5;

        monedas = centimos / 2;
        System.out.println(monedas + " de 2cent");
        centimos = centimos % 2;

        System.out.println(centimos + " de 1cent");
    }

    public static void trianguloEstrellitas(int tam)
    {
        int nivel, i;

        if(tam >= 3 && tam <= 20)
        {
            for (nivel = 1; nivel <= tam; nivel++)
            {
                for (i = 1; i <= nivel; i++)
                {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        else
        {
            System.out.println("ERROR");
        }
    }

    public static void repiteEstrella(int n)
    {
        int i;
        for(i = 0; i < n; i++)
        {
            System.out.print("*");
        }
    }

    public static void repiteEspacio(int n)
    {
        int i;
        for(i = 0; i < n; i++)
        {
            System.out.print(" ");
        }
    }

    public static void trianguloEstrellitas2(int tam)
    {
        int nivel, i;

        if(tam >= 3 && tam <= 20)
        {
            for (nivel = 1; nivel <= tam; nivel++)
            {
                repiteEstrella(nivel);
                System.out.println();
            }
        }
        else
        {
            System.out.println("ERROR");
        }
    }

    public static void rombo(int tam)
    {
        int nivel;

        for(nivel = 1; nivel < tam; nivel++)
        {
            repiteEspacio(tam - nivel);
            repiteEstrella(nivel * 2);
            System.out.println();
        }

        for(nivel = tam; nivel >= 1; nivel--)
        {
            repiteEspacio(tam - nivel);
            repiteEstrella(nivel * 2);
            System.out.println();
        }
    }

    public static void calendarioGrafico(int mes, int anno)
    {
        int diaSemana, diasMes, i;

        diaSemana = diaSemanaFecha(1, mes, anno);
        diasMes = diasMes2(mes, anno);

        System.out.println(" L   M   X   J   V   S   D");

        for(i = 1; i < diaSemana; i++)
        {
            System.out.print("    ");
        }

        for(i = 1; i <= diasMes; i++)
        {
            if(i < 10)
            {
                System.out.print(" ");
            }
            System.out.print(i + "  ");
            diaSemana++;

            if(diaSemana == 8)
            {
                diaSemana = 1;
                System.out.println();
            }
        }
    }

    public static void cuadradoEstrellitas(int tam)
    {
        int i;

        if (tam == 1)
        {
            System.out.println("*");
        }
        else
        {
            repiteEstrella(tam);
            System.out.println();

            for (i = 2; i <= tam - 1; i++)
            {
                repiteEstrella(1);
                repiteEspacio(tam - 2);
                repiteEstrella(1);
                System.out.println();
            }

            repiteEstrella(tam);
            System.out.println();
        }
    }

    static int maximo(int a, int b)
    {
        if(a>b)
        {
            return a;
        }
        else
        {
            return b;
        }
    }

    static int maximo(int a, int b, int c)
    {
        return maximo(maximo(a, b), c);
    }

    static void romboide(int altura, int largo)
    {
        int i;

        for (i = 1; i <= altura; i++)
        {
            repiteEspacio(altura - i);
            repiteEstrella(largo);
            System.out.println();
        }
    }

    static void factoresPrimos(int n)
    {
        int resto, factor;

        resto = n;
        factor = 2;

        System.out.print(n + " = ");

        while(resto > 1)
        {
            if(resto % factor == 0)
            {
                resto = resto / factor;
                if(resto == 1)
                {
                    System.out.print(factor);
                }
                else
                {
                    System.out.print(factor + " x ");
                }
            }
            else
            {
                factor++;
            }
        }
        System.out.println();
    }

    public static void repiteEstrellaRec(int n)
    {
        if(n > 0)
        {
            System.out.print("*");
            repiteEstrellaRec(n - 1);
        }
    }

    public static void repiteEspacioRec(int n)
    {
        if(n > 0)
        {
            System.out.print(" ");
            repiteEspacioRec(n - 1);
        }
    }

    public static void romboRec(int tam)
    {
        int nivel, direccion;

        nivel = 1;
        direccion = 1;

        while(nivel > 0)
        {
            repiteEspacio(tam - nivel);
            repiteEstrella(nivel * 2);
            System.out.println();

            nivel = nivel + direccion;
            if(nivel == tam)
            {
                direccion = -1;
            }
        }
    }
}
