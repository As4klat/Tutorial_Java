package com.company;

public class Main
{
    public static void main(String[] args)
    {
        int[][] array1 = new int[3][4];
        int[][] array2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

        array2[0][0] = 6;

        System.out.println(array2[2][3]);

        int i, j;

        for (i = 0; i < 3; i++)
        {
            for (j = 0; j < 4; j++)
            {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }


        for (i = 0; i < array2.length; i++)
        {
            for (j = 0; j < array2[i].length; j++)
            {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }


        // Esto no lo hagáis (pero que sepáis que se puede)
        for (i = 0; i < 3 * 4; i++)
        {
            System.out.println(array2[i / 4][i % 4]);
        }

    }
}

