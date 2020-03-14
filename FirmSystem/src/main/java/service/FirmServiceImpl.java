package service;

import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class FirmServiceImpl implements FirmService {

    public void findAllFirm(){
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        HashMap<String, String> firm = new HashMap<>();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            conn = databaseConnection.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery("Select * from company.firm");
            while(rs.next()){
                firm.put(rs.getString("firm_id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(firm.toString());

    }



}
