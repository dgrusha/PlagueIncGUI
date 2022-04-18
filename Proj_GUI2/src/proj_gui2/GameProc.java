package proj_gui2;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;

public class GameProc {

    private int difficulty;
    private ArrayList<Country> country;
    private Thread virus;
    private Thread vaccine;
    private Roots anim;
    private VaccineBehave vac;

    GameProc(int difficulty, JLabel map) {
        ArrayList<Country> country2 = new ArrayList<>();
        this.country = country2;
        long l = 1000000000;
        
        
        ArrayList<String> landChina = new ArrayList<String>() {
            {
                add("Mongolia");
                add("Russia");
                add("Korea");
                add("India");
            }
        };
        ArrayList<String> portsChina = new ArrayList<String>() {
            {
                add("Japan");
                add("Indonesia");
            }
        };
        ArrayList<String> airChina = new ArrayList<String>() {
            {
                add("Russia");
                add("Japan");
            }
        };
        
        ArrayList<String> landMongolia = new ArrayList<String>() {
            {
                add("Russia");
                add("China");
            }
        };
        ArrayList<String> airMongolia = new ArrayList<String>() {
            {
                add("Mongolia");
                add("Korea");
                add("India");
            }
        };
        ArrayList<String> portsMongolia = new ArrayList<String>();
        
        ArrayList<String> landRu = new ArrayList<String>() {
            {
                add("Mongolia");
                add("China");
                add("Korea");
                add("Afganistan");
            }
        };
        ArrayList<String> portsRu = new ArrayList<String>() {
            {
   
            }
        };
        ArrayList<String> airRu = new ArrayList<String>() {
            {
                add("India");
                add("Japan");
            }
        };
        
        ArrayList<String> landKorea = new ArrayList<String>() {
            {
                
                add("China");
            }
        };
        ArrayList<String> portsKorea = new ArrayList<String>() {
            {
                add("Japan");
                add("Myanma");
            }
        };
        ArrayList<String> airKorea = new ArrayList<String>() {
            {
                add("Afganistan");
            }
        };
        
        ArrayList<String> landJapan = new ArrayList<String>() {
            {
            }
        };
        ArrayList<String> portsJapan = new ArrayList<String>() {
            {
                add("Korea");
                add("Indonesia");
                add("Philipines");
            }
        };
        ArrayList<String> airJapan = new ArrayList<String>() {
            {
                add("Russia");
                add("Myanma");
            }
        };
        
        ArrayList<String> landInd = new ArrayList<String>() {
            {
                add("Philipines");
            }
        };
        ArrayList<String> portsInd = new ArrayList<String>() {
            {
                add("Japan");
            }
        };
        ArrayList<String> airInd = new ArrayList<String>() {
            {
                add("Russia");
            }
        };
        
        ArrayList<String> landMal = new ArrayList<String>() {
            {
                add("Indonesia");
            }
        };
        
        ArrayList<String> landIndia = new ArrayList<String>() {
            {
                add("China");
                add("Myanma");
            }
        };
        
        ArrayList<String> landK = new ArrayList<String>() {
            {
                add("Russia");
                add("China");
            }
        };
        
        ArrayList<String> landMyanma = new ArrayList<String>() {
            {
                add("India");
                add("China");
            }
        };
        
        country.add(new Country("China", l, portsChina, airChina, landChina, "C:\\Users\\Dima\\Desktop\\Java\\Proj_GUI2\\china_flag.gif"));
        country.add(new Country("Mongolia", 3_000_000, portsMongolia, airMongolia, landMongolia, "C:\\Users\\Dima\\Desktop\\Java\\Proj_GUI2\\mongolia_flag.gif"));
        country.add(new Country("Russia", 144_000_000, portsRu, airRu, landRu, "C:\\Users\\Dima\\Desktop\\Java\\Proj_GUI2\\russian_federation_flag.gif"));
        country.add(new Country("Korea", 51_000_000, portsKorea, airKorea, landKorea, "C:\\Users\\Dima\\Desktop\\Java\\Proj_GUI2\\korea_south_flag.gif"));
        country.add(new Country("Japan", 126_000_000, portsJapan, airJapan, landJapan, "C:\\Users\\Dima\\Desktop\\Java\\Proj_GUI2\\japan_flag.gif"));
        country.add(new Country("Indonesia", 244_000_000, portsInd, airInd, landInd, "C:\\Users\\Dima\\Desktop\\Java\\Proj_GUI2\\indonesia_flag.gif"));
        country.add(new Country("India", l, landInd, airInd, landIndia, "C:\\Users\\Dima\\Desktop\\Java\\Proj_GUI2\\india_flag.gif"));
        country.add(new Country("Philipines", 31_000_000, portsInd, airInd, landMal, "C:\\Users\\Dima\\Desktop\\Java\\Proj_GUI2\\philippines_flag.gif"));
        country.add(new Country("Afganistan", 18_000_000, landJapan, airChina, landK , "C:\\Users\\Dima\\Desktop\\Java\\Proj_GUI2\\afghanistan_flag.gif"));
        country.add(new Country("Myanma", 32_000_000, landMal, landJapan, landMyanma, "C:\\Users\\Dima\\Desktop\\Java\\Proj_GUI2\\myanmar-new-flag.gif" ));
        
        for (int i = 0; i < country.size(); i++) {
            country.get(i).addCountry(country);        
        }
        
        country.get(0).setInfected(10);
        VirusBehave vb = new VirusBehave(difficulty, country);
        Thread t = new Thread(vb);
        this.virus = t;
        t.start();
        
        VaccineBehave vac = new VaccineBehave();
        this.vac = vac;
        Thread v = new Thread(vac);
        this.vaccine = v;
        v.start();

        Roots rts = new Roots(map, country);
        anim = rts;
    }
        
    public void endThreads() {
        this.virus.interrupt();
        this.vaccine.interrupt();
        anim.endThreads();
    }
        
    public long getInfected() {
        long num = 0;
        for (int i = 0; i < country.size(); i++) {
            num = num + country.get(i).getInfected();
        }
        return num;
    }

    public long getNormal() {
        long num = 0;
        for (int i = 0; i < country.size(); i++) {
            num = num + country.get(i).getNorm();
        }
        return num;
    }

    public ArrayList<Country> getCountry() {
        return country;
    }
    
    public long getCases(){
    long cases = 0;
    for (int i = 0; i < country.size(); i++) {
            cases = cases + country.get(i).getCases();
        }
//    for (int i = 0; i < country.size(); i++) {
//            country.get(i).setCases(0);
//        }
    return cases;
    }
    
    public double getProgres() {
        return this.vac.getProgres();
    }

}
