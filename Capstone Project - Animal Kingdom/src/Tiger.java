import java.awt.*;
public class Tiger extends Critter {
    private int numberOfMoves;
    private double randomNumber;
    private final String tiger;

    public Tiger(){
        numberOfMoves = 3;
        tiger = "TGR";
    }

    @Override
    public Color getColor() {
        if (numberOfMoves == 3){
            numberOfMoves = 0;
            randomNumber = Math.random();
        }

        if (randomNumber < 1/3.0){
            return Color.RED;
        }else if (randomNumber < 1/3.0*2){
            return Color.GREEN;
        }else {
            return Color.BLUE;
        }
    }

    @Override
    public String toString() {
        return tiger;
    }

    @Override
    public Action getMove(CritterInfo info) {
        numberOfMoves++;

        if (info.frontThreat()){
            return Action.INFECT;
        }else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return super.getMove(info);
        }else if (info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        }else {
            return Action.HOP;
        }
    }
}
