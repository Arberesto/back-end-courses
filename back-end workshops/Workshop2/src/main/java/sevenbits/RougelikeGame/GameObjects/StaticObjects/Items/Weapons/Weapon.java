package sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.Weapons;

public class Weapon implements IWeapon {
    private int attack;
    private int x;
    private int y;

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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Weapon(int x, int y, int attack){
        setX(x);
        setY(y);
        setAttack(attack);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Weapon: ").append("Attack").append(" - ").append(attack).append("\n");
        return sb.toString();
    }
}
