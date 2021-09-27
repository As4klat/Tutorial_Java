package com.company;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        LocalDate d = LocalDate.of(2018,11,20);
        LocalDate d2 = LocalDate.now();

        System.out.println(d);
        System.out.println(d2);

        d = d.plusDays(11);

        System.out.println(d);

    }
}
