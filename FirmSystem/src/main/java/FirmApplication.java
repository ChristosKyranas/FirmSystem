import GUI.FirmGuiApplication;
import service.FirmServiceImpl;
import utils.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class FirmApplication {

    public static void main(String[] args) {
        JFrame frame = new JFrame("FirmApplication");
        frame.setContentPane(new FirmGuiApplication().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        FirmServiceImpl firmService = new FirmServiceImpl();
        firmService.findAllFirm();
    }
}
