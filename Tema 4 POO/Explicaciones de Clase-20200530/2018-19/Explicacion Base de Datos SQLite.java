package com.company;

import java.sql.*;
import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        Connection conn;
        Statement st;
        ResultSet rs;

        try
        {
            // Conectamos a la base de datos
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:ejemplo.db");

            // Ejemplo 1: INSERT
            st = conn.createStatement();
            String sql =
                    "INSERT INTO alumnos(id, nombre, fechaNacimiento) " +
                    "VALUES (3, 'maria', '2011-09-01');";
            //st.executeUpdate(sql);

            // Ejemplo 2: DELETE
            sql = "DELETE FROM alumnos WHERE nombre = 'maria';";
            //st.executeUpdate(sql);

            // Ejemplo 3: SELECT
            sql = "SELECT id, nombre, asignatura FROM profesores;";
            rs = st.executeQuery(sql);

            while(rs.next())
            {
                System.out.print(rs.getInt(1) + " - ");
                System.out.print(rs.getString(2) + " - ");
                System.out.println(rs.getString("asignatura"));
            }

            rs.close();

            // Para escribir BOOLEAN, se guarda un 0 o un 1

            // Ejemplo 4: Fechas

            LocalDate fecha = LocalDate.of(2000, 3, 13);

            String fechastr = fecha.toString() + " 00:00:00.000";

            sql = "INSERT INTO alumnos(id, nombre, fechaNacimiento) " +
                  "VALUES (10, 'juan', '" + fechastr + "');";
            System.out.println(sql);
            //st.executeUpdate(sql);

            // Ejemplo 4b
            sql = "SELECT id, nombre, fechaNacimiento FROM alumnos;";
            rs = st.executeQuery(sql);

            while(rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Date d = rs.getDate("fechaNacimiento");
                LocalDate ld = d.toLocalDate();
                // LocalDate ld2 = rs.getDate(3).toLocalDate();

                System.out.println(id + ":" + nombre + ":" + ld);
            }
            rs.close();

            // Ejemplo 5: INSERT con AUTOINCREMENT
            st = conn.createStatement();
            sql = "INSERT INTO profesores(nombre, asignatura) " +
                  "VALUES ('miguel', 'fol');";
            st.executeUpdate(sql);

            // Ejemplo 5b: obtener valor del AUTOINCREMENT que acabas de insertar
            String sql2 = "SELECT last_insert_rowid();";
            rs = st.executeQuery(sql2);
            rs.next();
            int ultimo_id = rs.getInt(1);
            rs.close();

            System.out.println(ultimo_id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
