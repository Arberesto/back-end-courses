package sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.Armors;

import sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.IGameItem;
import sevenbits.RougelikeGame.GameObjects.StaticObjects.IStaticObject;

public class Armor implements IArmor {
    private int x;
    private int y;
    private int armor;

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

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public Armor(int x, int y, int armor){
        setX(x);
        setY(y);
        setArmor(armor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Armors: ").append("Armor").append(" - ").append(armor).append("\n");
        return sb.toString();
    }
}
