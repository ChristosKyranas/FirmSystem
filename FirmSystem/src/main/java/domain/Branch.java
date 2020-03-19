package domain;

import DataAccessObject.BranchDAO;

import java.util.ArrayList;
import java.util.List;

public class Branch implements BranchDAO {

    private int branchId;
    private String name;
    private String address;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setWorth(double worth) {
        this.worth = worth;
    }

    private String city;
    private String country;
    private double budget;
    private double worth;
    private String establishment;
    private int firm;
    private List<Branch> listBranch;

    public int getFirm() {
        return firm;
    }

    public void setFirm(int firm) {
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

    public double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public double getWorth() {
        return worth;
    }

    public void setWorth(Double worth) {
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
