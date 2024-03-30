/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.*;

/**
 *
 * @author lugas
 */
public class DBConnect {
    private Connection conn;
    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println("Gagal " + e);
        }

        String url = "jdbc:mysql://localhost:3306/tugas_poliklinik";
        String user = "root";
        String password = "root";

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("conn OK");
        } catch (Exception e) {
            System.out.println("gagal conn " + e);
        }

        return conn;
    }

}
