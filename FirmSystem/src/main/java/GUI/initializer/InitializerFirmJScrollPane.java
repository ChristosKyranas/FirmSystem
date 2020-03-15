package GUI.initializer;

import service.FirmServiceImpl;

import javax.swing.*;
import java.util.HashMap;

public class InitializerFirmJScrollPane {

    public JList getjList() {
        return jList;
    }

    public void setjList(JList jList) {
        this.jList = jList;
    }

    private JList jList;
    private DefaultListModel model;
    private FirmServiceImpl firmService;
    private HashMap<Integer, String> firm;

    public InitializerFirmJScrollPane(JScrollPane jScrollPane) {

        firmService = new FirmServiceImpl();
        firm = firmService.findAllFirm();
        model = new DefaultListModel();
        jList = new JList(model);

        for ( int i : firm.keySet() ){
            model.addElement(firm.get(i));
        }

        jScrollPane.setViewportView(jList);
    }



}
