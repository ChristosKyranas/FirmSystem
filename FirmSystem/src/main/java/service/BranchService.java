package service;

import domain.Branch;

import java.util.HashMap;

public interface BranchService {

    HashMap<Integer, Branch> findAllBranch();

}
