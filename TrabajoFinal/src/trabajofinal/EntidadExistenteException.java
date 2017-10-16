package trabajofinal;

public class EntidadExistenteException extends Exception
{
    
    private Entidad entidad;

    public EntidadExistenteException(Entidad entidad)
    {
        this.entidad = entidad;
    }

}
