package domain;

import DataAccessObject.BranchDAO;

import java.util.ArrayList;
import java.util.List;

public class Branch implements BranchDAO {

    private int branchId;
    private String name;
    private String address;
    private int budget;
    private int worth;
    private String establishment;
    private String firm;
    private List<Branch> listBranch;

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public void setListBranch(List<Branch> listBranch) {
        this.listBranch = listBranch;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    @Override
    public String toString() {
        return "Branch{" +
                " name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", budget=" + budget +
                ", worth=" + worth +
                ", establishment='" + establishment + '\'' +
                '}';
    }

    @Override
    public List<Branch> getListBranch() {
        return listBranch;
    }

    @Override
    public void setListBranch(){
        listBranch = new ArrayList<>();
    }

    @Override
    public void addListBranch(Branch e){
        listBranch.add(e);
    }

    @Override
    public void removeListBranch(Branch e){
        listBranch.remove(e);
    }

    @Override
    public void updateListBranch(Branch e) {
        //update here
    }
}
