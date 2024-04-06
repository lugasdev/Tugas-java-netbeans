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
    
    public ResultSet getRegistrantByDate(String date) throws Exception {
        try {
            String[] dateSplit = date.split("/");

            String query = "select r.*, d.*, p.* "
                    + "from registrations r "
                    + "join doctors d on d.id = r.doctor_id "
                    + "join patients p on p.id = r.patient_id "
                    + "where YEAR(registration_at) = ? " 
                    + "and MONTH(registration_at) = ? "
                    + "and DAY(registration_at) = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, dateSplit[2]);
            stmt.setString(2, dateSplit[1]);
            stmt.setString(3, dateSplit[0]);
            
            ResultSet rs = stmt.executeQuery();
            
            System.out.println(rs.getStatement());
            
            return rs;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    
    public ResultSet get(int Id) throws Exception {
        try {
            String query = "select * from registrations where id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query, ResultSet.TYPE_FORWARD_ONLY);
            stmt.setInt(1, Id);
            
            ResultSet rs = stmt.executeQuery();
            
            return rs;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    

    
}
