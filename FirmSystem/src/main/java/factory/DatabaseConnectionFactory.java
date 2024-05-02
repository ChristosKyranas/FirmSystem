package factory;

import utils.DatabaseConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionFactory {

    public static Connection getConnection() {
        try {
            DatabaseConfiguration database = loadDatabaseConfiguration();
            return DriverManager.getConnection(
                    database.getDatabaseUrl(),
                    database.getUsername(),
                    database.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }

    }

    private static DatabaseConfiguration loadDatabaseConfiguration() {
        Properties properties = new Properties();
        InputStream input = DatabaseConnectionFactory.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(input);

            return new DatabaseConfiguration(
                    properties.getProperty("database_user"),
                    properties.getProperty("database_password"),
                    properties.getProperty("database_url")
            );
        } catch (IOException e) {
//            e.printStackTrace();
            throw new RuntimeException("Failed to connect to database");
        }


//        return new Database("root", "","jdbc:mysql://localhost:3306/company?useSSL=false");

    }

   /* public static void main(String[] args) {


    }*/
}