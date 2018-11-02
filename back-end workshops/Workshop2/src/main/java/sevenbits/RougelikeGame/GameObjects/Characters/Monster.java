package sevenbits.RougelikeGame.GameObjects.Characters;

import sevenbits.RougelikeGame.GameObjects.Interfaces.ICharacter;
import sevenbits.RougelikeGame.GameObjects.Interfaces.IDynamicObject;
import sevenbits.RougelikeGame.GameObjects.Interfaces.IGameContainer;
import sevenbits.RougelikeGame.GameObjects.Inventory;

public class Monster implements ICharacter, IDynamicObject {
    private int health;
    private int maxHealth;
    private int x;
    private int y;
    private int attack;
    private Inventory inventory = new Inventory(4);
    public IGameContainer getCharacterContainer() {
        return inventory;
    }

    public Monster(int x, int y, int maxHealth, int attack) {
        setX(x);
        setY(y);
        setAttack(attack);
        setMaxHealth(maxHealth);
        setHealth(maxHealth);
    }

    public void Move(int x, int y) {
        this.x += x;
        this.y += y;
    }

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

    public int getHealth() {
        return this.health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monster's inventory: \n");
        sb.append(inventory.toString());
        return sb.toString();
    }
}
