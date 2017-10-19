package trabajofinal;

public class HoraInvalidaException extends Exception
{
    
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

    public String getHora()
    {
        return this.hora;
    }

}
