package service;

import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FirmServiceImpl implements FirmService {

    private static final String ALL_FIRMS = "Select * " +
                                            "from company.firm " +
                                            "order by name asc";
    private static final String FIRM_ID = "firm_id";
    private static final String NAME = "name";

    private DatabaseConnection databaseConnection = null;
    private Connection conn = null;
    private Statement statement = null;
    private ResultSet rs = null;
    private String query = "";

    /*HashMap<Integer, String>*/
    public List<String> findAllFirm(){
        //HashMap<Integer, String> firmHashMap = new HashMap<>();
        List<String> orderedListFirm = new ArrayList<>();
        try {
            statement = makeConnection().createStatement();
            rs = statement.executeQuery(ALL_FIRMS);
            while(rs.next()){
                //firmHashMap.put(Integer.valueOf(rs.getString(FIRM_ID)), rs.getString(NAME));
                //System.out.println("Firms: " + firmHashMap.toString());
                orderedListFirm.add(rs.getString(NAME));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("Firms: " + firmHashMap.toString());
        //return firmHashMap;
        return orderedListFirm;
    }

    public void addFirm(String firmName){
        int id = 1;
        try {
            statement = makeConnection().createStatement();
            rs = statement.executeQuery("select max(firm_id) as id " +
                                            "from company.firm;");
            System.out.println(rs);
            System.out.println(id);
            query = "insert into company.firm (name) values ('" + firmName + "');";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeFirm(String firmName){
        try {
            statement = makeConnection().createStatement();
            query = "delete " +
                    "from company.firm " +
                    "where name = '"+ firmName +"'";
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> findSelectedFirm(String selectedFirm){
        List<String> firm = new ArrayList<>();
        try {
            statement = makeConnection().createStatement();
            query = "select count( b.name ) as FirmBranches , sum( b.worth ) as FirmWorth , count( distinct  b.country ) as FirmCountries\n" +
                    "from company.branch b , company.firm f \n" +
                    "where b.firm = f.firm_id and f.name = '"+ selectedFirm + "'";
            rs = statement.executeQuery( query);
            while(rs.next()){
                firm.add(rs.getString("FirmBranches"));
                firm.add(String.format("%s€", String.format("%,d", (long) rs.getDouble("FirmWorth"))));
                firm.add(rs.getString("FirmCountries"));
                return firm;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection makeConnection(){
        databaseConnection = new DatabaseConnection();
        return databaseConnection.getConnection();
    }
}