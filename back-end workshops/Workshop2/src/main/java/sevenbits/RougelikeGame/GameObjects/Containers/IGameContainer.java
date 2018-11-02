package sevenbits.RougelikeGame.GameObjects.Containers;

import sevenbits.RougelikeGame.Exceptions.ContainerSpaceException;
import sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.IGameItem;

public interface IGameContainer {
    int getEmptySlots();
    int getSize();
    void setContainerSize(int containerSize);
    IGameItem getItemFromContainer(int index) throws ContainerSpaceException;
    void moveItemIntoContainer(IGameItem item, int index) throws ContainerSpaceException;
}
