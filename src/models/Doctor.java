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
public class Doctor {
    private Connection conn = new DBConnect().connect();

    public int create(String name, String clinic, int stat) throws Exception {
        int id = 0; 
        String query = "insert into doctors (`name`, `clinic`, `stat`) values(?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setString(2, clinic);
            stmt.setString(3, String.valueOf(stat));

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
    
    public ResultSet get() throws Exception {
        
        String query = "select * from doctors";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
//            ResultSetMetaData meta = rs.getMetaData();
            
            return rs;
            
//            int count = meta.getColumnCount();
//
//            String[] resData = new String[count];
           
            
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
