package sevenbits.RougelikeGame.GameObjects;

import sevenbits.RougelikeGame.Exceptions.ContainerSpaceException;
import sevenbits.RougelikeGame.GameObjects.Interfaces.IGameContainer;
import sevenbits.RougelikeGame.GameObjects.Interfaces.IGameItem;
import sevenbits.RougelikeGame.GameObjects.Interfaces.IStaticObject;
import sevenbits.RougelikeGame.GameObjects.Items.Armors.Armor;
import sevenbits.RougelikeGame.GameObjects.Items.Valuables.Coin;
import sevenbits.RougelikeGame.GameObjects.Items.Weapons.Weapon;

public class Chest implements IGameContainer, IStaticObject {
    private int containerSize;
    private IGameItem[] container;
    private int containerEmptySlots;
    private int x;
    private int y;

    public Chest(int x, int y, int containerSize){
        setX(x);
        setY(y);
        setContainerSize(containerSize);
        container = new IGameItem[containerSize];
        containerEmptySlots = containerSize;
            try{
            moveItemIntoContainer(new Weapon(x,y,false),containerSize - containerEmptySlots);
            }
            catch(ContainerSpaceException e){
                System.out.println(e.getMessage());
            }
        try{
            moveItemIntoContainer(new Coin(x,y,false),containerSize - containerEmptySlots);
        }
        catch(ContainerSpaceException e){
            System.out.println(e.getMessage());
        }
        try{
            moveItemIntoContainer(new Armor(x,y,false),containerSize - containerEmptySlots);
        }
        catch(ContainerSpaceException e){
            System.out.println(e.getMessage());
        }
        try{
            moveItemIntoContainer(new Coin(x,y,false),containerSize - containerEmptySlots);
        }
        catch(ContainerSpaceException e){
            System.out.println(e.getMessage());
        }
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Chest contain: \n");
        if (containerEmptySlots != containerSize) {
            for (int i = 0; i < containerEmptySlots; i++) {
                sb.append(container[i].toString());
            }
        }
        return sb.toString();
    }

    public int getSize() {
        return container.length;
    }

    public void setContainerSize(int containerSize) {
        this.containerSize = containerSize;
    }

    public IGameItem getItemFromContainer(int index) throws ContainerSpaceException  {
        if (container[index] == null) {
            throw new ContainerSpaceException("Error!There is no object to get from container!");
        }
        containerEmptySlots++;
        IGameItem item = container[index];
        container[index] = null;
        return item;
    }

    public int getEmptySlots() {
        return containerEmptySlots;
    }

    public void moveItemIntoContainer(IGameItem item, int index) throws ContainerSpaceException {
        if (containerEmptySlots <= 0) {
            throw new ContainerSpaceException("Error!Container can't handle any more items!");
        }
        if (container[index] != null) {
            throw new ContainerSpaceException("Error!This slot is not empty!");
        }
        container[index] = item;
        containerEmptySlots--;
    }
}
