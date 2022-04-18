package proj_gui2;

import javax.swing.SwingUtilities;

public class Proj_GUI2 {

    public static void main(String[] args) {
//Menu mn;
        
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Menu mn = new Menu();
            }
        });

        //SwingUtilities.invokeLater(()->new Menu());
    }

}
