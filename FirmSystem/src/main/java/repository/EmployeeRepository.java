package repository;

import dao.EmployeeDAO;
import model.Employee;
import factory.DatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements EmployeeDAO {

//    private static final String RETURN_ALL_EMPLOYEES = "Select * from company.employee";
//
//    private DatabaseConnection databaseConnection = null;
//    private Connection conn = null;
//    private Statement statement = null;
//    private ResultSet rs = null;
//    private String query = "";

    public List<Employee> findAllEmployee(){
        List<Employee> orderedEmployeeList = new ArrayList<>();
        try {
            Statement statement = makeConnection().createStatement();
//            ResultSet rs = statement.executeQuery("Select * from company.employee");
            ResultSet rs = null;
//            while(rs.next()){
//                orderedEmployeeList.add(getEmployee());
//            }

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderedEmployeeList;
    }

    public Employee getEmployee() throws SQLException {
        Employee employee = new Employee();
//        employee.setEmployeeId(Integer.valueOf(rs.getString("employee_id")));
//        employee.setBranch(Integer.valueOf(rs.getString("branch")));

        return employee;
    }

    public int findSelectedEmployee(String selectedEmployee, String surName, String fatherName, String branch){
        try {
            Statement statement = makeConnection().createStatement();
            String query = "Select employee_id " +
                    "from company.employee e , company.personal_info c, company.branch b " +
                    "where c.name = '"+ selectedEmployee + "' " +
                        "and c.surname = '" + surName + "' " +
                        "and c.father_name = '" + fatherName + "' " +
                        "and c.employee = e.employee_id " +
                        "and b.branch_id = e.branch " +
                        "and b.name = '" + branch + "' ";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = Integer.parseInt(rs.getString("employee_id"));
                return id;
            }

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /*

    public void removeBranch(String selectedBranch, String country, String city){
        try {
            statement = makeConnection().createStatement();
            query =  "delete  " +
                     "from company.branch " +
                     "where name = '"+ selectedBranch + "' " +
                            "and country = '" + country +"' " +
                            "and city = '" + city + "'" ;
            statement.executeUpdate( query);

            // close connection
            statement.close();
            makeConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

*/


    /*public void addEmployee(Employee employee){
        try{
            statement = makeConnection().createStatement();
            //------------CHECK------------
            //name - country - city
            //if it exists -> reject it
            //query = null
            //otherwise -> add it

            // close connection
            statement.close();
            makeConnection().close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
*/

    public Connection makeConnection(){
        DatabaseConnectionFactory databaseConnectionFactory = new DatabaseConnectionFactory();
        return databaseConnectionFactory.getConnection();
    }
}