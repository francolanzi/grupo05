package trabajofinal;

public class EmailInvalidoException extends Exception
{
    
    private String email;

    public EmailInvalidoException(String email)
    {
        this.email = email;
    }

}
