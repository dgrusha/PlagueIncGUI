
package proj_gui2;

import java.util.ArrayList;
import java.util.Date;


public class MyCalendar implements Runnable {

    private Date curentDate = new Date();
    private static int dayCounter = 0;
    
    

    public MyCalendar() {
        
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                long l = curentDate.getTime();
                curentDate.setTime(l + 86400000);
                dayCounter = dayCounter + 1;
              
            } catch (InterruptedException ex) {
                return;
            }

        }
    }

    public Date getCurentDate() {
        return curentDate;
    }

}
