package trabajofinal;

public class AltaException extends Exception
{
    
    private Entidad entidad;

    public AltaException(Entidad entidad)
    {
        this.entidad = entidad;
    }

}
