package GUI.initializer;

import domain.Branch;
import service.BranchServiceImpl;

import javax.swing.*;
import java.util.HashMap;

public class InitializerBranchJScrollPane {

    private JList jList;
    private DefaultListModel model;
    private BranchServiceImpl branchService;
    private HashMap<Integer, Branch> branch;

    public InitializerBranchJScrollPane(JScrollPane jScrollPane) {

        branchService = new BranchServiceImpl();
        branch = branchService.findAllBranch();
        model = new DefaultListModel();
        jList = new JList(model);
        for ( int i : branch.keySet()){
            model.addElement(branch.get(i).getName() + "--" + branch.get(i).getCountry() + "--" + branch.get(i).getCity());
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
