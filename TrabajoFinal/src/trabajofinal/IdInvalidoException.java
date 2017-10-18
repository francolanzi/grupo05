package trabajofinal;

public class IdInvalidoException extends Exception
{
    
    private String id;

    public IdInvalidoException(String id)
    {
        this.id = id;
    }

}
