package sevenbits.RougelikeGame.GameObjects;

public class Armor implements IGameItem {
    String parameterName = "Armor";
    int parameter;

    public Armor(){
        parameter = 4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Armor: ").append(parameterName).append(" - ").append(parameter).append("\n");
        return sb.toString();
    }

    public int getParameter() {
        return parameter;
    }

    public void setParameter(int newParameter){
        this.parameter = newParameter;
    }
}
