package com.company;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.60.130:3306/musica",
                    "usuario", "usuario"
            );

            Statement st = conn.createStatement();
            String sql = "INSERT INTO artistas(nombre) VALUES ('David Bisbal');";
            //st.executeUpdate(sql);

            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            rs.close();

            System.out.println("AUTOINCREMENTO = " + id);

            sql = "SELECT id, nombre FROM artistas;";
            rs = st.executeQuery(sql);
            while(rs.next())
            {
                System.out.println(rs.getInt(1) + "-" +
                        rs.getString(2));
            }
            rs.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
