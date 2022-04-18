package proj_gui2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Menu extends JFrame {
    
    public static int vis = 0;
    private Image cImage;
    
    Menu() {
        JFrame frame = new JFrame();
        
        Image icon = Toolkit.getDefaultToolkit().getImage("VirusIc.png");
        frame.setIconImage(icon);
        frame.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel();
        JPanel jPanel2 = new JPanel();
        try {
            cImage = ImageIO.read(new File("virus2.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.add(jPanel);
        JButton b1 = new JButton("New Game");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.red);
        JButton b2 = new JButton("High Score");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.red);
        JButton b3 = new JButton("Exit");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.red);
        jPanel.setLayout(new GridLayout(0, 1));
        jPanel2.setLayout(new BorderLayout());
        jPanel.add(b1);
        jPanel.add(b2);
        jPanel.add(b3);
        frame.add(jPanel, BorderLayout.CENTER);
        frame.add(new JLabel(new ImageIcon(cImage)), BorderLayout.NORTH);
        //add(jPanel2);
        //setting actions
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Difficulty dif = new Difficulty(frame);
                frame.setVisible(false);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    HighScore hs = new HighScore(frame);
                    frame.setVisible(false);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                //setVisible(false);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //getting menu from other tabs
        if(vis == 1){
        frame.setVisible(true);
        }
        //setting frame
        frame.setBackground(Color.BLACK);
        frame.setSize(500, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setVis(int i) {
        if (i == 0) {
            setVisible(false);
        } else if (i == 1) {
            setVisible(true);
        }

    }

}
