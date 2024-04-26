package GUI.Dialogs;

import service.FirmServiceImpl;

import javax.swing.*;
import java.awt.*;

import static enumaration.MessageEnum.INVALID_ALPHANUMERICAL_FIRM_NAME;
import static enumaration.MessageEnum.INVALID_EMPTY_FIRM_NAME;
import static utils.ANSI.*;

public class FirmForm extends JDialog  {
    private JPanel firmPanel;
    private JTextField textFirmName;
    private JButton saveFirm;
    private JButton saveAndCloseFirm;
    private JButton cancelFirm;

    public FirmForm(JFrame parent) {
        super(parent);
        setTitle("Firm");
        setContentPane(firmPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        saveFirm.addActionListener(e -> addFirm());

        saveAndCloseFirm.addActionListener(e -> {
            // save then release resources
			if (addFirm()){
				dispose();
			}
		});

        cancelFirm.addActionListener(e -> {
			// release resources
			dispose();
		});

        setVisible(true);
    }

    /**
     * Insert Firm in Database
     *
     * @return boolean
     */
    public boolean addFirm(){
        String text = textFirmName.getText();

        System.out.println("---------------------------------------");
        System.out.print(ANSI_BLACK);
        System.out.print(ANSI_GREEN_BACKGROUND);
        System.out.println("isAlphaNumeric: " + isAlphaNumeric(text) + " " + text);
        System.out.println("startWithWhitespace: " + text.equals("") + " " + text);
        System.out.print(ANSI_RESET);
        System.out.println("---------------------------------------");

        if(text.equals("")) {
            System.out.println(INVALID_EMPTY_FIRM_NAME.getMessage());
            // display pop-up error message to user
            JOptionPane.showMessageDialog(FirmForm.this,
                    "Firm name cannot be empty",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!isAlphaNumeric(text)) {
            System.out.println(INVALID_ALPHANUMERICAL_FIRM_NAME.getMessage());
            // display pop-up error message to user
            JOptionPane.showMessageDialog(FirmForm.this,
                    "Firm name must be alphanumerical",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            System.out.println(text);
            FirmServiceImpl firmService = new FirmServiceImpl();
            firmService.addFirm(text, FirmForm.this);
            return true;
        }

	}

    /**
     * Check if matches the pattern
     * @param s
     * @return boolean
     */
    public boolean isAlphaNumeric(String s){
        // is alpha or numeric or char "&"
        String pattern= "^[a-zA-Z0-9&]*$";
        // add white spaces

        return s.matches(pattern);
    }


    public static void main(String[] args) {
        FirmForm firmForm = new FirmForm(null);
    }
}
