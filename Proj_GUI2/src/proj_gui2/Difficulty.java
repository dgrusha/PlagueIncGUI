package proj_gui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Difficulty extends JFrame {
    
    private Image backgroundImage;
    
    
    Difficulty(JFrame frameM) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        JButton b1 = new JButton("Hard");
        JButton b2 = new JButton("Medium");
        JButton b3 = new JButton("Easy");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(0,1));
        jPanel.add(b1);
        jPanel.add(b2);
        jPanel.add(b3);
        frame.add(jPanel, BorderLayout.CENTER);
        Image icon = Toolkit.getDefaultToolkit().getImage("VirusIc.png");
        frame.setIconImage(icon);
        //exit button
        try {
            backgroundImage = ImageIO.read(new File("111.png"));
        } catch (IOException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        }
        JButton exit = new JButton(new ImageIcon(backgroundImage));
        exit.setSize(40, 40);
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        exit.setBackground(Color.WHITE);
        top.setBackground(Color.black);
        top.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameM.setVisible(true);
                frame.setVisible(false);
            }
        });
        //butons 
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyCalendar mc = new MyCalendar();
                Thread t = new Thread(mc);
                t.start();
                GameScreen gs = new GameScreen(mc,t, 3);
                setVisible(false);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyCalendar mc = new MyCalendar();
                Thread t = new Thread(mc);
                t.start();
                GameScreen gs2 = new GameScreen(mc,t, 2);
                setVisible(false);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyCalendar mc = new MyCalendar();
                Thread t = new Thread(mc);
                t.start();
                GameScreen gs3 = new GameScreen(mc,t, 1);
                setVisible(false);
            }
        });
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.red);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.red);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.red);
        //setting frame
        frame.add(jPanel, BorderLayout.CENTER);
        frame.add(top, BorderLayout.NORTH);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
