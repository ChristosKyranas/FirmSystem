package GUI.Buttons;

import java.util.ArrayList;
import java.util.List;

public class DeleteBranch {

    public DeleteBranch(Object elementAt) {
        List<String> branch = new ArrayList<>();
//        System.out.println(elementAt.toString());

        branch.add((String) elementAt);
        System.out.println(branch.toString());
    }
}
