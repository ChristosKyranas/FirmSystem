package GUI.initializer;

import domain.Branch;
import domain.Employee;
import domain.PersonalInfo;
import service.BranchServiceImpl;
import service.EmployeeServiceImpl;
import service.PersonalInfoServiceImpl;

import javax.swing.*;
import java.util.List;

public class InitializerEmployeeJScrollPane {

    private JList jList;
    private DefaultListModel model;
    private EmployeeServiceImpl employeeService;
    private PersonalInfoServiceImpl personalInfoService;
    private BranchServiceImpl branchService;
    private List<Employee> employee;
    private PersonalInfo personalInfo;
    private Branch branch;

    public InitializerEmployeeJScrollPane(JScrollPane jScrollPane) {
        //fetch all the employees from the database
        employeeService = new EmployeeServiceImpl();
        employee = employeeService.findAllEmployee();

        personalInfoService = new PersonalInfoServiceImpl();
        branchService = new BranchServiceImpl();

        model = new DefaultListModel();
        jList = new JList(model);

        //fetch "personal info" && "branch" from database for every employee to display
        for (Employee e: employee){
            personalInfo = personalInfoService.findSelectedPersonalInfo(e.getEmployeeId());
            branch = branchService.findSelectedBranch(e.getBranch());
            model.addElement(personalInfo.getName() + "--" + personalInfo.getSurName() + "--" + personalInfo.getFatherName() + "--" +  branch.getName());
        }
        jScrollPane.setViewportView(jList);
    }

    public JList getjList() {
        return jList;
    }

    public void setjList(JList jList) {
        this.jList = jList;
    }
}