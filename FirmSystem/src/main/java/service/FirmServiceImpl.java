package service;

import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class FirmServiceImpl implements FirmService {

    public HashMap<Integer, String> findAllFirm(){
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        HashMap<Integer, String> firmHashMap = new HashMap<>();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            conn = databaseConnection.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery("Select * from company.firm");
            while(rs.next()){
                firmHashMap.put(Integer.valueOf(rs.getString("firm_id")), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Firms: " + firmHashMap.toString());
        return firmHashMap;
    }

    public void addFirm(String firmName){
        Connection conn = null;
        Statement statement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            conn = databaseConnection.getConnection();
            statement = conn.createStatement();
            String query = "insert into company.firm (name) values ('"+ firmName +"');";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeFirm(String firmName){
        Connection conn = null;
        Statement statement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            conn = databaseConnection.getConnection();
            statement = conn.createStatement();
            String query = "delete from company.firm where name = '"+ firmName +"'";
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
