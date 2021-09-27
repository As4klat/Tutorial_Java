package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main
{
    public static void main(String[] args)
    {
        // Para ver si un fichero existe

        // Método antiguo: File
        // File nos permite obtener información sobre el fichero que le digamos
        // El fichero no tiene ni siquiera por qué existir
        File fich = new File("C:\\UkLog.dat");
        if(fich.exists())
        {
            if(fich.isFile())
            {
                System.out.println("El fichero existe");
            }
            else
            {
                if(fich.isDirectory())
                {
                    System.out.println("Es un directorio realmente");
                }
            }
        }
        else
        {
            System.out.println("El fichero no existe");
        }

        // Método moderno: Files
        if(Files.exists(Path.of("fichero.txt")))
        {
            if(Files.isRegularFile(Path.of("fichero.txt")))
            {
                System.out.println("Método nuevo: EXISTE");
            }
            else
            {
                if(Files.isDirectory(Path.of("fichero.txt")))
                {
                    System.out.println("Método nuevo: DIRECTORIO");
                }
            }
        }

        // Operaciones con ficheros: borrar, copiar, mover/renombrar
        // Versión antigua
        fich.delete();
        File fich2 = new File("fichero2.txt");
        fich.renameTo(fich2);

        // Versión moderna
        try
        {
            Files.delete(Path.of("fichero.txt"));
            Files.copy(Path.of("fichero.txt"), Path.of("C:\\fichero2.txt"));
            Files.move(Path.of("fichero.txt"), Path.of("fichero2.txt"));

            Files.createDirectories(Path.of("carpeta"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


        // Obtener el listado de un directorio
        File dir = new File("."); // "." = directorio actual
        File[] arrayFicheros = dir.listFiles();
        int i;

        for(i = 0; i < arrayFicheros.length; i++)
        {
            if(arrayFicheros[i].isFile())
            {
                if(arrayFicheros[i].getName().endsWith(".txt"))
                {
                    System.out.println(arrayFicheros[i].getName());
                    //System.out.println(arrayFicheros[i].getAbsolutePath());
                }
            }
        }

    }
}
