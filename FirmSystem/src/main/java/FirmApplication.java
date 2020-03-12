import GUI.FirmGuiApplication;

import javax.swing.*;

public class FirmApplication {

    public static void main(String[] args) {
        JFrame frame = new JFrame("FirmApplication");
        frame.setContentPane(new FirmGuiApplication().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
