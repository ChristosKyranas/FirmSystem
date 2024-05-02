package dao;

import java.awt.*;
import java.sql.Connection;
import java.util.List;

public interface FirmDAO {

    List<String> getAllFirms();

    void addFirm(String firmName, Component FirmForm);

    void removeFirm(String firmName);

    List<String> getFirm(String selectedFirm);

    Connection makeConnection();

}
