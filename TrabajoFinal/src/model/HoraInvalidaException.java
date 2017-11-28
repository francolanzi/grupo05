package model;

@SuppressWarnings("serial")
public class HoraInvalidaException extends Exception
{
    
    //..........................................INSPECCION..........................................
    //Si bien en la interfaz la informacion de las excepciones es irrelevante, salvo por elmensaje,
    //es necesario que brinden dicha informacion ya que podrian llegar hasta una zona del codigo
    //donde sea importante conocer los detalles sobre lo que dio origen a la excepcion
    
    private String hora;
    
    public HoraInvalidaException(String hora, String mensaje)
    {
        super(mensaje);
        this.hora = hora;
    }

    public HoraInvalidaException(String hora)
    {
        this.hora = hora;
    }
    
    public HoraInvalidaException(){}

    public void setHora(String hora)
    {
        this.hora = hora;
    }
    
    public String getHora()
    {
        return this.hora;
    }

}
