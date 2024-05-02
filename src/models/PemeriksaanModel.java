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
}
