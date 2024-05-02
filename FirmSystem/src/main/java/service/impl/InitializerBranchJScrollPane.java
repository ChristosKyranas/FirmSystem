package service.impl;

import model.Branch;
import repository.BranchRepository;
import service.InitializionJScrollPaneService;

import javax.swing.*;
import java.util.List;

public class InitializerBranchJScrollPane extends InitializionJScrollPaneService {

    private JList jList;
    private DefaultListModel model;
    private BranchRepository branchService;
    //private HashMap<Integer, Branch> branch;
    private List<Branch> branch;

    public InitializerBranchJScrollPane(JScrollPane jScrollPane) {

        branchService = new BranchRepository();
        branch = branchService.getAllBranch();
        model = new DefaultListModel();
        jList = new JList(model);
        /*for ( int i : branch.keySet()){
            model.addElement(branch.get(i).getName() + "--" + branch.get(i).getCountry() + "--" + branch.get(i).getCity());

        }*/
        for (Branch e : branch){
            model.addElement(e.getName() + "--" + e.getCountry() + "--" + e.getCity());
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
