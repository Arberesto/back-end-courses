package sevenbits.RougelikeGame.GameObjects.Interfaces;

public interface IDynamicObject {
    void Move(int x, int y);
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);

}
