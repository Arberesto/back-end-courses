package sevenbits.RougelikeGame.Exceptions;

public class ContainerOverloadException extends Exception{
    public ContainerOverloadException(String message){
        super(message);
    }

    public ContainerOverloadException(String message, Exception e){
        super(message,e);
    }
}
