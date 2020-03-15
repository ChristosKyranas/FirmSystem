package GUI;

import GUI.initializer.InitializerBranchJScrollPane;
import GUI.initializer.InitializerFirmJScrollPane;
import domain.Branch;
import domain.Firm;
import factory.InitializerJScrollPaneFactory;
import service.BranchServiceImpl;
import service.FirmServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import static java.lang.Integer.parseInt;

public class FirmGuiApplication {
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    private JList listFirm;
    private JList listBranch;
    private JList listEmployee;
    private JButton buttonSearchFirm;
    private JButton buttonCreateBranch;
    private JButton buttonUpdateBranch;
    private JButton buttonSearchBranch;
    private JButton buttonCreateFirm;
    private JButton buttonSearchEmployee;
    private JButton buttonDeleteBranch;
    private JButton buttonDeleteFirm;
    private JButton buttonCreateEmployee;
    private JButton buttonUpdateEmployee;
    private JButton buttonDeleteEmployee;
    private JTextField textFirmName;
    private JTextField textBranchName;
    private JTextField textBranchAddress;
    private JTextField textBranchEstablishment;
    private JTextField textBranchWorth;
    private JTextField textBranchBudget;
    private JTextField textBranchFirm;
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
    private JScrollPane firmJScrollPane;
    private JScrollPane branchJScrollPane;
    private JScrollPane employeeJScrollPane;

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

    public FirmGuiApplication() {
        initializeJSrollPane();
        buttonsFirmPage();
        buttonsBranchPage();
        activeMouseListener();
    }

    private void activeMouseListener() {

        listFirm.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String s = (String) listFirm.getSelectedValue();
                System.out.println("Value Selected: " + s);

                buttonDeleteFirm.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        FirmServiceImpl firmService = new FirmServiceImpl();
                        firmService.removeFirm(s);
                        InitializerFirmJScrollPane jListFirm = new InitializerFirmJScrollPane(firmJScrollPane);
                        setListFirm(jListFirm.getjList());
                        activeMouseListener();
                    }
                });
            }
        });

        listBranch.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                String s = (String) listBranch.getSelectedValue();
                System.out.println("Value Selected: " + s);
                getSelectedInfo(s);

                buttonDeleteBranch.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        BranchServiceImpl branchService = new BranchServiceImpl();
                        branchService.removeBranch(s);
                        InitializerBranchJScrollPane jListBranch = new InitializerBranchJScrollPane(branchJScrollPane);
                        setListBranch(jListBranch.getjList());
                    }
                });

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

    private void getSelectedInfo(String s){
        BranchServiceImpl branchService = new BranchServiceImpl();
        Branch branch = branchService.findSelectedBranch(s);
        DefaultListModel model = new DefaultListModel();
        JList jList = new JList(model);

        textBranchName.setText(branch.getName());
        textBranchAddress.setText(branch.getAddress());
        textBranchEstablishment.setText(branch.getEstablishment());
        textBranchWorth.setText(String.valueOf((long) branch.getWorth()));
        textBranchBudget.setText(String.valueOf((long) branch.getBudget()));
        textBranchFirm.setText(String.valueOf(branch.getFirm()));
    }

    private void initializeJSrollPane() {

//        new InitializerJScrollPaneFactory("firm", firmJScrollPane);
//
//        new InitializerJScrollPaneFactory("branch", branchJScrollPane);

        InitializerFirmJScrollPane jListFirm = new InitializerFirmJScrollPane(firmJScrollPane);
        setListFirm(jListFirm.getjList());
        InitializerBranchJScrollPane jListBranch = new InitializerBranchJScrollPane(branchJScrollPane);
        setListBranch(jListBranch.getjList());

    }

    public void buttonsFirmPage(){

        buttonCreateFirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textFirmName.getText();
                System.out.println(text);
                FirmServiceImpl firmService = new FirmServiceImpl();
                firmService.addFirm(text);
                InitializerFirmJScrollPane jListFirm = new InitializerFirmJScrollPane(firmJScrollPane);
                setListFirm(jListFirm.getjList());
                activeMouseListener();
            }
        });



        buttonSearchFirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


            }
        });
    }

    public void buttonsBranchPage(){

        buttonCreateBranch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//
                //i could add them as parameter in Branch;s constructor//
                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//
                Branch branch = new Branch();
                branch.setName(textBranchName.getText());
                branch.setAddress(textBranchAddress.getText());
                branch.setEstablishment(textBranchEstablishment.getText());
                branch.setWorth(Double.valueOf(textBranchWorth.getText()));
                branch.setBudget(Double.valueOf(textBranchBudget.getText()));
                branch.setFirm(Integer.parseInt(textBranchFirm.getText()));

                branch.setListBranch();
                List<Branch> branchList = branch.getListBranch();
                branchList.add(branch);

                System.out.println(branch.toString());
                System.out.println(branchList.toString());
            }
        });



        buttonUpdateBranch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(textBranchName.getText() + "\n"
                        + textBranchAddress.getText()       + "\n"
                        + textBranchEstablishment.getText() + "\n"
                        + textBranchWorth.getText()         + "\n"
                        + textBranchBudget.getText()        + "\n"
                        + textBranchFirm.getText());
            }
        });

        buttonSearchBranch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(textBranchName.getText() + "\n"
                        + textBranchAddress.getText()       + "\n"
                        + textBranchEstablishment.getText() + "\n"
                        + textBranchWorth.getText()         + "\n"
                        + textBranchBudget.getText()        + "\n"
                        + textBranchFirm.getText());
            }
        });
    }


}