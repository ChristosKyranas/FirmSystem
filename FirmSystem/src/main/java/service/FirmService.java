package service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public interface FirmService {

    HashMap<Integer, String> findAllFirm();

    void addFirm(String firmName);

    void removeFirm(String firmName);

    List<String> findSelectedFirm(String selectedFirm);

    Connection makeConnection();

}
