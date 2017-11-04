package trabajofinal;

public class EmailInvalidoException extends Exception
{
    
    //..........................................INSPECCION..........................................
    //Si bien en la interfaz la informacion de las excepciones es irrelevante, salvo por elmensaje,
    //es necesario que brinden dicha informacion ya que podrian llegar hasta una zona del codigo
    //donde sea importante conocer los detalles sobre lo que dio origen a la excepcion
    
    private String email;
    
    public EmailInvalidoException(String email, String mensaje)
    {
        super(mensaje);
        this.email = email;
    }

    public EmailInvalidoException(String email)
    {
        this.email = email;
    }

    public EmailInvalidoException(){}

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return this.email;
    }

}
