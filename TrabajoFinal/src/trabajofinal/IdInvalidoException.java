package trabajofinal;

public class IdInvalidoException extends Exception
{
    
    private String id;
    
    public IdInvalidoException(String id, String mensaje)
    {
        super(mensaje);
        this.id = id;
    }
    
    public IdInvalidoException(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }

}
