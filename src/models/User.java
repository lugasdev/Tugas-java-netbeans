/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lugas
 */
public class User {
    private Connection conn = new DBConnect().connect();
    private utils.MD5 md5 = new utils.MD5();
    
    public boolean login(String username, String password) throws Exception {
        String errMessage = "";
        String query = "select * from users where username = ? and password = ?";        
        try {
            String passwordHashing = md5.getMD5(password);
            
            System.out.println(passwordHashing);
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, passwordHashing);
            ResultSet rs = stmt.executeQuery();
            
            if (!rs.next()) {
                errMessage = "User tidak ditemukan";
            }                

        } catch (SQLException e) {
            System.out.println("mysql error: ");
            System.out.println(e);
            
            errMessage = "Mysql Connection Failed: " + e;
        } finally {
//            try {
//                if (conn != null) {
//                    System.out.println("Connection closed");
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                System.out.println(e);
//            }            
        }
        

        if (errMessage != "") {
            throw new Exception(errMessage);
        }
        
        return true;
    }
}
