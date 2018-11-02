package sevenbits.RougelikeGame.GameObjects.Interfaces;

public interface IGameItem {
    int getParameter();
    boolean isInWorld();
    void setInWorld(boolean inWorld);
}
