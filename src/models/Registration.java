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
public class Registration {
    private Connection conn = new DBConnect().connect();

    public int create(int doctorId, int patientId, String registrationAt) throws Exception {
        int id = 0; 
        String query = "insert into registrations (doctor_id, registration_at, patient_id) values (?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, String.valueOf(doctorId));
            stmt.setString(2, registrationAt);
            stmt.setString(3, String.valueOf(patientId));

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
