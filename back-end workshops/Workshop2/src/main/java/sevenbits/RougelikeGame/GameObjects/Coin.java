package sevenbits.RougelikeGame.GameObjects;

public class Coin implements IGameItem {
    String parameterName = "Value";
    int parameter;

    public Coin(){
        parameter = 3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coin: ").append(parameterName).append(" - ").append(parameter).append("\n");
        return sb.toString();
    }

    public int getParameter() {
        return parameter;
    }

    public void setParameter(int newParameter){
        this.parameter = newParameter;
    }
}
