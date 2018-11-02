package sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.Valuables;

import sevenbits.RougelikeGame.GameObjects.StaticObjects.IStaticObject;
import sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.IGameItem;

public interface ICoin extends IGameItem, IStaticObject {
    int getValue();
    void setValue(int value);
}
