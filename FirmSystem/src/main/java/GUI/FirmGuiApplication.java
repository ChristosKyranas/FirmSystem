package GUI;

import GUI.initializer.InitializerBranchJScrollPane;
import GUI.initializer.InitializerEmployeeJScrollPane;
import GUI.initializer.InitializerFirmJScrollPane;
import domain.Branch;
import domain.PersonalInfo;
import service.BranchServiceImpl;
import service.EmployeeServiceImpl;
import service.FirmServiceImpl;
import service.PersonalInfoServiceImpl;

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
    private static String selectedBranchName = "";
    private static String selectedBranchCountry = "";
    private static String selectedBranchCity = "";
    //selectedEmployee is the selected value from listEmployee
    private static String selectedEmployeeName = "";
    private static String selectedEmployeeSurName = "";
    private static String selectedEmployeeFatherName = "";
    private static String selectedEmployeeBranch = "";

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

    public JList getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(JList listEmployee) {
        this.listEmployee = listEmployee;
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
        initializeEmployeeJScrollPane();
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

    public void initializeEmployeeJScrollPane(){
        InitializerEmployeeJScrollPane jListBranch = new InitializerEmployeeJScrollPane(employeeJScrollPane);
        setListEmployee(jListBranch.getjList());
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
                selectedBranchName = arrOfStr[0];
                selectedBranchCountry = arrOfStr[1];
                selectedBranchCity = arrOfStr[2];
                getSelectedBranchInfo(selectedBranchName, selectedBranchCountry, selectedBranchCity);
            }
        });

        listEmployee.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String s = (String) listEmployee.getSelectedValue();
                String[] arrOfStr = s.split("--", 4);
                selectedEmployeeName = arrOfStr[0];
                selectedEmployeeSurName = arrOfStr[1];
                selectedEmployeeFatherName = arrOfStr[2];
                selectedEmployeeBranch = arrOfStr[3];
                getSelectedEmployeeInfo();
            }
        });
    }

    public void getSelectedEmployeeInfo(){
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        int id = 0;
        id = employeeService.findSelectedEmployee(selectedEmployeeName,
                selectedEmployeeSurName,
                selectedEmployeeFatherName,
                selectedEmployeeBranch);

        PersonalInfoServiceImpl personalInfoService = new PersonalInfoServiceImpl();
        PersonalInfo personalInfo = personalInfoService.findSelectedPersonalInfo(id);

        DefaultListModel model = new DefaultListModel();
        new JList(model);

        textEmployeeName.setText(personalInfo.getName());
        textEmployeeSurname.setText(personalInfo.getSurName());
        textEmployeeFatherName.setText(personalInfo.getFatherName());
        textEmployeeMotherName.setText(personalInfo.getMotherName());
        textEmployeeIdentity.setText(personalInfo.getId());
        textEmployeeAfm.setText(String.valueOf(personalInfo.getAfm()));
        textEmployeeAmka.setText(String.valueOf(personalInfo.getAmka()));
        textEmployeeAddress.setText(personalInfo.getAddress());
        textEmployeeAge.setText(String.valueOf(personalInfo.getAge()));
        textEmployeeCity.setText(personalInfo.getCity());
        textEmployeeCountry.setText(personalInfo.getCountry());
        textEmployeePostCode.setText(String.valueOf(personalInfo.getPostCode()));

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
                    switch (JOptionPane.showConfirmDialog(buttonDeleteFirm,"Do you want to delete this Firm?", "Delete a Firm", JOptionPane.YES_NO_OPTION)) {
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
                //return firm_id depend on name
                branch.setFirm(Integer.parseInt(textBranchFirm.getText()));

                BranchServiceImpl branchService = new BranchServiceImpl();
                branchService.addBranch(branch);

                initializeBranchJScrollPane();
                activeMouseListener();
            }
        });

        buttonDeleteBranch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!selectedBranchName.equals("")) {
                    switch (JOptionPane.showConfirmDialog(buttonDeleteFirm,
                            "Do you want to delete this Branch?", "Delete a Firm",
                            JOptionPane.YES_NO_OPTION)) {
                        case JOptionPane.YES_OPTION:
                            BranchServiceImpl branchService = new BranchServiceImpl();
                            branchService.removeBranch(selectedBranchName, selectedBranchCountry, selectedBranchCity);
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