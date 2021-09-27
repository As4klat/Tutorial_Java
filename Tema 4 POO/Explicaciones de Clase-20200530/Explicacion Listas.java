package com.company;


import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        // Definición de variable
        List<Integer> li; // Integer es parecido a int (no me deja usar el int)

        // Creamos la lista
        li = new ArrayList<>(); // más rápida para recorrer la lista (con un for)
        li = new LinkedList<>(); // más rápida para añadir o insertar elementos

        // Añadir elementos a una lista

        li.add(1);
        li.add(2);
        li.add(3);

        int i;
        for(i = 4; i <= 6; i++)
        {
            li.add(i);
        }

        // Sumarle uno a cada posición

        int valor;
        for(i = 0; i < li.size(); i++)
        {
            valor = li.get(i); // Leer un valor de una posición i -> valor = li[i]
            li.set(i, valor + 1); // Modifica el valor de la posición i -> li[i] = valor + 1

            //li.set(i, li.get(i) + 1); // de una sola vez -> l[i]++;
        }

        //escribeBorraLista(li);
        System.out.println(li.size());

        // Más funciones de listas
        // INSERTAR
        li.add(5); // Añade un elemento al final
        li.add(0, 5); // Añade un elemento al principio
        li.add(3, 5); // Añade el 5 en la posición 3
                          // Peta si la posición no existe

        // BORRAR POR POSICION
        li.remove(0); // Borra el primer elemento, peta si no hay nada
        li.remove(li.size()-1); // Borra el último elemento, peta si no hay nada

        // BORRAR POR ELEMENTO
        Integer ele = 5;
        li.remove(ele); // Borra el elemento '5' (si hay más de uno, quita el primero).
                        // Además, devuelve true si está y false si no.

        li.remove(Integer.valueOf(ele)); // otra manera

        // CONTAINS
        //li.contains(); // igual que el de cadenas

        // INDEXOF
        //li.indexOf(5); // igual que el de cadenas

        // SUBLIST
        //li.subList(3, 6); // como SubString

        // Añadir muchos datos a una lista.
        List<Integer> l2 = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> l3 = new LinkedList<>(Arrays.asList(11, 12, 13));

        // ADDALL -> añade una lista (o un array) en otra
        l2.addAll(l3);
        System.out.println(l2);

        Integer[] array = {99,98,97};
        l2.addAll(Arrays.asList(array));
        System.out.println(l2);

        // CLEAR
        //li.clear(); // deja vacía la lista

        // ISEMPTY
        //while(!li.isEmpty()) // yo normalmente uso (li.size() > 0)

        // RESTO DE FUNCIONES CHULAS ESTÁN EN COLLECTIONS
        System.out.println("min = " + Collections.min(l2));
        System.out.println("max = " + Collections.max(l2));
        Collections.reverse(l2);
        System.out.println("al reves = " + l2);
        Collections.sort(l2);
        System.out.println("ordenada = " + l2);
        Collections.shuffle(l2);
        System.out.println("desordenada = " + l2);
    }

    private static void escribeBorraLista(List<Integer> li)
    {
        // Escribir todos los elementos de una lista e irlos borrando
        while(li.size() > 0)
        {
            System.out.println(li.get(0));
            li.remove(0);
        }
    }
}
