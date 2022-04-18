
package proj_gui2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HighScore extends JFrame implements Serializable{
    
    private ArrayList<Score> scoreList;
    private JFrame menu;
    private Image backgroundImage;
    
    HighScore(JFrame menu) throws ClassNotFoundException{
        this.menu = menu;
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
        
        this.scoreList = new ArrayList<Score>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HighScore.txt")))
        {
            scoreList = (ArrayList<Score>) ois.readObject();
        } 
        catch (Exception ioe) 
        {
            ioe.printStackTrace();
            return;
        } 
        Collections.sort(scoreList);
        HighScoreListModel hslm = new HighScoreListModel(scoreList);
//        String scoreArray[] = new String[scoreList.size()];
//        for (int i = 0; i < scoreList.size(); i++) {
//            scoreArray[i] = scoreList.get(i).toString();
//        }
        JFrame frame = new JFrame();
        
        frame.setLayout(new BorderLayout());
        JList Jls = new JList(hslm);
        
        JScrollPane Jsc = new JScrollPane(Jls,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //Jsc.add(Jls);
        frame.add(Jsc, BorderLayout.CENTER);
        frame.add(top, BorderLayout.NORTH);
        frame.setSize(350, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
    
//    public static void addScore(Score sc, HighScore hs){
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("HighScore.txt"))){
//            hs = (HighScore) ois.readObject();
//            if (!hs.ifExist(sc)) {
//                hs.adding(sc);
//            }
//        } catch (Exception e) {
//            hs.adding(sc);
//        }
//        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("HighScore.txt"))){
//            ous.writeObject(hs);
//        } catch (Exception e) {
//        }
//    }
    
//    public static ArrayList<Score> loadScore(){
//    
//        return null;
//    }
//    
//    public void adding(Score sc){
//        scoreList.add(sc);
//    }
//
//    public ArrayList<Score> getScoreList() {
//        return scoreList;
//    }
//    
//    public boolean ifExist(Score sc){
//        return this.scoreList.stream().anyMatch((a)->a.getName()
//                .equalsIgnoreCase(sc.getName()) 
//                && a.getPoints() == sc.getPoints());
//    }
}
