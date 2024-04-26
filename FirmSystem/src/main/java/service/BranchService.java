package service;

import domain.Branch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface BranchService {

    List<Branch> getAllBranch();

    Branch getSelectedBranch(String selectedBranch, String country, String city);

    void removeBranch(String selectedBranch, String country, String city);

    Branch getBranch() throws SQLException;
    Branch getBranch(ResultSet rs) throws SQLException;

    Connection makeConnection();
}
