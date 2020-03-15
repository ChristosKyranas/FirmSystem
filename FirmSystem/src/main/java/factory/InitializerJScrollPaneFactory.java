package factory;

import GUI.initializer.InitializerBranchJScrollPane;
import GUI.initializer.InitializerFirmJScrollPane;

import javax.swing.*;

public class InitializerJScrollPaneFactory {

    private static final String FIRM = "firm";
    private static final String BRANCH = "branch";

    public InitializerJScrollPaneFactory(String typeInitializer, JScrollPane jScrollPane) {

        switch (typeInitializer){
            case FIRM:
                InitializerFirmJScrollPane initializerFirm = new InitializerFirmJScrollPane(jScrollPane);
                break;
            case BRANCH:
                new InitializerBranchJScrollPane(jScrollPane);
                break;
            default:
                System.out.println("nothing initialized");
        }

        /*if (typeInitializer.equals(FIRM)){
            new InitializerFirmJScrollPane(jScrollPane);
        }
        else if (typeInitializer.equals(BRANCH)){
            new InitializerBranchJScrollPane(jScrollPane);
        }*/
    }



}
