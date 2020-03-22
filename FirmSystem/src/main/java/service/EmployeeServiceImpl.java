package service;

import domain.Employee;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class EmployeeServiceImpl implements EmployeeService {

    private static final String RETURN_ALL_EMPLOYEES = "Select * from company.employee";
    /*private static final String BRANCH_ID = "branch_id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String COUNTRY = "country";
    private static final String BUDGET = "budget";
    private static final String WORTH = "worth";
    private static final String ESTABLISHMENT = "establishment";
    private static final String FIRM = "firm";
    */
    private DatabaseConnection databaseConnection = null;
    private Connection conn = null;
    private Statement statement = null;
    private ResultSet rs = null;
    private String query = "";

    public HashMap<Integer, Employee> findAllEmployee(){
        HashMap<Integer, Employee> employeeHashMap = new HashMap<>();
        try {
            statement = makeConnection().createStatement();
            rs = statement.executeQuery(RETURN_ALL_EMPLOYEES);
            while(rs.next()){
                employeeHashMap.put(Integer.valueOf(rs.getString("employee_id")), getEmployee());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Employee: " + employeeHashMap.toString());
        return employeeHashMap;
    }

    public void addEmployee(Employee employee){
        try{
            statement = makeConnection().createStatement();
            //------------CHECK------------
            //name - country - city
            //if it exists -> reject it
            //query = null
            //otherwise -> add it
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public Employee findSelectedEmployee(String selectedEmployee, String country, String city){
        try {
            statement = makeConnection().createStatement();
            query = "Select * " +
                    "from company.employee c " +
                    "where c.name = '"+ selectedEmployee + "' " +
                        "and c.country = '" + country + "' " +
                        "and c.city = '" + city + "'";
            rs = statement.executeQuery(query);
            while(rs.next()){
                return getEmployee();
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

    public Employee getEmployee() throws SQLException {
        Employee employee = new Employee();


        /*branch.setName(rs.getString(NAME));
        branch.setAddress(rs.getString(ADDRESS));
        branch.setCity(rs.getString(CITY));
        branch.setCountry(rs.getString(COUNTRY));
        branch.setBudget(Double.valueOf(rs.getString(BUDGET)));
        branch.setWorth(Double.valueOf(rs.getString(WORTH)));
        branch.setEstablishment(rs.getString(ESTABLISHMENT));
        branch.setFirm(Integer.valueOf(rs.getString(FIRM)));*/
//        return employee;
        return null;
    }


    public Connection makeConnection(){
        databaseConnection = new DatabaseConnection();
        return databaseConnection.getConnection();
    }
}