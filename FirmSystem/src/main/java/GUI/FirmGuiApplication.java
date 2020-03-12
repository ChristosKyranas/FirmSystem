package GUI;

import GUI.Buttons.CreateBranch;
import models.Branch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

    public JList getListFirm() {
        return listFirm;
    }

    public void setListFirm(JList listFirm) {
        this.listFirm = listFirm;
    }

    public JTextField getTextFirmName() {
        return textFirmName;
    }

    public void setTextFirmName(JTextField textFirmName) {
        this.textFirmName = textFirmName;
    }

    public JButton getButtonSearchFirm() {
        return buttonSearchFirm;
    }

    public void setButtonSearchFirm(JButton buttonSearchFirm) {
        this.buttonSearchFirm = buttonSearchFirm;
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

    public JButton getButtonCreateBranch() {
        return buttonCreateBranch;
    }

    public void setButtonCreateBranch(JButton buttonCreateBranch) {
        this.buttonCreateBranch = buttonCreateBranch;
    }

    public JButton getButtonUpdateBranch() {
        return buttonUpdateBranch;
    }

    public void setButtonUpdateBranch(JButton buttonUpdateBranch) {
        this.buttonUpdateBranch = buttonUpdateBranch;
    }

    public JButton getButtonSearchBranch() {
        return buttonSearchBranch;
    }

    public void setButtonSearchBranch(JButton buttonSearchBranch) {
        this.buttonSearchBranch = buttonSearchBranch;
    }

    public JButton getButtonCreateFirm() {
        return buttonCreateFirm;
    }

    public void setButtonCreateFirm(JButton buttonCreateFirm) {
        this.buttonCreateFirm = buttonCreateFirm;
    }

    public JButton getButtonSearchEmployee() {
        return buttonSearchEmployee;
    }

    public void setButtonSearchEmployee(JButton buttonSearchEmployee) {
        this.buttonSearchEmployee = buttonSearchEmployee;
    }

    public JButton getButtonDeleteBranch() {
        return buttonDeleteBranch;
    }

    public void setButtonDeleteBranch(JButton buttonDeleteBranch) {
        this.buttonDeleteBranch = buttonDeleteBranch;
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

    public JButton getButtonDeleteFirm() {
        return buttonDeleteFirm;
    }

    public void setButtonDeleteFirm(JButton buttonDeleteFirm) {
        this.buttonDeleteFirm = buttonDeleteFirm;
    }

    public JList getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(JList listEmployee) {
        this.listEmployee = listEmployee;
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

    public JButton getButtonCreateEmployee() {
        return buttonCreateEmployee;
    }

    public void setButtonCreateEmployee(JButton buttonCreateEmployee) {
        this.buttonCreateEmployee = buttonCreateEmployee;
    }

    public JButton getButtonUpdateEmployee() {
        return buttonUpdateEmployee;
    }

    public void setButtonUpdateEmployee(JButton buttonUpdateEmployee) {
        this.buttonUpdateEmployee = buttonUpdateEmployee;
    }

    public JButton getButtonDeleteEmployee() {
        return buttonDeleteEmployee;
    }

    public void setButtonDeleteEmployee(JButton buttonDeleteEmployee) {
        this.buttonDeleteEmployee = buttonDeleteEmployee;
    }

    public FirmGuiApplication() {
        buttonsFirmPage();
        buttonsBranchPage();
    }

    public void buttonsFirmPage(){

        buttonCreateFirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textFirmName.getText();
                System.out.println(text);
            }
        });

        buttonDeleteFirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textFirmName.getText();
                System.out.println(text);
            }
        });

        buttonSearchFirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textFirmName.getText();
                System.out.println(text);
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
                branch.setWorth(parseInt(textBranchWorth.getText()));
                branch.setBudget(parseInt(textBranchBudget.getText()));
                branch.setFirm(textBranchFirm.getText());

                branch.setListBranch();
                List<Branch> branchList = branch.getListBranch();
                branchList.add(branch);

                System.out.println(branch.toString());
                System.out.println(branchList.toString());
            }
        });

        buttonDeleteBranch.addActionListener(new ActionListener() {
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