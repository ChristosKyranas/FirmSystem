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
        HashMap<Integer, String> firm = new HashMap<>();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            conn = databaseConnection.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery("Select * from company.firm");
            while(rs.next()){
                firm.put(Integer.valueOf(rs.getString("firm_id")), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Firms: " + firm.toString());
        return firm;
    }





}
