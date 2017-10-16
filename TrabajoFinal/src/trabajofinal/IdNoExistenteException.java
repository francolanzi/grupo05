package trabajofinal;

public class IdNoExistenteException extends Exception
{
    
    private String id;

    public IdNoExistenteException(String id)
    {
        this.id = id;
    }

}
