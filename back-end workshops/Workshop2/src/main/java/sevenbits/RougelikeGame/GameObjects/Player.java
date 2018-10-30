package sevenbits.RougelikeGame.GameObjects;

public class Player implements ICharacter {
    private Inventory inventory = new Inventory();
    public IGameContainer getCharacterContainer() {
        return inventory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player's inventory: \n");
        sb.append(inventory.toString());
        return sb.toString();
    }
}
