package sevenbits.RougelikeGame.GameObjects.Containers;

import sevenbits.RougelikeGame.Exceptions.ContainerSpaceException;
import sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.IGameItem;

public class Inventory implements IGameContainer {
    private int containerSize;
    private IGameItem[] container;
    private int containerEmptySlots;

    public Inventory(int containerSize) {
        setContainerSize(containerSize);
        container = new IGameItem[containerSize];
        containerEmptySlots = containerSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory contain: \n");
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

    public IGameItem getItemFromContainer(int index) throws ContainerSpaceException {
        if (container[index] == null) {
            throw new ContainerSpaceException("Error!There is no object to get from container!");
        }
        containerEmptySlots++;
        IGameItem item = container[index];
        container[index] = null;
        return item;
    }

    public boolean isSlotEmpty(int index) {
        return container[index] == null;
    }

    public int getEmptySlots() {
        return containerEmptySlots;
    }

    public void moveItemIntoContainer(IGameItem item, int index) throws ContainerSpaceException {
        if (containerEmptySlots == 0) {
            throw new ContainerSpaceException("Error!Container can't handle any more items!");
        }
        if (container[index] == null) {
            throw new ContainerSpaceException("Error!This slot is not empty!");
        }
        container[index] = item;
        containerEmptySlots--;
    }
}
