package model;

@SuppressWarnings("serial")
public class IdInvalidoException extends Exception
{
    
    //..........................................INSPECCION..........................................
    //Si bien en la interfaz la informacion de las excepciones es irrelevante, salvo por elmensaje,
    //es necesario que brinden dicha informacion ya que podrian llegar hasta una zona del codigo
    //donde sea importante conocer los detalles sobre lo que dio origen a la excepcion
    
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

    public IdInvalidoException(){}

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }

}
