package service;

import domain.PersonalInfo;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonalInfoServiceImpl implements PersonalInfoService {

    private static final String PERSONAL_ID = "personal_info_id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String FATHER_NAME = "father_name";
    private static final String MOTHER_NAME = "mother_name";
    private static final String ID = "id";
    private static final String AFM = "afm";
    private static final String AMKA = "amka";
    private static final String ADDRESS = "address";
    private static final String AGE = "age";
    private static final String CITY = "city";
    private static final String COUNTRY = "country";
    private static final String POST_CODE = "post_code";
    private static final String EMPLOYEE = "employee";

    private DatabaseConnection databaseConnection = null;
    private Connection conn = null;
    private Statement statement = null;
    private ResultSet rs = null;
    private String query = "";

    public PersonalInfo findSelectedPersonalInfo(int selectedEmployee){
        try {
            statement = makeConnection().createStatement();
            query = "Select * " +
                    "from company.personal_info c " +
                    "where c.employee = " + selectedEmployee ;
            rs = statement.executeQuery(query);
            while(rs.next()){
                return getPersonalInfo();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PersonalInfo getPersonalInfo() throws SQLException {
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setPersonalInfoId(Integer.valueOf(rs.getString(PERSONAL_ID)));
        personalInfo.setName(rs.getString(NAME));
        personalInfo.setSurName(rs.getString(SURNAME));
        personalInfo.setFatherName(rs.getString(FATHER_NAME));
        personalInfo.setMotherName(rs.getString(MOTHER_NAME));
        personalInfo.setId(rs.getString(ID));
        personalInfo.setAfm(Integer.valueOf(rs.getString(AFM)));
        personalInfo.setAmka(Integer.valueOf(rs.getString(AMKA)));
        personalInfo.setAddress(rs.getString(ADDRESS));
        personalInfo.setAge(Integer.valueOf(rs.getString(AGE)));
        personalInfo.setCity(rs.getString(CITY));
        personalInfo.setCountry(rs.getString(COUNTRY));
        personalInfo.setPostCode(Integer.valueOf(rs.getString(POST_CODE)));
        personalInfo.setEmployee(Integer.valueOf(rs.getString(EMPLOYEE)));
        return personalInfo;
    }

    public Connection makeConnection(){
        databaseConnection = new DatabaseConnection();
        return databaseConnection.getConnection();
    }
}