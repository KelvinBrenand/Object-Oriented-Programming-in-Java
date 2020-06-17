import java.awt.*;

public class Giant extends Critter {
    private int numberOfMoves;
    private final Color color;
    public Giant(){
        color = Color.GRAY;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        if (numberOfMoves < 6){
            return "fee";
        }else if (numberOfMoves < 12){
            return "fie";
        }else if (numberOfMoves < 18){
            return "foe";
        }else {
            if (numberOfMoves == 23){
                numberOfMoves = 0;
            }
            return "fum";
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        numberOfMoves++;
        if (info.frontThreat()){
            return Action.INFECT;
        }else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }else {
            return Action.RIGHT;
        }
    }
}
