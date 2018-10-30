package sevenbits.RougelikeGame.GameObjects;

import sevenbits.RougelikeGame.Exceptions.ContainerOverloadException;

import java.awt.*;

public interface IGameContainer {
    IGameItem[] getContainer();
    int getEmptySlots();
    int getSize();
    IGameItem getItemFromContainer(int index);
    void moveItemIntoContainer(IGameItem item, int index) throws ContainerOverloadException;
}
