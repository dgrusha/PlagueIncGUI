package proj_gui2;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CountryPane extends JFrame{
    
    CountryPane(ArrayList<JButton> Cbut){
    JPanel cP = new JPanel(new GridLayout(2,1));
        for (int i = 0; i < Cbut.size(); i++) {
            cP.add(Cbut.get(i));
        }
    add(cP);
    setSize(500, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    }
    
}
