/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.DBConnect;
import java.sql.*;

/**
 *
 * @author lugas
 */
public class Patient {
    private Connection conn = new DBConnect().connect();
    
    public int create(String nik, String name, int gender, String dob, String address, String phone, String bloodType) throws Exception {
        int id = 0; 
        String query = "insert into patients (identity_number, name, gender, date_of_birth, address, phone, blood_type) values (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nik);
            stmt.setString(2, name);
            stmt.setString(3, String.valueOf(gender));
            stmt.setString(4, dob);
            stmt.setString(5, address);
            stmt.setString(6, phone);
            stmt.setString(7, bloodType);

            int i = stmt.executeUpdate();
            
            System.out.println(i + " records inserted");  
            
            ResultSet rs = stmt.getGeneratedKeys(); 
            if (rs.next()) { 
                id = rs.getInt(1); 
            }             
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
        return id;
    }
}