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
 * @author ameng
 */
public class AnamnesaModel {

    private Connection conn = new DBConnect().connect();

    public int create(int registrationId, int height, int weight, String bloodPressure, int temperature, boolean isSmoking, boolean isAlcohol, String history, String complaint) throws Exception {
        LocalDateTime dateNowObj = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateNow = dateNowObj.format(dateFormatter);
        int id = 0;
        String query = "insert into anamnesa (registration_id, height, weight, blood_pressure, temperature, is_smoking, is_alcohol, disease_history, complaint, created_at) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, registrationId);
            stmt.setInt(2, height);
            stmt.setInt(3, weight);
            stmt.setString(4, bloodPressure);
            stmt.setInt(5, temperature);
            if (isSmoking) {
                stmt.setInt(6, 1);
            } else {
                stmt.setInt(6, 0);
            }
            if (isAlcohol) {
                stmt.setInt(7, 1);
            } else {
                stmt.setInt(7, 0);
            }
            stmt.setString(8, history);
            stmt.setString(9, complaint);
            stmt.setString(10, dateNow);

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

    public ResultSet GetByRegistrationId(int registrationId) throws Exception {
        try {
            String query = "select * from anamnesa where registration_id = ? order By id desc";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, registrationId);
            ResultSet rs = stmt.executeQuery();

            return rs;

        } catch (Exception e) {
            System.out.println(e);
            throw new Exception(e);
        }
    }
}
