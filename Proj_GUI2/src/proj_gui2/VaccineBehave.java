
package proj_gui2;

import java.util.logging.Level;
import java.util.logging.Logger;


public class VaccineBehave implements Runnable {
    
    private int dif;
    private int up1 = 0;
    private int up2 = 0;
    public static double progres = 0;
    public static double rise = 0.000001;
    

    @Override
    public void run() {
        while(progres <101 || !Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(1000);
                this.progres = this.progres + rise;
                if (progres > 100) {
                    progres = 100;
                }
            } catch (InterruptedException ex) {
                return;
            }
        }
    }
    
    public void addUp1(){
     this.up1 = this.up1 + 1;
    }
    
    public void addUp2(){
     this.up2 = this.up2 + 1;
    }

    public double getProgres() {
        return progres;
    }

    public double getRise() {
        return rise;
    }

    public void setRise(double rise) {
        this.rise = rise;
    }
    
    
}
