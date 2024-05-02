package service.impl;

import model.Branch;
import model.Employee;
//import domain.PersonalInfo;
import repository.BranchRepository;
import repository.EmployeeRepository;
import service.InitializionJScrollPaneService;
//import service.PersonalInfoServiceImpl;

import javax.swing.*;
import java.util.List;

public class InitializerEmployeeJScrollPane extends InitializionJScrollPaneService {

    private JList jList;
    private DefaultListModel model;
    private EmployeeRepository employeeService;
//    private PersonalInfoServiceImpl personalInfoService;
    private BranchRepository branchService;
    private List<Employee> employee;
//    private PersonalInfo personalInfo;
    private Branch branch;

    public InitializerEmployeeJScrollPane(JScrollPane jScrollPane) {
        //fetch all the employees from the database
        employeeService = new EmployeeRepository();
        employee = employeeService.findAllEmployee();

//        personalInfoService = new PersonalInfoServiceImpl();
        branchService = new BranchRepository();

        model = new DefaultListModel();
        jList = new JList(model);

        //fetch "personal info" && "branch" from database for every employee to display
//        for (Employee e: employee){
//            personalInfo = personalInfoService.findSelectedPersonalInfo(e.getEmployeeId());
//            branch = branchService.findSelectedBranch(e.getBranch());
//            model.addElement(personalInfo.getName() + "--" + personalInfo.getSurName() + "--" + personalInfo.getFatherName() + "--" +  branch.getName());
//        }
        jScrollPane.setViewportView(jList);
    }

    public JList getjList() {
        return jList;
    }

    public void setjList(JList jList) {
        this.jList = jList;
    }
}