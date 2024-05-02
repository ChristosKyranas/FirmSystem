package model;


public class Branch {

    private int branchId;
    private String name;
    private String address;
    private String city;
    private String country;
    private double budget;
    private double worth;
    private String establishment;
    // foreign key to Firm
    private int firm;

    /**
     * Constructor - none parameter
     */
    public Branch() {
    }

    /**
     * Constructor - all parameters
     *
     * @param branchId
     * @param name
     * @param address
     * @param city
     * @param country
     * @param budget
     * @param worth
     * @param establishment
     * @param firm
     */
    public Branch(int branchId, String name, String address, String city, String country, double budget, double worth, String establishment, int firm) {
        this.branchId = branchId;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.budget = budget;
        this.worth = worth;
        this.establishment = establishment;
        this.firm = firm;
    }

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
