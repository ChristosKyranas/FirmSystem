package GUI.Dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateMessageGui {


    public CreateMessageGui(JScrollPane branchJScrollPane, String test) {

        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);
        JButton button = new JButton("Click Me!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(branchJScrollPane, "Welcome to Swing!");
            }
        });

        panel.add(button);
//        branchJScrollPane.getContentPane().add(panel, BorderLayout.CENTER);
    }

}
