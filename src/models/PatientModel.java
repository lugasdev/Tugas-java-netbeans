/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import database.DBConnect;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lugas
 */
public class PatientModel {

    private Connection conn = new DBConnect().connect();

    public int create(String nik, String name, int gender, String dob, String address, String phone, String bloodType) throws Exception {
        LocalDateTime dateNowObj = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateNow = dateNowObj.format(dateFormatter);
        int id = 0;
        String query = "insert into patients (identity_number, name, gender, date_of_birth, address, phone, blood_type, created_at) values (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nik);
            stmt.setString(2, name);
            stmt.setString(3, String.valueOf(gender));
            stmt.setString(4, dob);
            stmt.setString(5, address);
            stmt.setString(6, phone);
            stmt.setString(7, bloodType);
            stmt.setString(8, dateNow);

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

    public boolean update(int id, String nik, String name, int gender, String dob, String address, String phone, String bloodType) throws Exception {
        String query = "UPDATE `patients` SET `identity_number` = ?, `name` = ?, `gender` = ?, `date_of_birth` = ?, `address` = ?, `phone` = ?, `blood_type` = ? WHERE `id` = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nik);
            stmt.setString(2, name);
            stmt.setString(3, String.valueOf(gender));
            stmt.setString(4, dob);
            stmt.setString(5, address);
            stmt.setString(6, phone);
            stmt.setString(7, bloodType);
            stmt.setInt(8, id);

            stmt.executeUpdate();

            System.out.println("patient updated");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return true;
    }

    public ResultSet get(String filterKey, String filterValue) throws Exception {
        String query = "select * from patients where " + filterKey + " LIKE ?";
        System.out.println(query);
        System.out.println(filterValue);
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + filterValue + "%");
//            stmt.executeQuery();

            System.out.println("get done");

            ResultSet rs = stmt.executeQuery();

            return rs;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public ResultSet get() throws Exception {
        String query = "select * from patients ";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.executeQuery();

            System.out.println("get by id done");

            ResultSet rs = stmt.executeQuery();

            return rs;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public ResultSet get(int id) throws Exception {
        String query = "select * from patients where id = ? limit 1";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            stmt.executeQuery();

            System.out.println("get by id done");

            ResultSet rs = stmt.executeQuery();

            return rs;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public boolean delete(int id) throws Exception {
        try {
            String query = "DELETE from patients where id = ?";

            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, id);

            stat.execute();
        } catch (Exception e) {
            throw new Exception(e);
        }
        return true;
    }
}
