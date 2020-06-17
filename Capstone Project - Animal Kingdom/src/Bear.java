import java.awt.*;
public class Bear extends Critter {
    private boolean polar, toStringReturnModifier;

    public Bear(boolean polar){
        this.polar = polar;
        toStringReturnModifier = true;
    }

    @Override
    public Color getColor() {
        if (this.polar){
            return Color.WHITE;
        }else {
            return super.getColor();
        }
    }

    @Override
    public String toString() {
        if (toStringReturnModifier){
            toStringReturnModifier = false;
            return "/";
        }else {
            toStringReturnModifier = true;
            return "\\";
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()){
            return Action.INFECT;
        }else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }else {
            return super.getMove(info);
        }
    }
}
