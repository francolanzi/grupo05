package trabajofinal;

public class EntidadInvalidaException extends Exception
{
    
    private Entidad entidad;

    public EntidadInvalidaException(Entidad entidad)
    {
        this.entidad = entidad;
    }

}
