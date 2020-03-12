package DataAccessObject;

import models.Branch;

import java.util.List;

public interface BranchDAO {

    public List<Branch> getListBranch();

    public void setListBranch();

    public void addListBranch(Branch e);

    public void removeListBranch(Branch e);

    public void updateListBranch(Branch e); //careful with update method
}
