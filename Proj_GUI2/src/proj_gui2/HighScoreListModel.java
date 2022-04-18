
package proj_gui2;

import java.util.ArrayList;
import javax.swing.AbstractListModel;



public class HighScoreListModel extends AbstractListModel<String> {
    
    private ArrayList<Score> scoreL;

    public HighScoreListModel(ArrayList<Score> scoreL) {
        this.scoreL = scoreL;
    }
    
    @Override
    public int getSize() {
        return scoreL.size();
    }

    @Override
    public String getElementAt(int index) {
        return (index+1) +". "+scoreL.get(index).toString();
    }
    
}
