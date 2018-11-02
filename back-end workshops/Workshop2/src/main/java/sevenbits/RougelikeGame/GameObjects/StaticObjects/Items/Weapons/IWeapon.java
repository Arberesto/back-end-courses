package sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.Weapons;

import sevenbits.RougelikeGame.GameObjects.StaticObjects.IStaticObject;
import sevenbits.RougelikeGame.GameObjects.StaticObjects.Items.IGameItem;

public interface IWeapon extends IGameItem, IStaticObject {
    int getAttack();
    void setAttack(int attack);
}
