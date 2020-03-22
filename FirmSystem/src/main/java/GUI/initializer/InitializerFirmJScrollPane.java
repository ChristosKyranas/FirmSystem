package GUI.initializer;

import service.FirmServiceImpl;

import javax.swing.*;
import java.util.List;

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
    //private HashMap<Integer, String> firm;
    private List<String> firm;

    public InitializerFirmJScrollPane(JScrollPane jScrollPane) {

        firmService = new FirmServiceImpl();
        firm = firmService.findAllFirm();
        model = new DefaultListModel();
        jList = new JList(model);

        /*for ( int i : firm.keySet() ){
            model.addElement(firm.get(i));
        }
*/
        for (String e : firm){
            model.addElement(e);
        }
        jScrollPane.setViewportView(jList);
    }



}
