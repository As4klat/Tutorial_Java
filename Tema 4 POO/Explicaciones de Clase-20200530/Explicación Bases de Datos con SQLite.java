package com.company;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main
{
    public static void main(String[] args)
    {
        String connString = "jdbc:sqlite:D:\\cine.db";

        Connection conn;
        try
        {
            conn = DriverManager.getConnection(connString);

            //LocalDate.parse("2018-09-30", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            Statement st = conn.createStatement();

            // Para consultas SQL que no devuelven datos
            String sql =
                    "INSERT INTO actores (nombre, fechaNacimiento) VALUES " +
                    "('Arnold Schwarzenegger', '1947-07-30');";
            st.execute(sql);

            String sqlid = "SELECT last_insert_rowid()";
            ResultSet rsid = st.executeQuery(sqlid);
            rsid.next();
            int idInsertado = rsid.getInt(1);
            System.out.println("ID de Arnold = " + idInsertado);

            // Para consultas SQL que devuelven datos (SELECT)

            String sql2 = "SELECT * FROM actores;";
            // Para leer primero sacamos un ResultSet
            ResultSet rs = st.executeQuery(sql2);

            // Cada vez que ponemos rs.next() se lee un registro nuevo
            //rs.next();

            while(rs.next())
            {
                // De cada registro podemos ir leyendo los campos
                // int id = rs.getInt(1); // número de columna (empieza en 1)
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                LocalDate fecha = LocalDate.parse(rs.getString("fechaNacimiento"));

                System.out.println("id = " + id + ", nombre = " + nombre + ", fecha = " +
                        fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}

