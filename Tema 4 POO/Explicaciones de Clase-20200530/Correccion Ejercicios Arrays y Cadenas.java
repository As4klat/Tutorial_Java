package com.company;

public class Main {

    public static void main(String[] args)
    {
//        //Ej. arrays adicionales 13: mejorRacha
//        int[] arrayPartidos = {2, 1, 1, 0, 1, 1, 0, 1, 1, 0, 2, 0, 5, 1, 2, 2, 1, 0, 1, 0, 1, 0, 1, 0};
//
//        int mejor = mejorRacha(arrayPartidos);
//
//        System.out.println(mejor);

//        // Ej. arrays adicionales 16: seriesMundiales
//
//        int[] series = {2, 8, 3, 2, 16, 9, 11, 5};
//        String ganador = seriesMundiales("Boston Red Sox", "Los Angeles Dodgers", series);
//        System.out.println(ganador);

//        // Ej. arrays adicionales 14: numerosPrimosPro
//        numerosPrimosPro(1000);

//        // Ej. arrays adicionales 8: eliminaRepetidos
//        int[] array = {1, 5, 1, 9, 3, 2, 3, 4, 1, 1, 2, 7};
//        int[] array2 = eliminaRepetidos(array);
//        escribeArray(array);
//        escribeArray(array2);

//        // Ej. cadenas adicionales 11: compruebaEmail
//        System.out.println(compruebaEmail("@very-commonexample.com"));

//        pintaCirculo();

//        System.out.println(numeroTexto999(21516));

//        // Ej. cadenas 13: quitaAcentos
//        System.out.println(quitaAcentos1("Águila camión cigüeña"));
//        System.out.println(quitaAcentos2("Águila camión cigüeña"));

//        // Ej. cadenas 18: sustituyePalabra
//
//        System.out.println(sustituyePalabra("mamá mamá    mi mamá me mima", "mamá", "papá"));

//        // Ej. arrays adicionales 6: graficaBarras
//
//        graficaBarras(new int[] {9, 5, 3, 2, 10});

//        // Ej. cadenas 19: inviertePalabras
//
//        System.out.println(inviertePalabras("mi mamá me mima"));
    }

    public static String invierteCadena(String s)
    {
        String s2 = "";
        int i;

        for(i = 0; i < s.length(); i++)
        {
            s2 = s.charAt(i) + s2;
        }

        return s2;
    }

    public static String inviertePalabras(String s)
    {
        String[] trozos = s.split(" ");
        int i;

        for (i = 0; i < trozos.length; i++)
        {
            trozos[i] = invierteCadena(trozos[i]);
        }

        String s2 = String.join(" ", trozos);
        return s2;
    }

    private static void graficaBarras(int[] array)
    {
        boolean bien = true;
        int i, j;
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";

        for(i=0;i<array.length;i++)
        {
            if(array[i] > 10 || array[i] < 0)
            {
                bien = false;
                i = array.length;
            }
        }

        if(bien)
        {
            for(i = 0; i < array.length; i++)
            {
                if(array[i] < 10)
                {
                    System.out.print(" " + array[i] + " ");
                }
                else
                {
                    System.out.print(array[i] + " ");
                }

                if(array[i] >= 5)
                {
                    System.out.print(ANSI_GREEN);
                }
                else
                {
                    System.out.print(ANSI_RED);
                }

                for(j=0;j<array[i];j++)
                {
                    System.out.print("█");
                }
                System.out.print(ANSI_RESET);
                System.out.println();
            }
        }
        else
        {
            System.out.println("Los valores son incorrectos. Deben estar entre 0 y 10.");
        }
    }

    private static String sustituyePalabra(String cadena, String palabra1, String palabra2)
    {
        int i;
        String[] trozos = cadena.split(" ");

        for(i=0;i<trozos.length;i++)
        {
            if(trozos[i].equals(palabra1))
            {
                trozos[i] = palabra2;
            }
        }

        String resultado = String.join(" ", trozos);
        return resultado;
    }

    public static String quitaAcentos1(String s)
    {
        int i;
        String conAcentos = "áéíóúüÁÉÍÓÚÜ";
        String sinAcentos = "aeiouuAEIOUU";

        for(i = 0; i < conAcentos.length(); i++)
        {
            s = s.replace(conAcentos.charAt(i), sinAcentos.charAt(i));
        }

        return s;
    }

    public static String quitaAcentos2(String s)
    {
        int i, pos;
        String s2 = "";
        String conAcentos = "áéíóúüÁÉÍÓÚÜ";
        String sinAcentos = "aeiouuAEIOUU";

        for(i = 0; i < s.length(); i++)
        {
            pos = conAcentos.indexOf(s.charAt(i));

            if(pos == -1)
            {
                s2 = s2 + s.charAt(i);
            }
            else
            {
                s2 = s2 + sinAcentos.charAt(pos);
            }
        }

        return s2;
    }

    public static String numeroTexto999(int n)
    {
        String texto;
        int unidDec = n % 100;
        int centenas = n / 100;
        if(n < 100)
        {
            texto = numeroTexto99(n);
        }
        else
        {
            if(n == 100)
            {
                texto = "cien";
            }
            else
            {
                String[] textoCent = {"", "ciento", "doscientos", "trescientos", "cuatrocientos",
                                      "quinientos", "seiscientos", "setecientos", "ochocientos",
                                      "novecientos"};

                if(unidDec == 0)
                {
                    texto = textoCent[centenas];
                }
                else
                {
                    texto = textoCent[centenas] + " " + numeroTexto99(unidDec);
                }
            }
        }

        return texto;
    }

