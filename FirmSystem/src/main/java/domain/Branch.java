package domain;



import java.util.List;

public class Branch {

    private int branchId;
    private String name;
    private String address;
    private String city;
    private String country;
    private double budget;
    private double worth;
    private String establishment;
    private int firm;

    private List<Branch> listBranch;


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


}
