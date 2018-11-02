package sevenbits.RougelikeGame.GameObjects.Interfaces;

public interface ICharacter {
    IGameContainer getCharacterContainer();
    int getHealth();
    void setHealth(int health);
    void setMaxHealth(int maxHealth);
    int getMaxHealth();
    int getAttack();
    void setAttack(int attack);
}
