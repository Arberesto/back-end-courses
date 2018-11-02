package sevenbits.RougelikeGame.GameObjects.DynamicObjects.Characters.Players;

import sevenbits.RougelikeGame.GameObjects.DynamicObjects.Characters.ICharacter;
import sevenbits.RougelikeGame.GameObjects.DynamicObjects.IDynamicObject;
import sevenbits.RougelikeGame.GameObjects.StaticObjects.IStaticObject;

public interface IPlayer extends ICharacter, IDynamicObject {
    void InteractWith(IStaticObject object);
}
