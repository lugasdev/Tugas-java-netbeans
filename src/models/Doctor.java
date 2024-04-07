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
    
    public boolean update(int id, String name, String clinic, int stat) throws Exception {
        String query = "update doctors set name = ?, clinic = ?, stat = ? where id = ? ";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, clinic);
            stmt.setInt(3, stat);
            stmt.setInt(4, id);
            
            stmt.executeUpdate();            
        } catch (Exception e) {
            throw new Exception(e);
        }
        
        return true;
    }
    
    public boolean delete(int id) throws Exception {
        String query = "delete from doctors where id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);            
            stmt.setInt(1, id);
            
            stmt.execute();
        } catch (Exception e) {
            throw new Exception(e);            
        }
        
        return true;
    }
    
    public ResultSet get() throws Exception {
        String query = "select * from doctors";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            return rs;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    
    public ResultSet get(int id) throws Exception {
        String query = "select * from doctors where id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, String.valueOf(id));
            
            ResultSet rs = stmt.executeQuery();
            
            return rs;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    
    public ResultSet getActiveDoctor() throws Exception {
        String query = "select * from doctors where stat = 1 order by name";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            return rs;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }    
    
    public int getCountActiveDoctor() throws Exception {
        int count = 0;
        String query = "select count(*) as c from doctors where stat = 1";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                count = rs.getInt("c");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        
        return count;
    }
}
