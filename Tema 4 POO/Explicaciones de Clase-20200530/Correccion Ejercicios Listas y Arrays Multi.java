package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicLongArray;

public class Main
{

    public static void main(String[] args)
    {
//        List<Integer> l = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
//        System.out.println(l);
//        desordenaLista(l);
//        System.out.println(l);

//        Integer[] a = {1,2,3,4,5,6};
//        Integer[] a2 = {10,11,12};
//        Integer[] a3 = insertaArrayEnArrayPro(a, 3, a2);
//        System.out.println(Arrays.toString(a3));

//        List<Integer> l = new LinkedList<>(Arrays.asList(1,2,3,4,5,1,2,3,1,2,6,3,3));
//        //System.out.println(modaListaPro(l));
//        System.out.println(l);
//        ordenaRepetidos(l);
//        System.out.println(l);

        int[][] a = new int[8][8];
        rellenaCuadros(a);
    }

    public static Integer[] insertaArrayEnArrayPro(Integer[] a, int pos, Integer[] a2)
    {
        List<Integer> l = new LinkedList<>(Arrays.asList(a));
        l.addAll(pos, Arrays.asList(a2));
        return l.toArray(new Integer[0]);
    }

    public static void eliminaRepetidos(List<Integer> l)
    {
        int i;
        List<Integer> l2 = new ArrayList<>();

        for (i = 0; i < l.size(); i++)
        {
            if (!l2.contains(l.get(i)))
            {
                l2.add(l.get(i));
            }
        }

        l.clear();
        l.addAll(l2);
    }

    public static void desordenaLista(List<Integer> l)
    {
        Random r = new Random();
        List<Integer> l2 = new ArrayList<>();
        int pos;

        while(!l.isEmpty())
        {
            pos = r.nextInt(l.size());
            l2.add(l.get(pos));
            l.remove(pos); // pos es int así que borra la posición
        }

        l.addAll(l2);
    }

    public static int vecesRepiteElemento(List<Integer> l, int elemento)
    {
        int i;
        int cont = 0;

        for (i = 0; i < l.size(); i++)
        {
            if (l.get(i) == elemento)
            {
                cont++;
            }
        }

        return cont;
    }

    public static int modaLista(List<Integer> l)
    {
        int i, veces, maxVeces, elemento;

        maxVeces = 0;
        elemento = 0;
        for(i = 0; i < l.size(); i++)
        {
            veces = vecesRepiteElemento(l, l.get(i));
            if(veces > maxVeces)
            {
                maxVeces = veces;
                elemento = l.get(i);
            }
        }

        return elemento;
    }

    public static int modaListaPro(List<Integer> l)
    {
        List<Integer> lcopia = new LinkedList<>(l);
        Collections.sort(lcopia);

        int i, maxVeces, veces, maxElemento, elemento;
        maxElemento = 0;
        maxVeces = 0;

        i = 0;
        while(i < lcopia.size())
        {
            elemento = lcopia.get(i);
            veces = 0;

            while (i < lcopia.size() && lcopia.get(i) == elemento)
            {
                i++;
                veces++;
            }

            if(veces > maxVeces)
            {
                maxVeces = veces;
                maxElemento = elemento;
            }
        }

        return maxElemento;
    }

    public static void ordenaRepetidos(List<Integer> l)
    {
        int i, moda;
        List<Integer> l2 = new ArrayList<>();

        while (!l.isEmpty())
        {
            moda = modaListaPro(l);

            for (i = 0; i < l.size(); i++)
            {
                if (l.get(i) == moda)
                {
                    l2.add(moda);
                    l.remove(i);
                    i--;
                }
            }
        }

        l.addAll(l2);
    }

    public static void rellenaCuadros(int[][] a)
    {
        int i, j, mitad;

        if(a.length == a[0].length && a.length % 2 == 0)
        {
            mitad = a.length / 2;
            for(i = 0; i < a.length; i++)
            {
                for(j = 0; j < a[i].length; j++)
                {
                    if(i < mitad && j < mitad)
                    {
                        a[i][j] = 1;
                    }
                    else
                    {
                        if(i < mitad && j >= mitad)
                        {
                            a[i][j] = 2;
                        }
                        else
                        {
                            if(i > mitad && j < mitad)
                            {
                                a[i][j] = 3;
                            }
                            else
                            {
                                a[i][j] = 4;
                            }
                        }
                    }
                }
            }


        }
        else
        {
            System.out.println("El array debe ser cuadrado y de dimensiones pares");
        }
    }
}
