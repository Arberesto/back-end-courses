package sevenbits.RougelikeGame.GameObjects;

import sevenbits.RougelikeGame.Exceptions.ContainerOverloadException;

public class Inventory implements IGameContainer {
    final int containerSize = 12;
    IGameItem[] container = new IGameItem[containerSize];
    int containerEmptySlots = containerSize;

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

    public IGameItem[] getContainer(){
        return container;
    }

    public int getSize() {
        return container.length;
    }

    public IGameItem getItemFromContainer(int index) {
        if (container[index]!= null) {
            containerEmptySlots++;
            IGameItem item = container[index];
            container[index] = null;
            return item;
        }
        return null;
    }

    public int getEmptySlots() {
        return containerEmptySlots;
    }

    public void moveItemIntoContainer(IGameItem item, int index) throws ContainerOverloadException {
        if (containerEmptySlots == 0) {
            throw new ContainerOverloadException("Error!Container can't handle any more items!");
        }
        if (container[index] == null) {
            throw new ContainerOverloadException("Error!This slot is not empty!");
        }
        container[index] = item;
        containerEmptySlots--;
    }
}
