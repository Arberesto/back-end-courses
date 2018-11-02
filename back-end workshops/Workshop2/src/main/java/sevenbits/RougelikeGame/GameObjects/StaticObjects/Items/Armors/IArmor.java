package sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.Armors;

import sevenbits.RougelikeGame.GameObjects.StaticObjects.IStaticObject;
import sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.IGameItem;

public interface IArmor extends IGameItem, IStaticObject {
    int getArmor();
    void setArmor(int armor);
}
