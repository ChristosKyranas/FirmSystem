package domain;

public class PersonalInfo {
    //variables checked "OK"
    private int personalInfoId;
    private String name;
    private String surName;
    private String fatherName;
    private String motherName;
    private String id; //identity-passport
    private int afm ;
    private int amka;
    private String address;
    private int age;
    private String city;
    private String country;
    private int postCode;
    private int employee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getAfm() {
        return afm;
    }

    public void setAfm(int afm) {
        this.afm = afm;
    }

    public int getAmka() {
        return amka;
    }

    public void setAmka(int amka) {
        this.amka = amka;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public int getPersonalInfoId() {
        return personalInfoId;
    }

    public void setPersonalInfoId(int personalInfoId) {
        this.personalInfoId = personalInfoId;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "PersonalInfo{" +
                "personalInfoId=" + personalInfoId +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", id='" + id + '\'' +
                ", afm=" + afm +
                ", amka=" + amka +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postCode=" + postCode +
                ", employee=" + employee +
                '}';
    }
}
