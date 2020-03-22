package GUI.Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestButton {

    public TestButton(JButton button, JList list) {
        String buttonType = button.getToolTipText();
        switch (buttonType){
            case "CreateNewBranch" :
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                    }
                });
            case "SearchFirm":



        }

    }

}
