package database;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author lugas
 */
public class DBConnect {

    private Connection conn;

    public Connection connect() {
        String url = "";
        String user = "";
        String password = "";
        try {
            String configFilePath = "src/config.properties";
            FileInputStream propsInput = new FileInputStream(configFilePath);
            Properties prop = new Properties();
            prop.load(propsInput);

            System.out.println(prop.getProperty("DB_URL"));
            System.out.println(prop.getProperty("DB_USERNAME"));
            System.out.println(prop.getProperty("DB_PASSWORD"));

            url = prop.getProperty("DB_URL");
            user = prop.getProperty("DB_USERNAME");
            password = prop.getProperty("DB_PASSWORD");
        } catch (Exception e) {
            System.out.println("Properties Failed: " + e);
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println("Gagal " + e);
        }

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("DB connected");
        } catch (Exception e) {
            System.out.println("gagal conn " + e);
        }

        return conn;
    }

}
