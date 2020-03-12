package utils;



import models.Database;

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

        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(input);

            return new Database(
                    properties.getProperty("database_user"),
                    properties.getProperty("database_password"),
                    properties.getProperty("database_url")
            );
        } catch (IOException ex) {
            throw new RuntimeException("Failed to connect to database");
        }
    }

   /* public static void main(String[] args) {


    }*/
}