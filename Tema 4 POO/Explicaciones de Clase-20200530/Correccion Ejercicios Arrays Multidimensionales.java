package com.company;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
//        int[][] cuadrado = {{4,9,2},{3,5,7},{8,1,6}};
//        System.out.println(cuadradoMagico(cuadrado));

        int[][] sudoku =
               {{3,7,1,2,8,9,5,4,6},
                {4,8,6,1,3,5,9,7,2},
                {2,9,5,4,7,6,8,3,1},
                {7,3,2,6,9,8,1,5,4},
                {8,6,9,5,1,4,3,2,7},
                {5,1,4,7,2,3,6,9,8},
                {9,4,3,8,6,7,2,1,5},
                {6,2,7,9,5,1,4,8,3},
                {1,5,8,3,4,2,7,6,9}};

        System.out.println(compruebaSudoku(sudoku));
    }

    private static boolean compruebaSudoku(int[][] sudoku)
    {
        int i, j, x, y;
        List<Integer> lista = new ArrayList<>();
        boolean bien = true;

        // Comprobamos filas
        for(i=0;i<9;i++)
        {
            lista.clear();

            for (j = 0; j < 9; j++)
            {
                lista.add(sudoku[i][j]);
            }

            if (!compruebaLista19(lista))
            {
                bien = false;
                i = 9;
            }
        }

        if(bien)
        {
            // Comprobamos columnas
            for (j = 0; j < 9; j++)
            {
                lista.clear();

                for (i = 0; i < 9; i++)
                {
                    lista.add(sudoku[i][j]);
                }

                if (!compruebaLista19(lista))
                {
                    bien = false;
                    j = 9;
                }
            }

            if (bien)
            {
                // Comprobamos cuadrados
                for (x = 0; x < 9; x = x + 3)
                {
                    for (y = 0; y < 9; y = y + 3)
                    {
                        lista.clear();

                        for (i = x; i < x + 3; i++)
                        {
                            for (j = y; j < y + 3; j++)
                            {
                                lista.add(sudoku[i][j]);
                            }
                        }

                        if (!compruebaLista19(lista))
                        {
                            bien = false;
                            x = 9;
                            y = 9;
                        }
                    }
                }

            }
        }

        return bien;
    }

    private static boolean compruebaLista19(List<Integer> lista)
    {
        if(lista.size() == 9)
        {
            int i;
            boolean bien = true;
            Collections.sort(lista);

            for (i = 0; i < lista.size(); i++)
            {
                if (lista.get(i) != i + 1)
                {
                    bien = false;
                    i = lista.size();
                }
            }

            return bien;
        }
        else
        {
            return false;
        }
    }

    private static boolean cuadradoMagico(int[][] cuadrado)
    {
        int i, j;
        int[] sumas = new int[8];
        boolean iguales;

        for(i = 0; i < 3; i++)
        {
            for(j = 0; j < 3; j++)
            {
                sumas[j] = sumas[j] + cuadrado[j][i];
                sumas[i+3] = sumas[i+3] + cuadrado[j][i];

                if(i == j)
                {
                    sumas[6] = sumas[6] + cuadrado[i][j];
                }

                if(i+j == 2)
                {
                    sumas[7] = sumas[7] + cuadrado[i][j];
                }
            }
        }

        iguales = true;

        for(i = 0; i < sumas.length - 1; i++)
        {
            if(sumas[i] != sumas[i + 1])
            {
                iguales = false;
                i = sumas.length;
            }
        }

        return iguales;
    }
}


