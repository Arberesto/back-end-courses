package sevenbits.RougelikeGame.GameObjects.DynamicObjects.Characters;

import sevenbits.RougelikeGame.GameObjects.Containers.IGameContainer;

public interface ICharacter {
    IGameContainer getCharacterContainer();
    int getHealth();
    void setHealth(int health);
    void setMaxHealth(int maxHealth);
    int getMaxHealth();
    int getAttack();
    void setAttack(int attack);
}
