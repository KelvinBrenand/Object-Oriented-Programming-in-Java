import java.awt.*;

public class NinjaCat extends Critter {
    private final Color color;
    private int hidden;

    public NinjaCat(){
        color = Color.BLACK;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        if (hidden == 0){
            return ".";
        }else {
            return "NC";
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        if (info.frontThreat() || info.backThreat()){
            hidden = 3;
            return Action.INFECT;
        }else {
            hidden--;
            if (hidden < 0){
                hidden = 0;
            }

            if (info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME){
                return Action.RIGHT;
            }else {
                return Action.HOP;
            }
        }
    }
}
