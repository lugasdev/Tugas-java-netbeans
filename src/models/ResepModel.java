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
public class ResepModel {

    private Connection conn = new DBConnect().connect();

    public int create(int registrationId, String name, String dose, String note, int medicineId) throws Exception {
        LocalDateTime dateNowObj = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createdAt = dateNowObj.format(dateFormatter);
        int id = 0;
        String query = "insert into prescriptions (registration_id, name, dose, note, medicine_id, created_at) values (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, registrationId);
            stmt.setString(2, name);
            stmt.setString(3, dose);
            stmt.setString(4, note);
            stmt.setInt(5, medicineId);
            stmt.setString(6, String.valueOf(createdAt));

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

    public ResultSet getByRegistrationId(int registrationId) throws Exception {
        try {
            String query = "select * from prescriptions where registration_id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, registrationId);

            ResultSet rs = stmt.executeQuery();

            System.out.println(rs.getStatement());

            return rs;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public ResultSet get(int id, int registrationId) throws Exception {
        try {
            String query = "select * from prescriptions where id = ? AND registration_id = ? ";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setInt(2, registrationId);

            ResultSet rs = stmt.executeQuery();

            System.out.println(rs.getStatement());

            return rs;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public boolean update(int id, int registrationId, String name, String dose, String note) throws Exception {
        try {
            String query = "update prescriptions set name = ?, dose = ?, note = ? where id = ? and registration_id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, dose);
            stmt.setString(3, note);
            stmt.setInt(4, id);
            stmt.setInt(5, registrationId);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        }

        return true;
    }

    public boolean delete(int id, int registrationId) throws Exception {
        try {
            String query = "delete from prescriptions where id = ? and registration_id = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setInt(2, registrationId);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception(e);
        }

        return true;
    }
}
