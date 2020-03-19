package GUI;

import GUI.initializer.InitializerBranchJScrollPane;
import GUI.initializer.InitializerFirmJScrollPane;
import domain.Branch;
import service.BranchServiceImpl;
import service.FirmServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class FirmGuiApplication {
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    //-----------------------Firm--------------------
    private JList listFirm;
    private JScrollPane firmJScrollPane;
    private JButton buttonCreateFirm;
    private JButton buttonSearchFirm;
    private JButton buttonDeleteFirm;
    private JTextField textFirmName;
    private JTextField textCountCountries;
    private JTextField textCountBranches;
    private JTextField textSumProfit;
    private JTextField textCountEmployees;
    private JTextField textSumWorth;
    private JTextField textSumIncome;
    private JTextField textSumOutcome;
    //-----------------------Branch------------------
    private JList listBranch;
    private JScrollPane branchJScrollPane;
    private JButton buttonCreateBranch;
    private JButton buttonSearchBranch;
    private JButton buttonUpdateBranch;
    private JButton buttonDeleteBranch;
    private JTextField textBranchName;
    private JTextField textBranchAddress;
    private JTextField textBranchEstablishment;
    private JTextField textBranchWorth;
    private JTextField textBranchBudget;
    private JTextField textBranchFirm;
    private JTextField textBranchCountry;
    private JTextField textBranchCity;
    //-----------------------Employee----------------
    private JList listEmployee;
    private JScrollPane employeeJScrollPane;
    private JButton buttonSearchEmployee;
    private JButton buttonCreateEmployee;
    private JButton buttonUpdateEmployee;
    private JButton buttonDeleteEmployee;
    private JTextField textEmployeeName;
    private JTextField textEmployeeSurname;
    private JTextField textEmployeeFatherName;
    private JTextField textEmployeeMotherName;
    private JTextField textEmployeeAddress;
    private JTextField textEmployeeAge;
    private JTextField textEmployeeCity;
    private JTextField textEmployeeIdentity;
    private JTextField textEmployeeCountry;
    private JTextField textEmployeePostCode;
    private JTextField textEmployeeAfm;
    private JTextField textEmployeeAmka;
    private JTextField textEmployeeBranch;
    private JTextField textEmployeeFirm;
    //--------------------Additional-----------------
    //selectedFirm is the selected value from listFirm
    private static String selectedFirm = "";
    //selectedBranch is the selected value from listBranch
    private static String selectedBranch = "";
    private static String selectedCountry = "";
    private static String selectedCity = "";

    public JScrollPane getFirmJScrollPane() {
        return firmJScrollPane;
    }

    public void setFirmJScrollPane(JScrollPane firmJScrollPane) {
        this.firmJScrollPane = firmJScrollPane;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTabbedPane getTabbedPane1() {
        return tabbedPane1;
    }

    public void setTabbedPane1(JTabbedPane tabbedPane1) {
        this.tabbedPane1 = tabbedPane1;
    }

    public JTextField getTextFirmName() {
        return textFirmName;
    }

    public void setTextFirmName(JTextField textFirmName) {
        this.textFirmName = textFirmName;
    }

    public JList getListBranch() {
        return listBranch;
    }

    public void setListBranch(JList listBranch) {
        this.listBranch = listBranch;
    }

    public JTextField getTextBranchName() {
        return textBranchName;
    }

    public void setTextBranchName(JTextField textBranchName) {
        this.textBranchName = textBranchName;
    }

    public JTextField getTextBranchAddress() {
        return textBranchAddress;
    }

    public void setTextBranchAddress(JTextField textBranchAddress) {
        this.textBranchAddress = textBranchAddress;
    }

    public JTextField getTextBranchEstablishment() {
        return textBranchEstablishment;
    }

    public void setTextBranchEstablishment(JTextField textBranchEstablishment) {
        this.textBranchEstablishment = textBranchEstablishment;
    }

    public JTextField getTextBranchWorth() {
        return textBranchWorth;
    }

    public void setTextBranchWorth(JTextField textBranchWorth) {
        this.textBranchWorth = textBranchWorth;
    }

    public JTextField getTextBranchBudget() {
        return textBranchBudget;
    }

    public void setTextBranchBudget(JTextField textBranchBudget) {
        this.textBranchBudget = textBranchBudget;
    }

    public JTextField getTextBranchFirm() {
        return textBranchFirm;
    }

    public void setTextBranchFirm(JTextField textBranchFirm) {
        this.textBranchFirm = textBranchFirm;
    }

    public JList getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(JList listEmployee) {
        this.listEmployee = listEmployee;
    }

    public JList getListFirm() {
        return listFirm;
    }

    public void setListFirm(JList listFirm) {
        this.listFirm = listFirm;
    }

    public JTextField getTextEmployeeName() {
        return textEmployeeName;
    }

    public void setTextEmployeeName(JTextField textEmployeeName) {
        this.textEmployeeName = textEmployeeName;
    }

    public JTextField getTextEmployeeSurname() {
        return textEmployeeSurname;
    }

    public void setTextEmployeeSurname(JTextField textEmployeeSurname) {
        this.textEmployeeSurname = textEmployeeSurname;
    }

    public JTextField getTextEmployeeFatherName() {
        return textEmployeeFatherName;
    }

    public void setTextEmployeeFatherName(JTextField textEmployeeFatherName) {
        this.textEmployeeFatherName = textEmployeeFatherName;
    }

    public JTextField getTextEmployeeMotherName() {
        return textEmployeeMotherName;
    }

    public void setTextEmployeeMotherName(JTextField textEmployeeMotherName) {
        this.textEmployeeMotherName = textEmployeeMotherName;
    }

    public JTextField getTextEmployeeAddress() {
        return textEmployeeAddress;
    }

    public void setTextEmployeeAddress(JTextField textEmployeeAddress) {
        this.textEmployeeAddress = textEmployeeAddress;
    }

    public JTextField getTextEmployeeAge() {
        return textEmployeeAge;
    }

    public void setTextEmployeeAge(JTextField textEmployeeAge) {
        this.textEmployeeAge = textEmployeeAge;
    }

    public JTextField getTextEmployeeCity() {
        return textEmployeeCity;
    }

    public void setTextEmployeeCity(JTextField textEmployeeCity) {
        this.textEmployeeCity = textEmployeeCity;
    }

    public JTextField getTextEmployeeIdentity() {
        return textEmployeeIdentity;
    }

    public void setTextEmployeeIdentity(JTextField textEmployeeIdentity) {
        this.textEmployeeIdentity = textEmployeeIdentity;
    }

    public JTextField getTextEmployeeCountry() {
        return textEmployeeCountry;
    }

    public void setTextEmployeeCountry(JTextField textEmployeeCountry) {
        this.textEmployeeCountry = textEmployeeCountry;
    }

    public JTextField getTextEmployeePostCode() {
        return textEmployeePostCode;
    }

    public void setTextEmployeePostCode(JTextField textEmployeePostCode) {
        this.textEmployeePostCode = textEmployeePostCode;
    }

    public JTextField getTextEmployeeAfm() {
        return textEmployeeAfm;
    }

    public void setTextEmployeeAfm(JTextField textEmployeeAfm) {
        this.textEmployeeAfm = textEmployeeAfm;
    }

    public JTextField getTextEmployeeAmka() {
        return textEmployeeAmka;
    }

    public void setTextEmployeeAmka(JTextField textEmployeeAmka) {
        this.textEmployeeAmka = textEmployeeAmka;
    }

    public JTextField getTextEmployeeBranch() {
        return textEmployeeBranch;
    }

    public void setTextEmployeeBranch(JTextField textEmployeeBranch) {
        this.textEmployeeBranch = textEmployeeBranch;
    }

    public JTextField getTextEmployeeFirm() {
        return textEmployeeFirm;
    }

    public void setTextEmployeeFirm(JTextField textEmployeeFirm) {
        this.textEmployeeFirm = textEmployeeFirm;
    }

    public JTextField getTextBranchCountry() {
        return textBranchCountry;
    }

    public void setTextBranchCountry(JTextField textBranchCountry) {
        this.textBranchCountry = textBranchCountry;
    }

    public JTextField getTextBranchCity() {
        return textBranchCity;
    }

    public void setTextBranchCity(JTextField textBranchCity) {
        this.textBranchCity = textBranchCity;
    }

    public FirmGuiApplication() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if ("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.updateComponentTreeUI(panel);
                    break;
                }
            }
        } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        initializeFirmJScrollPane();
        initializeBranchJScrollPane();
        buttonsFirmPage();
        buttonsBranchPage();
        activeMouseListener();
    }

    private void initializeFirmJScrollPane(){
        InitializerFirmJScrollPane jListFirm = new InitializerFirmJScrollPane(firmJScrollPane);
        setListFirm(jListFirm.getjList());
    }

    private void initializeBranchJScrollPane(){
        InitializerBranchJScrollPane jListBranch = new InitializerBranchJScrollPane(branchJScrollPane);
        setListBranch(jListBranch.getjList());
    }

    private void activeMouseListener() {
        listFirm.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                selectedFirm = (String) listFirm.getSelectedValue();
                System.out.println("Value Selected: " + selectedFirm);
                getSelectedFirmInfo(selectedFirm);
            }
        });

        listBranch.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = 1;
                String s = (String) listBranch.getSelectedValue();
                index += listBranch.getSelectedIndex();
                System.out.println("Value Selected: " + s + " and Index selected: " + index);
                String[] arrOfStr = s.split("--", 3);
                selectedBranch = arrOfStr[0];
                selectedCountry = arrOfStr[1];
                selectedCity = arrOfStr[2];
                getSelectedBranchInfo(selectedBranch, selectedCountry, selectedCity);
                System.out.println(selectedBranch + "  -- " + selectedCountry + " -- " + selectedCity);
            }
        });

        listEmployee.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String s = (String) listEmployee.getSelectedValue();
                System.out.println("Value Selected: " + s);
            }
        });
    }

    private void getSelectedBranchInfo(String name, String country, String city){
        BranchServiceImpl branchService = new BranchServiceImpl();
        Branch branch = branchService.findSelectedBranch(name, country, city);
        DefaultListModel model = new DefaultListModel();
        new JList(model);

        textBranchName.setText(branch.getName());
        textBranchAddress.setText(branch.getAddress());
        textBranchCountry.setText(branch.getCountry());
        textBranchCity.setText(branch.getCity());
        textBranchEstablishment.setText(branch.getEstablishment());
        textBranchWorth.setText(String.format("%,d",(long) branch.getWorth()) +"€");
        textBranchBudget.setText(String.format("%,d",(long) branch.getBudget()) +"€");
        textBranchFirm.setText(String.valueOf(branch.getFirm()));
    }

    private void getSelectedFirmInfo(String name){
        FirmServiceImpl firmService = new FirmServiceImpl();
        List<String> firm = firmService.findSelectedFirm(name);
        DefaultListModel model = new DefaultListModel();
        new JList(model);

        textCountBranches.setText(String.valueOf(firm.get(0)));
        textSumWorth.setText(String.valueOf(firm.get(1)));
        textCountCountries.setText(String.valueOf(firm.get(2)));
    }

    public void buttonsFirmPage(){
        buttonCreateFirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textFirmName.getText();
                System.out.println(text);
                FirmServiceImpl firmService = new FirmServiceImpl();
                firmService.addFirm(text);
                initializeFirmJScrollPane();
                activeMouseListener();
            }
        });

        buttonSearchFirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textFirmName.getText();
                Boolean found = false;
                int foundPosition = -1;
                System.out.println(text);
                for(int i = 0; i < listFirm.getModel().getSize(); i++)
                {
                    if(text.equals(listFirm.getModel().getElementAt(i))){
                        found = true;
                        foundPosition = i;
                        break;
                    }
                }
                if(found && foundPosition != -1 ){
                    System.out.println("Found in position: " + ++foundPosition + " of " + listFirm.getModel().getSize());
                    getSelectedFirmInfo(text);
                }
            }
        });

        buttonDeleteFirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!selectedFirm.equals("")){
                    switch (JOptionPane.showConfirmDialog(buttonDeleteFirm,
                            "Do you want to delete this Firm?", "Delete a Firm",
                            JOptionPane.YES_NO_OPTION)) {
                        case JOptionPane.YES_OPTION:
                            FirmServiceImpl firmService = new FirmServiceImpl();
                            firmService.removeFirm(selectedFirm);
                            initializeFirmJScrollPane();
                            activeMouseListener();
                            break;
                        case JOptionPane.NO_OPTION:
                            break;
                        default:
                            listFirm.clearSelection();
                    }
                }
            }
        });
    }

    public void buttonsBranchPage(){
        buttonCreateBranch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        buttonDeleteBranch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(selectedBranch + "  -- " + selectedCountry + " -- " + selectedCity);
                if(!selectedBranch.equals("")) {
                    switch (JOptionPane.showConfirmDialog(buttonDeleteFirm,
                            "Do you want to delete this Branch?", "Delete a Firm",
                            JOptionPane.YES_NO_OPTION)) {
                        case JOptionPane.YES_OPTION:
                            BranchServiceImpl branchService = new BranchServiceImpl();
                            branchService.removeBranch(selectedBranch, selectedCountry, selectedCity);
                            initializeBranchJScrollPane();
                            activeMouseListener();
                            break;
                        case JOptionPane.NO_OPTION:
                            break;
                        default:
                            listBranch.clearSelection();
                    }
                }
            }
        });

        buttonUpdateBranch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        buttonSearchBranch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


            }
        });

    }
}