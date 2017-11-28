package model;

@SuppressWarnings("serial")
public class EntidadInvalidaException extends Exception
{
    
    //..........................................INSPECCION..........................................
    //Si bien en la interfaz la informacion de las excepciones es irrelevante, salvo por elmensaje,
    //es necesario que brinden dicha informacion ya que podrian llegar hasta una zona del codigo
    //donde sea importante conocer los detalles sobre lo que dio origen a la excepcion
    
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
