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
public class ObatModel {

    private Connection conn = new DBConnect().connect();

    public int create(String name) throws Exception {
        int id = 0;

        try {
            LocalDateTime dateNowObj = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String createdAt = dateNowObj.format(dateFormatter);

            String query = "insert into medicines (name, created_at) values (?, ?);";

            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setString(2, String.valueOf(createdAt));

            int i = stmt.executeUpdate();

            System.out.println(i + " records inserted");

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception(e.getMessage());
        }

        return id;
    }

    public boolean update(int id, String name) throws Exception {
        try {
            String query = "update medicines set name = ? where id = ?";

            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setInt(2, id);

            stmt.executeUpdate();

            System.out.println("patient updated");
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception(e.getMessage());
        }

        return true;
    }

    public ResultSet get() throws Exception {
        try {
            String query = "select * from medicines";

            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            return rs;
        } catch (Exception e) {
            System.out.println("err get");
            throw new Exception(e);
        }
    }

    public ResultSet get(int id) throws Exception {
        try {
            String query = "select * from medicines where id = ? limit 1";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            return rs;
        } catch (Exception e) {
            System.out.println("err get");
            throw new Exception(e);
        }
    }

    public int countObat() throws Exception {
        int count = 0;
        String query = "select count(*) as c from medicines";

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

    public boolean delete(int id) throws Exception {
        try {
            String query = "DELETE from medicines where id = ?";

            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, id);

            stat.execute();
        } catch (Exception e) {
            throw new Exception(e);
        }
        return true;
    }

}
