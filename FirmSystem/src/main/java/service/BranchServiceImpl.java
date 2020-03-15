package service;

import domain.Branch;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class BranchServiceImpl implements BranchService {

    public HashMap<Integer, Branch> findAllBranch(){
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        HashMap<Integer, Branch> branchHashMap = new HashMap<>();

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            conn = databaseConnection.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery("Select * from company.branch");
            while(rs.next()){
                Branch branch = new Branch();
                branch.setName(rs.getString("name"));
                branch.setAddress(rs.getString("address"));
                branch.setBudget(Double.valueOf(rs.getString("budget")));
                branch.setWorth(Double.valueOf(rs.getString("worth")));
                branch.setEstablishment(rs.getString("establishment"));
                branch.setFirm(Integer.valueOf(rs.getString("firm")));

                branchHashMap.put(Integer.valueOf(rs.getString("branch_id")), branch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Branch: " + branchHashMap.toString());
        return branchHashMap;
    }

    public Branch findSelectedBranch(String selectedBranch){
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        Branch branch = new Branch();
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            conn = databaseConnection.getConnection();
            statement = conn.createStatement();
            String query = "Select * from company.branch c where c.name = '"+ selectedBranch + "'";
            //System.out.println(query);
            rs = statement.executeQuery( query);
            while(rs.next()){
                branch.setName(rs.getString("name"));
                branch.setAddress(rs.getString("address"));
                branch.setBudget(Double.valueOf(rs.getString("budget")));
                branch.setWorth(Double.valueOf(rs.getString("worth")));
                branch.setEstablishment(rs.getString("establishment"));
                branch.setFirm(Integer.valueOf(rs.getString("firm")));
                return branch;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeBranch(String selectedBranch){
        Connection conn = null;
        Statement statement = null;
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            conn = databaseConnection.getConnection();
            statement = conn.createStatement();
            String query = "delete  from company.branch where name = '"+ selectedBranch + "'";
            //System.out.println(query);
            statement.executeUpdate( query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
