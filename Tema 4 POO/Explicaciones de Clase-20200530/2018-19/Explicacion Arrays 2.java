package com.company;

public class Main
{
    public static int[] Resta1(int[] a)
    {
        int[] b = new int[a.length]; // Creamos b con el tamaño de a
        int i;

        for (i = 0; i < a.length; i++)
        {
            b[i] = a[i];
        }

        for (i = 0; i < b.length; i++)
        {
            b[i] = b[i] - 1;
        }

        return b;
    }

    public static void main(String[] args)
    {
        int[] a = {1, 2, 3, 4, 5};
        int[] b;

        b = Resta1(a);
    }
}
