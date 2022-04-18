package proj_gui2;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import proj_gui2.Country;

public class GameScreen extends JFrame implements Serializable{

    private Image backgroundImage;
    private Image cImage;
    private JLabel flag;
    private JProgressBar progressBar;

    GameScreen(MyCalendar mc, Thread time, int diff) {

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("(anti)PLAGUE INC");
        //frame.setIconImage(new Image(backgroundImage) {});
        frame.setBackground(Color.RED);
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.WHITE);
        JButton b1 = new JButton("End Game");
        b1.setForeground(Color.RED);
        b1.setMnemonic('C');
        b1.setBackground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
        Image icon = Toolkit.getDefaultToolkit().getImage("VirusIc.png");
        frame.setIconImage(icon);

        //progress bar
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.GREEN);
        progressBar.setBackground(Color.lightGray);
        
        ArrayList<JLabel> LCountry = new ArrayList<JLabel>() {
            {
                add(new JLabel("China"));
                add(new JLabel("Mongolia"));
                add(new JLabel("Russia"));
                add(new JLabel("Korea"));
                add(new JLabel("Japan"));
                add(new JLabel("Indonesia"));
                add(new JLabel("India"));
                add(new JLabel("Phillipines"));
                add(new JLabel("Afganistan"));
                add(new JLabel("Myanma"));
            }
        };

        ArrayList<JButton> Cbut = new ArrayList<JButton>() {
            {
                add(new JButton("China"));
                add(new JButton("Mongol."));
                add(new JButton("Russia"));
                add(new JButton("Korea"));
                add(new JButton("Japan"));
                add(new JButton("Indonesia"));
                add(new JButton("India"));
                add(new JButton("Philipines"));
                add(new JButton("Afganistan"));
                add(new JButton("Myanma"));
            }
        };
        
        Cbut.get(0).setBounds(475, 500, 70, 20);
        Cbut.get(1).setBounds(475, 390, 80, 20);
        Cbut.get(2).setBounds(400, 300, 80, 20);
        Cbut.get(3).setBounds(620, 400, 70, 20);
        Cbut.get(4).setBounds(700, 400, 70, 20);
        Cbut.get(5).setBounds(550, 765, 90, 20);
        Cbut.get(6).setBounds(330, 580, 70, 20);
        Cbut.get(7).setBounds(675, 600, 100, 20);
        Cbut.get(8).setBounds(185, 460, 95, 20);
        Cbut.get(9).setBounds(450, 600, 90, 20);
        
        jPanel.setLayout(new BorderLayout());
        JLabel jl= new JLabel();;
        try {
            backgroundImage = ImageIO.read(new File("map.jpg"));
            jl = new JLabel(new ImageIcon(backgroundImage));
            jl.setLayout(null);
            jl.add(Cbut.get(0));
            jl.add(Cbut.get(1));
            jl.add(Cbut.get(2));
            jl.add(Cbut.get(3));
            jl.add(Cbut.get(4));
            jl.add(Cbut.get(5));
            jl.add(Cbut.get(6));
            jl.add(Cbut.get(7));
            jl.add(Cbut.get(8));
            jl.add(Cbut.get(9));
            jPanel.add(jl, BorderLayout.CENTER);
        } catch (IOException ex) {
            //Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cbut.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        
        for (int i = 0; i < Cbut.size(); i++) {
            Cbut.get(i).setBackground(Color.BLACK);
            Cbut.get(i).setForeground(Color.red);
        }

        GameProc gp = new GameProc(diff, jl);
        JLabel inf = new JLabel("| Number of infected is " + gp.getInfected());
        inf.setForeground(Color.red);

        JLabel norm = new JLabel("| Number of immune people is " + gp.getNormal());
        norm.setForeground(Color.red);

        JLabel labelTime = new JLabel(mc.getCurentDate().toString());
        labelTime.setForeground(Color.red);
        
        JLabel vac = new JLabel("...");
        vac.setForeground(Color.GREEN);

        JPanel jPanelTopBar = new JPanel();
        JPanel jPanelDownBar = new JPanel();
        jPanelDownBar.setBackground(Color.BLACK);

        jPanelTopBar.setLayout(new FlowLayout());
        jPanelDownBar.setLayout(new FlowLayout());

        jPanel.add(jPanelTopBar, BorderLayout.NORTH);
        jPanel.add(jPanelDownBar, BorderLayout.SOUTH);

        JPanel jp2 = new JPanel();
        BoxLayout boxlayout = new BoxLayout(jp2, BoxLayout.Y_AXIS);
        jp2.setLayout(boxlayout);
        Rectangle s2 = jp2.getBounds();
        int h1 = s2.height;
        int w1 = s2.width;
        jp2.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));
        JPanel jp3 = new JPanel(new GridLayout(0, 2));

        jp2.setBackground(Color.BLACK);
        jp3.setBackground(Color.WHITE);

        JLabel c_name = new JLabel("China");
        JLabel c_info_pop = new JLabel("Population: " + gp.getCountry().get(0).getPopulation());
        JLabel c_name_inf = new JLabel("Amount of infected: " + gp.getCountry().get(0).getInfected());
        JLabel c_name_cases = new JLabel("Amount of cases: " + gp.getCountry().get(0).getCases());
        JLabel c_name_normal = new JLabel("Amount of non infected: " + gp.getCountry().get(0).getNorm());
        this.flag = new JLabel();
        this.flag.setBorder(border);
        try {
            cImage = ImageIO.read(new File("china_flag.gif"));
            flag.setIcon(new ImageIcon(cImage));
            c_name.setForeground(Color.red);
            c_name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
            c_info_pop.setForeground(Color.WHITE);
            c_name_inf.setForeground(Color.WHITE);
            c_name_cases.setForeground(Color.WHITE);
            c_name_normal.setForeground(Color.WHITE);

        } catch (IOException ex) {
            //Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        jp2.add(flag);
        jp2.add(c_name);
        jp2.add(c_info_pop);
        jp2.add(c_name_inf);
        jp2.add(c_name_cases);
        jp2.add(c_name_normal);

        ActionListener countryChange = new ActionListener() {
            //Исправить!!!!!!
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = e.getActionCommand();
                switch (choice) {
                    case "China":
                        Refresher.country_stat = 0;
                        break;
                    case "Mongol.":
                        Refresher.country_stat = 1;
                        break;
                    case "Russia":
                        Refresher.country_stat = 2;
                        break;
                    case "Korea":
                        Refresher.country_stat = 3;
                        break;
                    case "Japan":
                        Refresher.country_stat = 4;
                        break;
                    case "Indonesia":
                        Refresher.country_stat = 5;
                        break;
                    case "India":
                        Refresher.country_stat = 6;
                        break;
                    case "Philipines":
                        Refresher.country_stat = 7;
                        break;
                    case "Afganistan":
                        Refresher.country_stat = 8;
                        break;
                    case "Myanma":
                        Refresher.country_stat = 9;
                        break;    
                    default:

                }
                System.out.println(e.getActionCommand());
            }
        };
        for (int i = 0; i < Cbut.size(); i++) {
            Cbut.get(i).addActionListener(countryChange);
        }

        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.add("CountryInfo", jp2);
        jTabbedPane.add("Upgrades", jp3);

        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanel, jTabbedPane);
        Rectangle r = frame.getBounds();
        int h = r.height;
        int w = r.width;
        jSplitPane.setDividerLocation(w - (w / 10) * 3);
        jSplitPane.setEnabled(false);

        ArrayList<JButton> ups = new ArrayList<JButton>() {
            {
                add(new JButton("Social Distance"));
                add(new JButton("Free Masks"));
                add(new JButton("Close shops"));//2
                add(new JButton("Close restaurants"));//3
                add(new JButton("Close Boat roots"));//4
                add(new JButton("Close air roots"));//5
                add(new JButton("Full locdown"));//6
                add(new JButton("Vaccination lab"));
                add(new JButton("Vaccine Invest"));
            }
        };;
        ups.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.getCountry().get(Refresher.country_stat).setUps(0, true);
                Refresher.points = Refresher.points - 15;
            }
        });
        ups.get(0).setBackground(Color.BLACK);
        ups.get(0).setForeground(Color.RED);
        ups.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.getCountry().get(Refresher.country_stat).setUps(1, true);
                Refresher.points = Refresher.points - 20;
            }
        });
        ups.get(1).setBackground(Color.BLACK);
        ups.get(1).setForeground(Color.RED);
        ups.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.getCountry().get(Refresher.country_stat).setUps(2, true);
                Refresher.points = Refresher.points - 30;
            }
        });
        ups.get(2).setBackground(Color.BLACK);
        ups.get(2).setForeground(Color.RED);
        ups.get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.getCountry().get(Refresher.country_stat).setUps(3, true);
                Refresher.points = Refresher.points - 30;
            }
        });
        ups.get(3).setBackground(Color.BLACK);
        ups.get(3).setForeground(Color.RED);
        ups.get(4).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.getCountry().get(Refresher.country_stat).setUps(4, true);
                gp.getCountry().get(Refresher.country_stat).setBoat(false);
                Refresher.points = Refresher.points - 50;
            }
        });
        ups.get(4).setBackground(Color.BLACK);
        ups.get(4).setForeground(Color.RED);
        ups.get(5).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.getCountry().get(Refresher.country_stat).setUps(5, true);
                gp.getCountry().get(Refresher.country_stat).setAir(false);
                Refresher.points = Refresher.points - 60;
            }
        });
        ups.get(5).setBackground(Color.BLACK);
        ups.get(5).setForeground(Color.RED);
        ups.get(6).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.getCountry().get(Refresher.country_stat).setLockDown(true);
                Refresher.points = Refresher.points - 80;
            }
        });
        ups.get(6).setBackground(Color.BLACK);
        ups.get(6).setForeground(Color.RED);
        ups.get(7).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VaccineBehave.rise = VaccineBehave.rise * 10;
                Refresher.points = Refresher.points - 120;
            }
        });
        ups.get(7).setBackground(Color.BLACK);
        ups.get(7).setForeground(Color.RED);
        ups.get(8).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VaccineBehave.rise = VaccineBehave.rise * 5;
                Refresher.points = Refresher.points - 20;
            }
        });
        ups.get(8).setBackground(Color.BLACK);
        ups.get(8).setForeground(Color.RED);
        ArrayList<JLabel> discript = new ArrayList<JLabel>() {
            {
                add(new JLabel("<html>Cost: 15 points<br/>Discription : lowers"
                        + " number of infected, peoples are walking far away</html>"));
                add(new JLabel("<html>Cost: 20 points<br/>Discription : lowers"
                        + " number of infected, peoples are using more masks</html>"));
                add(new JLabel("<html>Cost: 30 points<br/>Discription : lowers"
                        + " number of infected, peoples are not visiting shops</html>"));
                add(new JLabel("<html>Cost: 30 points<br/>Discription : lowers"
                        + " number of infected, peoples are not visiting restaurants</html>"));
                add(new JLabel("<html>Cost: 50 points<br/>Discription : no new"
                        + " infected people are arriving using boat</html>"));
                add(new JLabel("<html>Cost: 60 <br/>Discription : no new"
                        + " infected people are arriving using airplane</html>"));
                add(new JLabel("<html>Cost: 80 points<br/>Discription : no new"
                        + " infected people are arriving at all</html>"));
                add(new JLabel("<html>Cost: 120 points<br/>Discription : new virus"
                        + " researching lab is opened, faster discovery of vaccine</html>"));
                add(new JLabel("<html>Cost: 20 points<br/>Discription : new virus"
                        + " labs are having more resources to find vaccine, faster discovery of vaccine </html>"));
            }
        };;
        for (int i = 0; i < ups.size(); i++) {
            jp3.add(ups.get(i));
            jp3.add(discript.get(i));
        }

        JButton InfoCBut = new JButton("CountryInfo");
        InfoCBut.setBackground(Color.WHITE);
        InfoCBut.setForeground(Color.RED);
        InfoCBut.addActionListener(new ActionListener() {
            @Override
           public void actionPerformed(ActionEvent e) {
                InfoPage cP = new InfoPage(LCountry);
            }
        });

        frame.add(jSplitPane);
        jPanelDownBar.add(InfoCBut);
        jPanelDownBar.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.endThreads();
                time.interrupt();
                String a = JOptionPane.showInputDialog(null,
                "Write your name",
                "Result",
                JOptionPane.PLAIN_MESSAGE);
                Score sc = new Score((int)Refresher.points, a);
                ArrayList<Score> scoreList = new ArrayList<>();
                if (new File("HighScore.txt").length() != 0) {
                    try (ObjectInputStream ois = new ObjectInputStream (new FileInputStream ("HighScore.txt"))){
                        scoreList = (ArrayList) ois.readObject ();
                    } catch (IOException | ClassNotFoundException ioException) {
                        ioException.printStackTrace ( );
                    }
                }
                scoreList.add(sc);

                try(ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream ("HighScore.txt"))){
                    oos.writeObject (scoreList);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                System.exit(1);
            }
        });
        
        jPanelTopBar.add(labelTime);
        jPanelTopBar.add(inf);
        jPanelTopBar.add(norm);
        jPanelDownBar.add(progressBar);
        jPanelTopBar.setBackground(Color.BLACK);

        Refresher dr = new Refresher(labelTime, mc, inf, gp, norm, LCountry,ups,
                frame, jSplitPane, c_name_inf, c_name_cases, c_name_normal,
                flag, c_name, vac, b1, progressBar);
        Thread ref = new Thread(dr);
        ref.start();
        
        frame.setSize(1220, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.repaint();
    }


}
