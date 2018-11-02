package sevenbits.RougelikeGame.GameObjects.Items.Valuables;

import sevenbits.RougelikeGame.GameObjects.Interfaces.IGameItem;
import sevenbits.RougelikeGame.GameObjects.Interfaces.IStaticObject;

public class Coin implements IGameItem, IStaticObject {
    private String parameterName = "Value";
    private int parameter;
    private int x;
    private int y;
    private boolean isInWorld;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setInWorld(boolean inWorld) {
        isInWorld = inWorld;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isInWorld() {
        return isInWorld;
    }

    public Coin(int x, int y, boolean isInWorld){
        setInWorld(isInWorld);
        setX(x);
        setY(y);
        parameter = 4;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coin: ").append(parameterName).append(" - ").append(parameter).append("\n");
        return sb.toString();
    }

    public int getParameter() {
        return parameter;
    }

    public void setParameter(int newParameter){
        this.parameter = newParameter;
    }
}
