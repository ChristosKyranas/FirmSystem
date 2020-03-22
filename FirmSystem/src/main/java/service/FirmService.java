package service;

import java.sql.Connection;
import java.util.List;

public interface FirmService {

    List<String> findAllFirm();

    void addFirm(String firmName);

    void removeFirm(String firmName);

    List<String> findSelectedFirm(String selectedFirm);

    Connection makeConnection();

}
