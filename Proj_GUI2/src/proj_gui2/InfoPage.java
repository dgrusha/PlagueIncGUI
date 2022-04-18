/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_gui2;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dima
 */
public class InfoPage extends JFrame {

    public InfoPage(ArrayList<JLabel> LCountry) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(0,1));
        for (int i = 0; i < LCountry.size(); i++) {
            jPanel.add(LCountry.get(i));
        }
        add(jPanel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    
    
}
