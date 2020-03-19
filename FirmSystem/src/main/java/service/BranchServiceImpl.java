package service;

import domain.Branch;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class BranchServiceImpl implements BranchService {

    private static final String RETURN_ALL_BRANCHES = "Select * from company.branch";
    private static final String BRANCH_ID = "branch_id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String COUNTRY = "country";
    private static final String BUDGET = "budget";
    private static final String WORTH = "worth";
    private static final String ESTABLISHMENT = "establishment";
    private static final String FIRM = "firm";
    private DatabaseConnection databaseConnection = null;
    private Connection conn = null;
    private Statement statement = null;
    private ResultSet rs = null;
    private String query = "";

    public HashMap<Integer, Branch> findAllBranch(){
        HashMap<Integer, Branch> branchHashMap = new HashMap<>();
        try {
            statement = makeConnection().createStatement();
            rs = statement.executeQuery(RETURN_ALL_BRANCHES);
            while(rs.next()){
                branchHashMap.put(Integer.valueOf(rs.getString(BRANCH_ID)), getBranch());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Branch: " + branchHashMap.toString());
        return branchHashMap;
    }

    public Branch findSelectedBranch(String selectedBranch, String country, String city){
        try {
            statement = makeConnection().createStatement();
            query = "Select * " +
                    "from company.branch c " +
                    "where c.name = '"+ selectedBranch + "' " +
                        "and c.country = '" + country + "' " +
                        "and c.city = '" + city + "'";
            rs = statement.executeQuery(query);
            while(rs.next()){
                return getBranch();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void removeBranch(String selectedBranch, String country, String city){
        try {
            statement = makeConnection().createStatement();
            query =  "delete  " +
                     "from company.branch " +
                     "where name = '"+ selectedBranch + "' " +
                            "and country = '" + country +"' " +
                            "and city = '" + city + "'" ;
            statement.executeUpdate( query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Branch getBranch() throws SQLException {
        Branch branch = new Branch();
        branch.setName(rs.getString(NAME));
        branch.setAddress(rs.getString(ADDRESS));
        branch.setCity(rs.getString(CITY));
        branch.setCountry(rs.getString(COUNTRY));
        branch.setBudget(Double.valueOf(rs.getString(BUDGET)));
        branch.setWorth(Double.valueOf(rs.getString(WORTH)));
        branch.setEstablishment(rs.getString(ESTABLISHMENT));
        branch.setFirm(Integer.valueOf(rs.getString(FIRM)));
        return branch;
    }

    public Connection makeConnection(){
        databaseConnection = new DatabaseConnection();
        return databaseConnection.getConnection();
    }
}