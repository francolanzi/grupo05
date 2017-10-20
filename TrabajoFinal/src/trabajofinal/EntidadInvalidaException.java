package trabajofinal;

public class EntidadInvalidaException extends Exception
{
    
    private Entidad entidad;

    public EntidadInvalidaException(Entidad entidad, String mensaje)
    {
        super(mensaje);
        this.entidad = entidad;
    }
    
    public EntidadInvalidaException(Entidad entidad)
    {
        this.entidad = entidad;
    }

    public EntidadInvalidaException(){}

    public void setEntidad(Entidad entidad)
    {
        this.entidad = entidad;
    }

    public Entidad getEntidad()
    {
        return this.entidad;
    }

}
