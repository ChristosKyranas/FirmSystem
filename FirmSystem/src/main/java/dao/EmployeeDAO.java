package dao;

import java.sql.Connection;

public interface EmployeeDAO {

  /*  HashMap<Integer, Branch> findAllBranch();

    Branch findSelectedBranch(String selectedBranch, String country, String city);

    void removeBranch(String selectedBranch, String country, String city);

    Branch getBranch() throws SQLException;
*/
    Connection makeConnection();
}
