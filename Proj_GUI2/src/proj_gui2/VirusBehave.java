package proj_gui2;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VirusBehave implements Runnable {

    private double lockCof = 1;
    private double dif;
    private double inc = 1.00000005;
    private ArrayList<Country> countrys;
    private int geomProg;
    private int chance;
    private int chance_trans = 5;
    private int chance_trans_b = 3;
    private int chance_trans_c = 2;
    private int operator;
   

    VirusBehave(int dif, ArrayList<Country> countrys) {
        if (dif == 1) {
            //this.geomProg = 2;
            this.dif = 1.1;
        }
        if (dif == 2) {
            //this.geomProg = 4;
            this.dif = 1.2;
        }
        if (dif == 3) {
            //this.geomProg = 6;
            this.dif = 1.3;
        }
        this.dif = dif;
        this.countrys = countrys;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                chance = (int) ((Math.random()+1) * 5);
                operator = (int) (Math.random() + 2);
                if(operator == 1){
                geomProg = geomProg - chance;
                }
                if(operator == 2){
                geomProg = geomProg + chance;
                }
                if(geomProg <= 0){
                geomProg = 1;
                }   
                Thread.sleep(1000);
                
                //Adding sick people
                for (int i = 0; i < countrys.size(); i++) {
                    if (countrys.get(i).getInfected() >= 1 && countrys.get(i).getInfected() <countrys.get(i).getPopulation() ) {
                        double individualCof = 1;
                        if(countrys.get(i).getLockDown() == true){
                         lockCof = 0.85;
                        }
                        if (countrys.get(i).isUp1(0) == true) {
                            individualCof = individualCof * 0.8;
                        }
                        if (countrys.get(i).isUp1(1) == true) {
                            individualCof = individualCof * 0.8;
                        }
                        if (countrys.get(i).isUp1(4) == true) {
                            individualCof = individualCof * 0.65;
                        }
                        if (countrys.get(i).isUp1(5) == true) {
                            individualCof = individualCof * 0.65;
                        }
                        if (countrys.get(i).getInfected()> countrys.get(i).getPopulation()/2) {
                            countrys.get(i).setLockDown(true);
                        }
                        countrys.get(i).addInfected((long)(countrys.get(i).getInfected()*0.1*dif*lockCof*individualCof));
                    }
                }
                //Adding recovered people
                for (int i = 0; i < countrys.size(); i++) {
                    if (countrys.get(i).getInfected() >= 1 && countrys.get(i).getInfected() <countrys.get(i).getPopulation() ) {
                        double upgrade = 1;
                        //second upgrade CHANGE!!!!!!!
                        if (countrys.get(i).isUp1(2) == true) {
                            upgrade = upgrade * 1.5;
                        }
                        //third upgrade CHANGE!!!!!!!
                        if (countrys.get(i).isUp1(3) == true) {
                            upgrade = upgrade * 1.8;
                        }
                        countrys.get(i).addNorm((long)(countrys.get(i).getInfected()*0.025*upgrade));
                    }
                }
                //checking cases
//                long res = 0;
//                for (int i = 0; i < countrys.size(); i++) {
//                    res = res + countrys.get(i).getCases();
//                    
//                }
//                System.out.println(res);
                //Managing sick people through roots
                for (int i = 0; i < countrys.size(); i++) {
                    if (countrys.get(i).getInfected() >= 1) {
                        for (int j = 0; j < countrys.get(i).getCountryAir().size(); j++) {
                            for (int k = 0; k < countrys.size(); k++) {
                                int ch = (int) (Math.random()*100);
                                if(countrys.get(k).getName().equals(countrys.get(i)
                                        .getCountryAir().get(j)) && ch < chance_trans 
                                        && countrys.get(k).isAir() == true 
                                        && countrys.get(i).isAir() == true){
                                countrys.get(k).addInfected(35);
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < countrys.size(); i++) {
                    if (countrys.get(i).getInfected() >= 1) {
                        for (int j = 0; j < countrys.get(i).getCountryBoat().size(); j++) {
                            for (int k = 0; k < countrys.size(); k++) {
                                int ch = (int) (Math.random()*100);
                                if(countrys.get(k).getName()
                                        .equals(countrys.get(i).getCountryBoat().get(j)) 
                                        && ch < chance_trans_b && countrys.get(k)
                                        .isBoat() == true && countrys.get(i).isBoat() == true){
                                countrys.get(k).addInfected(20);
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < countrys.size(); i++) {
                    if (countrys.get(i).getInfected() >= 1) {
                        for (int j = 0; j < countrys.get(i).getCountryLand().size(); j++) {
                            for (int k = 0; k < countrys.size(); k++) {
                                int ch = (int) (Math.random()*100);
                                if(countrys.get(k).getName().equals(countrys.get(i).getCountryLand().get(j)) 
                                        && ch < chance_trans_c && countrys.get(i).isLand() == true 
                                        && countrys.get(k).isLand() == true ){
                                countrys.get(k).addInfected(10);
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < countrys.size(); i++) {
                    if (countrys.get(i).getNorm() <= 0) {
                        countrys.get(i).setInfected((countrys.get(i).getPopulation()));
                    }
                }
            } catch (InterruptedException ex) {
                return;
            }

        }
    }

}
