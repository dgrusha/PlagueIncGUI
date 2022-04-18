/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_gui2;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Dima
 */
public class RouteAnimation implements Runnable {

    private Image busIm;
    private Image planeIm;
    private Image boatIm;
    private JLabel trans;
    private JLabel map;
    private int x1 = 0;
    private int y1 = 0;
    private int y2 = 0;
    private int x2 = 0;
    private int choice;
    private Country c1;
    private Country c2;

    public RouteAnimation(int x1, int y1, int x2, int y2, int choice, JLabel map, Country c1, Country c2) {
        try {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.c1 = c1;
            this.c2 = c2;
            this.choice = choice;
            this.map = map;
            this.boatIm = ImageIO.read(new File("Ship-2-icon.png"));
            this.planeIm = ImageIO.read(new File("plane-icon.png"));
            this.busIm = ImageIO.read(new File("bus.png"));
            if (choice == 1) {
                trans = new JLabel(new ImageIcon(this.busIm));
            }
            if (choice == 2) {
                trans = new JLabel(new ImageIcon(this.boatIm));
            }
            if (choice == 3) {
                trans = new JLabel(new ImageIcon(this.planeIm));
            }
            trans.setBounds(this.x1, this.y1, 50, 50);
        } catch (IOException e) {
        }

    }

    @Override
    public void run() {
        this.map.add(this.trans);
        if (this.choice == 1) {
            while (c1.isLand() == true && c2.isLand() == true || !Thread.currentThread().isInterrupted()) {
                double dx = x1, dy = y1;
                for (int i = 0; i < 20; i++) {
                    trans.setBounds((int)dx, (int)dy, 50, 50);
                    dx += (double)((x2 - x1 )/ 20);
                    dy += (double)((y2 - y1) / 20);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                      return;
                    }
                    
                }
                dx = x2;
                dy = y2;
                for (int i = 0; i < 20; i++) {
                    trans.setBounds((int)dx, (int)dy, 50, 50);
                    dx += (double)((x1 - x2 )/ 20);
                    dy += (double)((y1 - y2) / 20);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                      return;
                    }
                    
                }

            }
        }
        if (this.choice == 2) {
            while (c1.isBoat() == true && c2.isBoat() == true || !Thread.currentThread().isInterrupted()) {
                double dx = x1, dy = y1;
                for (int i = 0; i < 10; i++) {
                    trans.setBounds((int)dx, (int)dy, 50, 50);
                    dx += (double)((x2 - x1 )/ 10);
                    dy += (double)((y2 - y1) / 10);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                      return;
                    }
                    
                }
                dx = x2;
                dy = y2;
                for (int i = 0; i < 10; i++) {
                    trans.setBounds((int)dx, (int)dy, 50, 50);
                    dx += (double)((x1 - x2 )/ 10);
                    dy += (double)((y1 - y2) / 10);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                      return;
                    }
                    
                }


            }
        }
        if (this.choice == 3) {
            while (c1.isAir() == true && c2.isAir() == true || !Thread.currentThread().isInterrupted()) {
                double dx = x1, dy = y1;
                for (int i = 0; i < 10; i++) {
                    trans.setBounds((int)dx, (int)dy, 50, 50);
                    dx += (double)((x2 - x1 )/ 10);
                    dy += (double)((y2 - y1) / 10);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                      return;
                    }
                    
                }
                dx = x2;
                dy = y2;
                for (int i = 0; i < 10; i++) {
                    trans.setBounds((int)dx, (int)dy, 50, 50);
                    dx += (double)((x1 - x2 )/ 10);
                    dy += (double)((y1 - y2) / 10);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                      return;
                    }
                    
                }


            }
        }
    }

}
