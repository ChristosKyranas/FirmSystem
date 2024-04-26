package service;

import GUI.Dialogs.CreateMessageGui;
import GUI.Dialogs.LoginForm;
import domain.Branch;
import factory.DatabaseConnectionFactory;
import utils.ANSI;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static utils.ANSI.*;

public class BranchServiceImpl implements BranchService {

    private static final String GET_ALL_BRANCHES = "SELECT * FROM company.branch ORDER BY name ASC";
    private static final String GET_ALL_ACTIVE_BRANCHES = "SELECT * FROM company.branch WHERE active = 1 ORDER BY name ASC";
    private static final String BRANCH_ID = "branch_id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String COUNTRY = "country";
    private static final String BUDGET = "budget";
    private static final String WORTH = "worth";
    private static final String ESTABLISHMENT = "establishment";
    private static final String FIRM = "firm";
    private DatabaseConnectionFactory databaseConnectionFactory = null;
    private Connection conn = null;
    private Statement statement = null;
//    private ResultSet rs = null;
    private String query = "";
    /*HashMap<Integer, Branch>*/
    private JScrollPane branchJScrollPane;

    /**
     * Get all branches from Database
     * @return List<Branch>
     */
    public List<Branch> getAllBranch(){
        //HashMap<Integer, Branch> branchHashMap = new HashMap<>();
        List<Branch> orderedListBranch = new ArrayList<>();
        try {
            Statement statement = makeConnection().createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_ACTIVE_BRANCHES);

            while(rs.next()){
             //   branchHashMap.put(Integer.valueOf(rs.getString(BRANCH_ID)), getBranch());
                orderedListBranch.add(getBranch(rs));
            }

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("Branch: " + branchHashMap.toString());
        //return branchHashMap;
        return orderedListBranch;
    }

    /**
     * Add new Branch in Database
     *
     * @param branch
     */
    public void addBranch(Branch branch){
        try{
            Statement statement = makeConnection().createStatement();
            //------------CHECK------------
//            if(branch.getName()!=null && branch.getAddress()!=null && branch.getCity()!=null && branch.getCountry()!=null && branch.getEstablishment()!=null ){
            System.out.println("test");
            System.out.println(branch.getName());

            // check for duplicate
            String query = "SELECT count(name) FROM company.branch WHERE name='" + branch.getName() + "'";
//            String query = "SELECT * FROM company.branch WHERE name=?";
//            PreparedStatement preparedStatement = makeConnection().prepareStatement(query);
//            preparedStatement.setString(1, branch.getName());

            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);

            System.out.println(ANSI_CYAN + rs.next() + ANSI_RESET);

            // check if firm_id exists
            Statement statement2 = makeConnection().createStatement();
//            String query2 = "SELECT count(firm.name) FROM firm INNER JOIN branch ON firm_id = ?";
            String query2 = "SELECT count(firm.name) FROM firm INNER JOIN branch ON firm_id = " + branch.getFirm() +"";
            System.out.println(query2);
            ResultSet rs2 = statement2.executeQuery(query2);

            System.out.println(ANSI_BLUE + rs2.next() + ANSI_RESET);

            // show message that there is no firm with this firm_id
            if(!rs2.next()){
//                JOptionPane.showMessageDialog(LoginForm.this,
//                        "Email or Password Invalid",
//                        "Try Again",
//                        JOptionPane.ERROR_MESSAGE);
                System.out.println("Firm_id does not exist");
            }

            // if doesn t exist && firm_id is valid then insert branch
            if(!rs.next() && rs2.next()){
                query = "INSERT INTO company.branch ( name, address, city, country, establishment, budget, worth, firm, active ) " +
                        "VALUES ('"+ branch.getName()+"','"+ branch.getAddress()+"','"+ branch.getCity()+"','"+ branch.getCountry()+"','"+ branch.getEstablishment()+"','"+ branch.getBudget()+"','"+ branch.getWorth()+"',"+ branch.getFirm()+",1);";
                System.out.println(query);
                statement.executeUpdate(query);
            }

            // close connection
            statement.close();
            makeConnection().close();

            //name - country - city
            //if it exists -> reject it
            //query = null
            //otherwise -> add it
//            new CreateMessageGui(branchJScrollPane, "test");
        }catch (SQLException e){
//            new CreateMessageGui(branchJScrollPane, "test");
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Message: " + e.getMessage());

            System.out.println("Print Trace: /n");
            e.printStackTrace();
        }
    }


    public Branch getSelectedBranch(String selectedBranch, String country, String city){
        try {
            Statement statement = makeConnection().createStatement();
            String query = "Select * " +
                    "from company.branch c " +
                    "where c.name = '"+ selectedBranch + "' " +
                        "and c.country = '" + country + "' " +
                        "and c.city = '" + city + "'";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                return getBranch(rs);
            }

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLException e) {
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Print Trace: /n");
            e.printStackTrace();
        }
        return null;
    }

    public Branch getSelectedBranch(int selectedBranch){
        try {
            Statement statement = makeConnection().createStatement();
            String query = "Select * " +
                    "from company.branch c " +
                    "where c.branch_id = "+ selectedBranch ;
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                return getBranch();
            }

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLException e) {
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Print Trace: /n");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * set branch inactive - "delete"
     *
     * @param selectedBranch
     * @param country
     * @param city
     */
    public void removeBranch(String selectedBranch, String country, String city){
        try {
            Statement statement = makeConnection().createStatement();
//            String query =  "DELETE FROM company.branch WHERE name = '"+ selectedBranch + "' AND country = '" + country + "' AND city = '" + city + "'" ;
            String query =  "UPDATE company.branch SET active = 0 WHERE name = '"+ selectedBranch + "' AND country = '" + country + "' AND city = '" + city + "'" ;
            System.out.println(query);
            statement.executeUpdate(query);

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLException e) {
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Message: " + e.getMessage());

            System.out.println("Print Trace: /n");
            e.printStackTrace();
        }
    }

    @Override
    public Branch getBranch() throws SQLException {
//        Branch branch = new Branch();
//
//        branch.setName(rs.getString(NAME));
//        branch.setAddress(rs.getString(ADDRESS));
//        branch.setCity(rs.getString(CITY));
//        branch.setCountry(rs.getString(COUNTRY));
//        branch.setBudget(Double.valueOf(rs.getString(BUDGET)));
//        branch.setWorth(Double.valueOf(rs.getString(WORTH)));
//        branch.setEstablishment(rs.getString(ESTABLISHMENT));
//        branch.setFirm(Integer.valueOf(rs.getString(FIRM)));

        return null;
    }

    public Branch getBranch(ResultSet rs) throws SQLException {
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
        DatabaseConnectionFactory databaseConnectionFactory = new DatabaseConnectionFactory();
        return databaseConnectionFactory.getConnection();
    }
}