    public static String numeroTexto99(int n)
    {
        String texto;
        String[] texto10 = {"diez", "once", "doce", "trece", "catorce", "quince", "dieciséis"};
        int unidad = n%10;
        int decena = n/10;

        if(n < 10)
        {
            texto = numeroTexto9(n);
        }
        else
        {
            if(n < 20)
            {
                if(n < 17)
                {
                    texto = texto10[n-10];
                }
                else
                {
                    texto = "dieci" + numeroTexto9(unidad);
                }
            }
            else
            {
                if(n < 30)
                {
                    if(n == 20)
                    {
                        texto = "veinte";
                    }
                    else
                    {
                        if (n == 22)
                        {
                            texto = "veintidós";
                        }
                        else

                        {
                            texto = "veinti" + numeroTexto9(unidad);
                        }
                    }
                }
                else
                {
                    String[] textoDec = {"", "", "", "treinta", "cuarenta", "cincuenta",
                                         "sesenta", "setenta", "ochenta", "noventa"};
                    if(unidad == 0)
                    {
                        texto = textoDec[decena];
                    }
                    else
                    {
                        texto = textoDec[decena] + " y " + numeroTexto9(unidad);
                    }
                }
            }
        }

        return texto;
    }

    public static String numeroTexto9(int n)
    {
        String[] texto = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis",
                          "siete", "ocho", "nueve"};
        return texto[n];
    }
    public static boolean compruebaEmail(String email)
    {
        String[] trozos = email.split("@");
        boolean res;

        if(trozos.length == 2)
        {
            if(compruebaTrozo(trozos[0]) && compruebaTrozo(trozos[1]))
            {
                res = true;
            }
            else
            {
                res = false;
            }
        }
        else
        {
            res = false;
        }

        return res;
    }

    public static boolean compruebaTrozo(String trozo)
    {
        int i;
        boolean res;
        String valido = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-.";

        if(trozo.equals(""))
        {
            res = false;
        }
        else
        {
            res = true;
            for(i = 0; i < trozo.length(); i++)
            {
                if(valido.indexOf(trozo.charAt(i)) == -1) // si no está en "valido"
                {
                    res = false;
                    i = trozo.length(); // optimizando
                }
            }

            if(res == true)
            {
                if(trozo.charAt(0) == '.' || trozo.charAt(trozo.length()-1) == '.' ||
                   trozo.charAt(0) == '-' || trozo.charAt(trozo.length()-1) == '-' ||
                   trozo.contains(".."))
                {
                    res = false;
                }
            }
        }

        return res;
    }

    public static int[] eliminaRepetidos(int[] array)
    {
        int cont, i, j;
        boolean esta;
        int[] array2 = new int[array.length];
        int[] array3;

        cont = 0;
        for (i = 0; i < array.length; i++)
        {
            esta = false;
            for (j = 0; j < i; j++)
            {
                if (array[i] == array[j])
                {
                    esta = true;
                    j = i; // optimizando
                }
            }

            if (!esta)
            {
                array2[cont] = array[i];
                cont++;
            }
        }

        array3 = new int[cont];

        for (i = 0; i < array3.length; i++)
        {
            array3[i] = array2[i];
        }
        return array3;
    }

    public static void escribeArray(int[] array)
    {
        int i;
        System.out.print("[ ");
        for(i=0;i<array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    public static void numerosPrimosPro(int tam)
    {
        int i, j;
        int[] numeros = new int[tam+1];

        for(i = 2; i < numeros.length; i++)
        {
            if(numeros[i] == 0)
            {
                System.out.println(i);

                for(j = i; j < numeros.length; j = j + i)
                {
                    numeros[j] = -1; // no es primo porque es múltiplo
                }
            }
        }
    }

    public static String seriesMundiales(String local, String visitante, int[] series)
    {
        int i, victlocal = 0, victvisit = 0;
        String mensaje;
        boolean error = false;

        if(series.length % 2 == 0)
        {
            for(i = 0; i < series.length; i = i + 2)
            {
                if(series[i+1] > series[i])
                {
                    victlocal++;
                }
                else
                {
                    if(series[i] > series[i+1])
                    {
                        victvisit++;
                    }
                    else
                    {
                        error = true;
                        i = series.length; // opcional
                    }
                }
            }

            if(!error)
            {
                if(victlocal > victvisit)
                {
                    mensaje = local;
                }
                else
                {
                    if (victvisit > victlocal)
                    {
                        mensaje = visitante;
                    }
                    else
                    {
                        mensaje = "Las series mundiales no pueden terminar empatadas.";
                    }
                }
            }
            else
            {
                mensaje = "Un partido no puede acabar en empate.";
            }
        }
        else
        {
            mensaje = "El array de resultados tiene un número impar de elementos.";
        }

        return mensaje;
    }

    public static int mejorRacha(int[] arrayPartidos)
    {
        int i;
        int racha = 0;
        int mejor = 0;

        for(i=0; i < arrayPartidos.length; i = i + 2)
        {
            if(arrayPartidos[i] > arrayPartidos[i+1])
            {
                racha++;
            }
            else
            {
                if(racha > mejor)
                {
                    mejor = racha;
                }
                racha = 0;
            }
        }

        if(racha > mejor)
        {
            mejor = racha;
        }

        return mejor;
    }

    public static void pintaCirculo()
    {
        int tam = 10;
        int i, j;
        double h;
        int asp = 2;

        for (i = -tam; i < tam; i++)
        {
            for (j = -tam * asp; j < tam * asp; j++)
            {
                h = Math.sqrt(i * i + (j / (double) asp * j / (double) asp));
                //h = Math.abs(i) + Math.abs(j/(double)asp);

                if (h >= tam)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}













