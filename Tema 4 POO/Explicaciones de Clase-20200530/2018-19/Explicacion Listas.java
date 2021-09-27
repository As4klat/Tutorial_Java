package com.company;

import java.text.CollationElementIterator;
import java.util.*;
import java.util.concurrent.BlockingQueue;

public class Main
{
    public static void main(String[] args)
    {
        // Tipos de listas
        List<Integer> li;
        List<Double> ld;
        List<Character> lc;
        List<Boolean> lb;
        List<String> ls;

        // Implementaciones de listas
        //li = new ArrayList<>();
        li = new LinkedList<>();

        // Añadir el elemento al final de la lista
        li.add(5);
        li.add(9);
        li.add(15);

        System.out.println(li);

        // Añadir el elemento en la posición 0
        li.add(0, 1);
        li.add(2, 99);
        System.out.println(li);

        // Acceder a un elemento: get
        int i;
        for (i = 0; i < li.size(); i++)
        {
            System.out.println(li.get(i));  // li[i]
        }

        // Modificar un elemento existente
        // Cambiamos el elemento[0] al valor -1
        li.set(0, -1); // li[i] = -1
        System.out.println(li);

        // Borramos los elementos de la lista
        li.clear();
        System.out.println(li);

        // Contains
        li.add(15);
        if(li.contains(15))
        {
            System.out.println("Hay un 15");
        }

        // IndexOf (si no está devuelve -1)
        int pos = li.indexOf(16);
        System.out.println(pos);

        // Te crea una sublista
        List<Integer> li2 = new LinkedList<>(Arrays.asList(4,5,7,8,9,10));

        li = li2.subList(1,3);

        System.out.println(li);

        // Eliminar un elemento de la lista
        ls = new LinkedList<>(Arrays.asList("patata","tomate","pimiento","cebolla"));

        ls.remove("tomate");
        System.out.println(ls);

        ls.remove(2);
        System.out.println(ls);

        li = new LinkedList<>(Arrays.asList(5,4,3,2,1));

        li.remove(1);
        System.out.println(li);
        li.remove(Integer.valueOf(1));
        System.out.println(li);

        // Añadir una lista (o array u otras cosas) dentro de otra lista
        li2 = new LinkedList<>(Arrays.asList(10,11,12));
        li.addAll(0, li2);
        System.out.println(li);

        Integer[] ai = {99,98,97};
        li.addAll(Arrays.asList(ai));
        System.out.println(li);

        // Convertir una lista en un array
        //Integer[] ai2 = (Integer[])li.toArray();

        // Castings = Conversión de tipos
        //Integer.valueOf()
        //String.valueOf()
        //char c = '0';
        //int i2 = (int)c;
        // En i2 no guarda un 0 sino un 48 (valor ASCII del 0)

        // Otras funciones para Listas
        int minimo = Collections.min(li);
        System.out.println(minimo);

        Collections.max(li);

        Collections.sort(li);
        System.out.println(li);

        Collections.reverse(li);
        System.out.println(li);

        Collections.shuffle(li);
        System.out.println(li);

        // Pilas y Colas
        Stack<Integer> pila = new Stack<>();
        pila.push(10);
        pila.push(11);
        pila.push(12);
        System.out.println(pila.pop());

        Queue<Integer> cola = new LinkedList<>();

    }
}
