package trabajofinal;

public class BajaException extends Exception
{
    
    private String id;

    public BajaException(String id)
    {
        this.id = id;
    }

}
