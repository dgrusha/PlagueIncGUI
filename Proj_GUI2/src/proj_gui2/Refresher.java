package proj_gui2;

import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;

public class Refresher implements Runnable {
    public static long points = 1000;
    public static int country_stat = 0;
    private JLabel label_date;
    private JLabel label_inf;
    private JLabel label_norm;
    private JLabel c_name_inf;
    private JLabel c_name_cases;
    private JLabel c_name_norm;
    private JLabel c_flag_pic;
    private JLabel c_name;
    private JLabel vac;
    private JButton fin;
    private MyCalendar mc;
    private JProgressBar progressBar;
    
    private GameProc gp;
    private ArrayList<JLabel> LCountry;
    private ArrayList<JButton> Bcountry;
    JFrame frame;
    JSplitPane jSplitPane;
    
    private int temp = 100;
    
    

    public Refresher(JLabel label, MyCalendar mc, JLabel label2, GameProc gp, 
            JLabel norm, ArrayList<JLabel> LCountry,  ArrayList<JButton> Bcountry, JFrame frame,
            JSplitPane jSplitPane, JLabel c_name_inf, JLabel c_name_cases,
            JLabel c_name_norm, JLabel flag, JLabel c_name, JLabel vac, JButton fin,
            JProgressBar progressBar) {
        this.progressBar = progressBar;
        this.label_date = label;
        this.fin = fin;
        this.label_inf = label2;
        this.label_norm = norm;
        this.c_name_cases = c_name_cases;
        this.c_name_inf = c_name_inf;
        this.c_name_norm = c_name_norm;
        this.c_flag_pic = flag;
        this.c_name = c_name;
        this.vac = vac;
        this.LCountry = LCountry;
        this.Bcountry = Bcountry;
        this.mc = mc;
        this.gp = gp;
        this.frame = frame;
        this.jSplitPane = jSplitPane;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(500);
                if (gp.getCases()-temp>0) {
                    temp= temp+100;
                    Refresher.points = Refresher.points + 1;
                }
                
                label_date.setText(mc.getCurentDate().toString());
                label_inf.setText("| Number of infected is " + gp.getInfected());
                label_norm.setText("| Number of immune people is " + gp.getNormal() + "| Points available are: " + Refresher.points);
                for (int i = 0; i < LCountry.size(); i++) {
                    LCountry.get(i).setText("Country is : "
                            + gp.getCountry().get(i).getName()
                            + ", number of infected is: "
                            + gp.getCountry().get(i).getInfected()
                            + ", number of normal is: "
                            + gp.getCountry().get(i).getNorm());
                }
                this.c_flag_pic.setIcon(new ImageIcon(gp.getCountry().get(country_stat).getcImage()));
                this.c_name.setText(gp.getCountry().get(country_stat).getName());
                this.c_name_inf.setText("Amount of infected: " + gp.getCountry().get(country_stat).getInfected());
                this.c_name_cases.setText("Amount of cases: " + gp.getCountry().get(country_stat).getCases());
                this.c_name_norm.setText("Amount of non infected: " + gp.getCountry().get(country_stat).getNorm());
                progressBar.setValue((int)VaccineBehave.progres);
                this.vac.setText("Vaccine done: " + (int)VaccineBehave.progres + "%");
                
                if (gp.getCountry().get(country_stat).isUp1(0) == true || points < 15) {
                    this.Bcountry.get(0).setEnabled(false);
                }else{
                    this.Bcountry.get(0).setEnabled(true);
                }
                if (gp.getCountry().get(country_stat).isUp1(1) == true || points < 20) {
                    this.Bcountry.get(1).setEnabled(false);
                }else{
                    this.Bcountry.get(1).setEnabled(true);
                }
                if (gp.getCountry().get(country_stat).isUp1(2) == true || points < 30) {
                    this.Bcountry.get(2).setEnabled(false);
                }else{
                    this.Bcountry.get(2).setEnabled(true);
                }
                if (gp.getCountry().get(country_stat).isUp1(3) == true || points < 30) {
                    this.Bcountry.get(3).setEnabled(false);
                }else{
                    this.Bcountry.get(3).setEnabled(true);
                }
                if (gp.getCountry().get(country_stat).isUp1(4) == true || points < 50) {
                    this.Bcountry.get(4).setEnabled(false);
                }else{
                    this.Bcountry.get(4).setEnabled(true);
                }
                if (gp.getCountry().get(country_stat).isUp1(5) == true || points < 50) {
                    this.Bcountry.get(5).setEnabled(false);
                }else{
                    this.Bcountry.get(5).setEnabled(true);
                }
                if (gp.getCountry().get(country_stat).isUp1(6) == true || points < 80) {
                    this.Bcountry.get(6).setEnabled(false);
                }else{
                    this.Bcountry.get(6).setEnabled(true);
                }
                if ( points < 120 || VaccineBehave.rise > 11) {
                    this.Bcountry.get(7).setEnabled(false);
                }else{
                    this.Bcountry.get(7).setEnabled(true);
                }
                if ( points < 20 || VaccineBehave.rise > 11) {
                    this.Bcountry.get(8).setEnabled(false);
                }else{
                    this.Bcountry.get(8).setEnabled(true);
                }
                if ((gp.getProgres() == 100) || (gp.getInfected() > 2*gp.getNormal())) {
                    this.fin.doClick(0);
                }
                Rectangle r = frame.getBounds();
                int h = r.height;
                int w = r.width;
                jSplitPane.setDividerLocation(w - (w / 10) * 3);
            } catch (InterruptedException ex) {

            }

        }
    }

}
