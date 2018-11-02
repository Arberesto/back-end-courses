package sevenbits.RougelikeGame.GameObjects.DynamicObjects.Characters.Players;

import sevenbits.RougelikeGame.GameObjects.Containers.IGameContainer;
import sevenbits.RougelikeGame.Exceptions.ContainerSpaceException;
import sevenbits.RougelikeGame.GameObjects.Containers.Inventory;
import sevenbits.RougelikeGame.GameObjects.StaticObjects.IStaticObject;
import sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.IGameItem;

public class Player implements IPlayer {
    private int health;
    private int maxHealth;
    private int x;
    private int y;
    private int attack;
    private Inventory inventory = new Inventory(4);

    public Player(int x, int y, int maxHealth, int attack) {
        setX(x);
        setY(y);
        setAttack(attack);
        setMaxHealth(maxHealth);
        setHealth(maxHealth);
    }

    public IGameContainer getCharacterContainer() { return inventory; }

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

    public void InteractWith(IStaticObject object){
        if (object.getClass().isAssignableFrom(IGameItem.class)) {
            try{
                this.getCharacterContainer().moveItemIntoContainer(((IGameItem) object) ,this.getCharacterContainer().getEmptySlots());
            } catch(ContainerSpaceException e) {
                System.out.println(e.getMessage());
            }
        }
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
        sb.append("Player's inventory: \n").append(inventory.toString());
        return sb.toString();
    }
}
