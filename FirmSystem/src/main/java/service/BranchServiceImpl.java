package service;

import domain.Branch;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.mysql.cj.util.StringUtils.isNullOrEmpty;

public class BranchServiceImpl implements BranchService {

    private static final String RETURN_ALL_BRANCHES = "Select * " +
                                                      "from company.branch " +
                                                      "order by name asc";
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
    /*HashMap<Integer, Branch>*/

    public List<Branch> findAllBranch(){
        //HashMap<Integer, Branch> branchHashMap = new HashMap<>();
        List<Branch> orderedListBranch = new ArrayList<>();
        try {
            statement = makeConnection().createStatement();
            rs = statement.executeQuery(RETURN_ALL_BRANCHES);
            while(rs.next()){
             //   branchHashMap.put(Integer.valueOf(rs.getString(BRANCH_ID)), getBranch());
                orderedListBranch.add(getBranch());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("Branch: " + branchHashMap.toString());
        //return branchHashMap;
        return orderedListBranch;
    }

    public void addBranch(Branch branch){
        try{
            statement = makeConnection().createStatement();
            //------------CHECK------------
//            if(branch.getName()!=null && branch.getAddress()!=null && branch.getCity()!=null && branch.getCountry()!=null && branch.getEstablishment()!=null ){
            System.out.println("test");
            System.out.println(branch.getName());
            query = "select * " +
                    "from company.branch where name='"+ branch.getName()+"'";
            System.out.println(query);
            rs = statement.executeQuery(query);
//                    "select * " +
//                    "from company.branch" +
////                    "where name = '"+ branch.getName()+
//                    "where name = 't' ");
//                    "' and address = '"+ branch.getAddress()+
//                    "' and city = '"+ branch.getCity()+
//                    "' and country = '"+ branch.getCountry()+
//                        "' and establishment = '"+ branch.getEstablishment()+
            System.out.println(rs.next());
//            if(!(isNullOrEmpty(branch.getName()) || isNullOrEmpty(branch.getAddress()) || isNullOrEmpty(branch.getCity()) || isNullOrEmpty(branch.getCountry()) || isNullOrEmpty(branch.getEstablishment())) ){
//
//                if (rs==null){
//                    System.out.println("test2");
//                }
//            }
//            query = "insert into company.firm (name) values ('" + firmName + "');";

            // if not exists insert
            if(!rs.next()){
                query = "INSERT INTO company.branch ( name, address, city, country, establishment, budget, worth, firm ) " +
                        "VALUES ('"+ branch.getName()+"','"+ branch.getAddress()+"','"+ branch.getCity()+"','"+ branch.getCountry()+"','"+ branch.getEstablishment()+"','"+ branch.getBudget()+"','"+ branch.getWorth()+"',"+ branch.getFirm()+");";
                System.out.println(query);
                statement.executeUpdate(query);
            }
            //name - country - city
            //if it exists -> reject it
            //query = null
            //otherwise -> add it
        }catch (SQLException e){
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Print Trace: /n");
            e.printStackTrace();
        }
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
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Print Trace: /n");
            e.printStackTrace();
        }
        return null;
    }

    public Branch findSelectedBranch(int selectedBranch){
        try {
            statement = makeConnection().createStatement();
            query = "Select * " +
                    "from company.branch c " +
                    "where c.branch_id = "+ selectedBranch ;
            rs = statement.executeQuery(query);
            while(rs.next()){
                return getBranch();
            }
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

    public void removeBranch(String selectedBranch, String country, String city){
        try {
            statement = makeConnection().createStatement();
            query =  "delete  " +
                     "from company.branch " +
                     "where name = '"+ selectedBranch + "' " +
                            "and country = '" + country +"' " +
                            "and city = '" + city + "'" ;
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Print Trace: /n");
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