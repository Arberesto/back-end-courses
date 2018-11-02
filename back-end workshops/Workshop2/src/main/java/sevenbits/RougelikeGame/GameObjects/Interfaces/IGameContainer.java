package sevenbits.RougelikeGame.GameObjects.Interfaces;

import sevenbits.RougelikeGame.Exceptions.ContainerSpaceException;

public interface IGameContainer {
    int getEmptySlots();
    int getSize();
    void setContainerSize(int containerSize);
    IGameItem getItemFromContainer(int index) throws ContainerSpaceException;
    boolean isSlotEmpty(int index);
    void moveItemIntoContainer(IGameItem item, int index) throws ContainerSpaceException;
}
