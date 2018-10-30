package sevenbits.RougelikeGame.GameObjects;

public class Monster implements ICharacter{
    private Inventory inventory = new Inventory();
    public IGameContainer getCharacterContainer() {
        return inventory;
    }
}
