package sevenbits.RougelikeGame.Exceptions;

public class ContainerSpaceException extends Exception{
    public ContainerSpaceException(String message){
        super(message);
    }

    public ContainerSpaceException(String message, Exception e){
        super(message,e);
    }
}
