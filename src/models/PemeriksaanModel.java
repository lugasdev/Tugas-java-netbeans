package models;

import database.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author PC
 */
public class PemeriksaanModel {

    private Connection conn = new DBConnect().connect();

    public int create(int registrationId, String physical, String diagnosis, String therapy) throws Exception {
        LocalDateTime dateNowObj = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createdAt = dateNowObj.format(dateFormatter);
        int id = 0;

        try {
            String query = "insert into medical_records (registration_id,physical,diagnosis,therapy,created_at) values(?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, String.valueOf(registrationId));
            stmt.setString(2, physical);
            stmt.setString(3, diagnosis);
            stmt.setString(4, therapy);
            stmt.setString(5, createdAt);

            int i = stmt.executeUpdate();

            System.out.println(i + " records inserted");

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception(e);
        }

        return id;
    }
    
    public ResultSet get() throws Exception {
        String query = "select * from medical_records";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            System.out.println("get medical_records done");

            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public boolean update(int id, int registrationId, String physical, String diagnosis, String therapy) throws Exception {
        String query = "UPDATE `medical_records` SET `registration_id` = ?, `physical` = ?, `diagnosis` = ?, `therapy` = ? WHERE `id` = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, registrationId);
            stmt.setString(2, physical);
            stmt.setString(3, diagnosis);
            stmt.setString(4, therapy);
            stmt.setInt(5, id);

            stmt.executeUpdate();

            System.out.println("registration updated");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return true;
    }
    
    public boolean delete(int id) throws Exception {
        try {
            String query = "DELETE from medical_records where id = ?";

            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, id);

            stat.execute();
        } catch (Exception e) {
            throw new Exception(e);
        }
        return true;
    }

}
