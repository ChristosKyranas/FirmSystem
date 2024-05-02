package repository;

import factory.DatabaseConnectionFactory;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static enumaration.MessageEnum.DUPLICATE_ENTRY_FIRM_NAME;

public class FirmRepository implements dao.FirmDAO {

    // 0 -> delete or 1 -> active
    private static final int DELETE_OR_ACTIVE = 0;

    private static final String GET_ALL_FIRMS = "SELECT * FROM company.firm ORDER BY name ASC";
    private static final String GET_ALL_ACTIVE_FIRMS = "SELECT * FROM company.firm WHERE active = 1 ORDER BY name ASC";
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
     *
     * @return List<String>
     */
    public List<String> getAllFirms(){
        //HashMap<Integer, String> firmHashMap = new HashMap<>();
        List<String> orderedListFirm = new ArrayList<>();
        try {
            Statement statement = makeConnection().createStatement();
            ResultSet rs;
            rs = (DELETE_OR_ACTIVE == 0) ?  statement.executeQuery(GET_ALL_FIRMS) : statement.executeQuery(GET_ALL_ACTIVE_FIRMS);

            while(rs.next()){
                //firmHashMap.put(Integer.valueOf(rs.getString(FIRM_ID)), rs.getString(NAME));
                //System.out.println("Firms: " + firmHashMap.toString());
                orderedListFirm.add(rs.getString(NAME));
            }

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLException e) {
            // getMessage

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
        try {
            Statement statement = makeConnection().createStatement();
            String query = "INSERT INTO company.firm (name) VALUES ('" + firmName + "');";

            statement.executeUpdate(query);

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate entry: " + firmName + " already exists");

            System.out.println(DUPLICATE_ENTRY_FIRM_NAME.getMessage() + firmName);

            JOptionPane.showMessageDialog(FirmForm,
                    "Firm already exists.\nEnter a different firm name.",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

    /**
     * delete firm from
     * @param firmName
     */
    public void removeFirm(String firmName){
        try {
            Statement statement = makeConnection().createStatement();
//            String query = "DELETE FROM company.firm WHERE name = '"+ firmName +"'";

            String query = (DELETE_OR_ACTIVE == 0 ) ? "DELETE FROM company.firm WHERE name = '"+ firmName +"'" : "UPDATE company.firm SET active = 0 WHERE name = '"+ firmName +"'";

            System.out.println(query);
            statement.executeUpdate(query);

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getFirm(String selectedFirm){
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
            // getMessage

            e.printStackTrace();
        }
        return null;
    }

    public Connection makeConnection(){
        DatabaseConnectionFactory databaseConnectionFactory = new DatabaseConnectionFactory();
        return databaseConnectionFactory.getConnection();
    }
}