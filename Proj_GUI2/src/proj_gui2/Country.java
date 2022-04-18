package proj_gui2;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Country {

    private String name;
    private long population;
    private boolean start = false;
    private long infected = 0;
    private long norm = 0;
    private boolean lockDown = false;
    private boolean lockDownEND = false;
    private Image cImage;
    
    private ArrayList<Country> country;
    private ArrayList<String> countryLand;
    private ArrayList<String> countryAir;
    private ArrayList<String> countryBoat;
    private long cases = 0;
    
    //Borders
    private boolean boat = true;
    private boolean air = true;
    private boolean land = true;
    
    //Upgrades
    private boolean[] ups;
    private boolean up1 = false;
    private boolean up2 = false;
    private boolean up3 = false;
    private boolean up4 = false;
    private boolean up5 = false;
    private boolean up6 = false;
    private boolean up7 = false;
    

    public Country(String name, long population, ArrayList<String> ports, ArrayList<String> air, ArrayList<String> land, String image) {
        try {
            cImage = ImageIO.read(new File(image));
        } catch (IOException ex) {
            //Logger.getLogger(Country.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.ups = new boolean[7];
        this.ups[0] = up1;
        this.ups[1] = up2;
        this.ups[2] = up3;
        this.ups[3] = up4;
        this.ups[4] = up5;
        this.ups[5] = up6;
        this.ups[6] = up7;
        
        //
        this.name = name;
        this.countryAir = air;
        this.countryBoat = ports;
        this.countryLand = land;
        this.population = population;
        this.norm = population;
    }

    public void setInfected(long infected) {
        this.infected = infected;
    }

    public long getInfected() {
        return infected;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void addInfected(long infected) {
        this.infected = this.getInfected() + infected;
        this.norm = this.norm - infected;
    }

    public long getPopulation() {
        return population;
    }

    public boolean getLockDown() {
        return lockDown;
    }

    public void setLockDown(boolean lockDown) {
        this.lockDown = lockDown;
    }

    public boolean isBoat() {
        return boat;
    }

    public boolean isAir() {
        return air;
    }

    public boolean isLand() {
        return land;
    }

    public void setBoat(boolean boat) {
        this.boat = boat;
    }

    public void setAir(boolean air) {
        this.air = air;
    }

    public void setLand(boolean land) {
        this.land = land;
    }

    public long getNorm() {
        return norm;
    }

    public void addCountry(ArrayList<Country> country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getCountryLand() {
        return countryLand;
    }

    public ArrayList<String> getCountryAir() {
        return countryAir;
    }

    public ArrayList<String> getCountryBoat() {
        return countryBoat;
    }
    
    public void addNorm(long norm){
        this.norm = this.norm + norm;
        this.cases = this.cases + norm;
        this.infected = this.infected - norm;
    }

    public long getCases() {
        return cases;
    }

    public void setCases(long cases) {
        this.cases = cases;
    }

    public boolean isUp1(int i) {
        return this.ups[i];
    }

    public Image getcImage() {
        return cImage;
    }

    public boolean[] getUps() {
        return ups;
    }

    public void setUps(int i, boolean a) {
        this.ups[i] = a;
    }
    
    
    

}
