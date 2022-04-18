
package proj_gui2;

import java.util.ArrayList;
import javax.swing.JLabel;


public class Roots {
    
   private ArrayList<Thread> animations;

    public Roots(JLabel map, ArrayList<Country> country) {
        animations = new ArrayList<Thread>();
        // mong russia bus
        RouteAnimation ra1 = new RouteAnimation(400, 300, 475, 390, 1, map, country.get(1), country.get(2));
        Thread tr1 = new Thread(ra1);
        animations.add(tr1);
        tr1.start();
        //Plane korea mong
        RouteAnimation ra2 = new RouteAnimation(475, 390, 620, 400, 3, map
                , country.get(1), country.get(3));
        Thread tr2 = new Thread(ra2);
        animations.add(tr2);
        tr2.start();
        // russia afgan plane
        RouteAnimation ra3 = new RouteAnimation(185, 460, 400, 300, 3, map
                , country.get(2), country.get(8));
        Thread tr3 = new Thread(ra3);
        animations.add(tr3);
        tr3.start();
        //russia china bus
        RouteAnimation ra4 = new RouteAnimation(475, 500, 400, 300, 1, map
                , country.get(2), country.get(8));
        Thread tr4 = new Thread(ra4);
        animations.add(tr4);
        tr4.start();
        //russia india plane
        RouteAnimation ra5 = new RouteAnimation(330, 580, 400, 300, 3, map
                , country.get(2), country.get(8));
        Thread tr5 = new Thread(ra5);
        animations.add(tr5);
        tr5.start();
        // mong china bus
        RouteAnimation ra6 = new RouteAnimation(475, 500, 475, 390, 1, map, country.get(1), country.get(2));
        Thread tr6 = new Thread(ra6);
        animations.add(tr6);
        tr6.start();
        // mong china bus
        RouteAnimation ra7 = new RouteAnimation(475, 500, 330, 580, 1, map, country.get(1), country.get(2));
        Thread tr7 = new Thread(ra7);
        animations.add(tr7);
        tr7.start();
        //philip ind boat
        RouteAnimation ra8 = new RouteAnimation(550, 765,675, 600, 2, map, country.get(1), country.get(2));
        Thread tr8 = new Thread(ra8);
        animations.add(tr8);
        tr8.start();
        //philip myanma boat
        RouteAnimation ra9 = new RouteAnimation(450, 600,675, 600, 2, map, country.get(1), country.get(2));
        Thread tr9 = new Thread(ra9);
        animations.add(tr9);
        tr9.start();
    }
    
    
    public void endThreads(){
        for (int i = 0; i < animations.size(); i++) {
            animations.get(i).interrupt();
        }
    }
    
}
