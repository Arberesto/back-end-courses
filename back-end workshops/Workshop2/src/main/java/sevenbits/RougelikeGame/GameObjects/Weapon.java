package sevenbits.RougelikeGame.GameObjects;

public class Weapon implements IGameItem {
    String parameterName = "Attack";
    int parameter;

    public Weapon(){
        parameter = 4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Weapon: ").append(parameterName).append(" - ").append(parameter).append("\n");
        return sb.toString();
    }

    public int getParameter() {
        return parameter;
    }

    public void setParameter(int newParameter){
        this.parameter = newParameter;
    }
}
