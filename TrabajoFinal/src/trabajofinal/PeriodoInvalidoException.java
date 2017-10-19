package trabajofinal;

public class PeriodoInvalidoException extends Exception
{
    
    private String periodo;

    public PeriodoInvalidoException(String periodo, String mensaje)
    {
        super(mensaje);
        this.periodo = periodo;
    }
    
    public PeriodoInvalidoException(String periodo)
    {
        this.periodo = periodo;
    }

    public String getPeriodo()
    {
        return this.periodo;
    }

}
