package service;

import domain.Branch;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BranchService {

    List<Branch> findAllBranch();

    Branch findSelectedBranch(String selectedBranch, String country, String city);

    void removeBranch(String selectedBranch, String country, String city);

    Branch getBranch() throws SQLException;

    Connection makeConnection();
}
