package utils;



import domain.Database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection getConnection() {
        try {
            Database database = loadDatabase();
            return DriverManager.getConnection(
                    database.getDatabaseUrl(),
                    database.getUsername(),
                    database.getPassword()
            );
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }

    }

    private static Database loadDatabase() {
        Properties properties = new Properties();
        InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Database(
                properties.getProperty("database_user"),
                properties.getProperty("database_password"),
                properties.getProperty("database_url")
        );
//        return new Database("root", "","jdbc:mysql://localhost:3306/company?useSSL=false");

    }

   /* public static void main(String[] args) {


    }*/
}