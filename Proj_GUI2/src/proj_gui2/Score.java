package proj_gui2;

import java.io.Serializable;


public class Score implements Serializable, Comparable<Score> {
    
    private static final long serialVersionUID = 8692831623674597117L;
    
    private int points;
    private String name;

    public Score(int points, String name) {
        this.points = points;
        this.name = name;
    }
    
    @Override
    public int compareTo(Score o) {
        if (this.points>o.getPoints()) {
            return -1;
        }else if(this.points<o.getPoints()){
            return 1;
        }
        return -1;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Nicname : " + this.name + " Score : " + this.points;
    }
    
    
    
}
