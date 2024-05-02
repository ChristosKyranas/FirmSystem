package service.impl;

import repository.FirmRepository;
import service.InitializionJScrollPaneService;

import javax.swing.*;
import java.util.List;

public class InitializerFirmJScrollPane extends InitializionJScrollPaneService {

    private JList jList;
    private DefaultListModel model;
    private FirmRepository firmService;
    private List<String> firm;

    public InitializerFirmJScrollPane(JScrollPane jScrollPane) {

        firmService = new FirmRepository();
        firm = firmService.getAllFirms();
        model = new DefaultListModel();
        jList = new JList(model);

        for (String e : firm){
            model.addElement(e);
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
