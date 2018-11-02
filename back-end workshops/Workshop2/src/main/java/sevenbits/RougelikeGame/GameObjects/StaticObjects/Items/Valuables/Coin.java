package sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.Valuables;

public class Coin implements ICoin {
    private int x;
    private int y;
    private int value;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Coin(int x, int y, int value){
        setX(x);
        setY(y);
        setValue(value);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coin: ").append("Value").append(" - ").append(value).append("\n");
        return sb.toString();
    }
}
