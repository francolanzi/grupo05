package trabajofinal;

public class EmailInvalidoException extends Exception
{
    
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
