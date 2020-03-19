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
    private JTextField textSelectedFirmName;

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
    private JScrollPane FormJScrollPane;
    private JLabel Firm;
    //--------------------Additional-----------------
    //selectedFirm is the selected value from listFirm
    private static String selectedFirm = "";
    //selectedBranch is the selected value from listBranch
    private static String selectedBranch = "";
    private static String selectedCountry = "";
    private static String selectedCity = "";

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JList getListBranch() {
        return listBranch;
    }

    public void setListBranch(JList listBranch) {
        this.listBranch = listBranch;
    }

    public JList getListFirm() {
        return listFirm;
    }

    public void setListFirm(JList listFirm) {
        this.listFirm = listFirm;
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

    public void initializeFirmJScrollPane(){
        InitializerFirmJScrollPane jListFirm = new InitializerFirmJScrollPane(firmJScrollPane);
        setListFirm(jListFirm.getjList());
    }

    public void initializeBranchJScrollPane(){
        InitializerBranchJScrollPane jListBranch = new InitializerBranchJScrollPane(branchJScrollPane);
        setListBranch(jListBranch.getjList());
    }

    public void activeMouseListener() {
        listFirm.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                selectedFirm = (String) listFirm.getSelectedValue();
                textSelectedFirmName.setText(" **** " + selectedFirm + " **** ");
                getSelectedFirmInfo(selectedFirm);
            }
        });

        listBranch.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String s = (String) listBranch.getSelectedValue();
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

    public void getSelectedBranchInfo(String name, String country, String city){
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

    public void getSelectedFirmInfo(String name){
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
                Branch branch = new Branch();

                branch.setName(textBranchName.getText());
                branch.setAddress(textBranchAddress.getText());
                branch.setCity(textBranchCity.getText());
                branch.setCountry(textBranchCountry.getText());
                branch.setEstablishment(textBranchEstablishment.getText());
                branch.setWorth(Double.parseDouble(textBranchWorth.getText()));
                branch.setBudget(Double.parseDouble(textBranchBudget.getText()));

                BranchServiceImpl branchService = new BranchServiceImpl();
                branchService.addBranch(branch);

                initializeBranchJScrollPane();
                activeMouseListener();
            }
        });

        buttonDeleteBranch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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