package service;

import factory.DatabaseConnectionFactory;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FirmServiceImpl implements FirmService {

    private static final String GET_ALL_FIRMS = "SELECT * FROM company.firm ORDER BY name ASC";
//    private static final String FIRM_ID = "firm_id";
    private static final String NAME = "name";

//    private DatabaseConnection databaseConnection = null;
//    private Connection conn = null;
//    private Statement statement = null;
//    private ResultSet rs = null;
//    private String query = "";

    /*HashMap<Integer, String>*/

    /**
     * Get all firms from database
     * @return List<String>
     */
    public List<String> getAllFirms(){
        //HashMap<Integer, String> firmHashMap = new HashMap<>();
        List<String> orderedListFirm = new ArrayList<>();
        try {
            Statement statement = makeConnection().createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL_FIRMS);
            while(rs.next()){
                //firmHashMap.put(Integer.valueOf(rs.getString(FIRM_ID)), rs.getString(NAME));
                //System.out.println("Firms: " + firmHashMap.toString());
                orderedListFirm.add(rs.getString(NAME));
            }

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("Firms: " + firmHashMap.toString());
        //return firmHashMap;
        return orderedListFirm;
    }

    /**
     * Insert firm in database
     *
     * @param firmName
     * @param FirmForm
     */
    public void addFirm(String firmName, Component FirmForm){
//        int id = 1;
        try {
            Statement statement = makeConnection().createStatement();
//            ResultSet rs = statement.executeQuery("SELECT max(firm_id) AS id FROM company.firm;");
//            System.out.println(rs);
//            System.out.println(id);
            String query = "INSERT INTO company.firm (name) VALUES ('" + firmName + "');";

            statement.executeUpdate(query);

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate entry: " + firmName + " already exists");
            JOptionPane.showMessageDialog(FirmForm,
                    "Firm already exists.\nEnter a different firm name.",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

    public void removeFirm(String firmName){
        try {
            Statement statement = makeConnection().createStatement();
            String query = "delete " +
                    "from company.firm " +
                    "where name = '"+ firmName +"'";
            System.out.println(query);
            statement.executeUpdate(query);

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> findSelectedFirm(String selectedFirm){
        List<String> firm = new ArrayList<>();
        try {
            Statement statement = makeConnection().createStatement();
            String query = "select count( b.name ) as FirmBranches , sum( b.worth ) as FirmWorth , count( distinct  b.country ) as FirmCountries\n" +
                    "from company.branch b , company.firm f \n" +
                    "where b.firm = f.firm_id and f.name = '"+ selectedFirm + "'";
            ResultSet rs = statement.executeQuery( query);
            while(rs.next()){
                firm.add(rs.getString("FirmBranches"));
                firm.add(String.format("%s€", String.format("%,d", (long) rs.getDouble("FirmWorth"))));
                firm.add(rs.getString("FirmCountries"));
                return firm;
            }

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection makeConnection(){
        DatabaseConnectionFactory databaseConnectionFactory = new DatabaseConnectionFactory();
        return databaseConnectionFactory.getConnection();
    }
}