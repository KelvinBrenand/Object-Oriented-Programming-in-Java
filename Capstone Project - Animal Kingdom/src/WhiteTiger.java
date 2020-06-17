import java.awt.*;

public class WhiteTiger extends Tiger {
    private boolean growUp;
    private final Color color;

    public WhiteTiger(){
        color = Color.WHITE;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        if (growUp){
            return super.toString();
        }else {
            return "tgr";
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()){
            growUp = true;
        }
        return super.getMove(info);
    }
}
