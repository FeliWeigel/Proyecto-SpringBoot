package com.proyectospring.cursojava;

import java.sql.*;
public class MySqlTestMain {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            String myConnectionString =
                    "jdbc:mysql://127.0.0.1:3306?" +
                            "useUnicode=yes&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(myConnectionString, "root", "");
            Statement stmt = conn.createStatement();
            stmt.execute("SHOW DATABASES");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
