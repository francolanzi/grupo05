package trabajofinal;

public class PeriodoInvalidoException extends Exception
{
    
    private String periodo;

    public PeriodoInvalidoException(String periodo)
    {
        this.periodo = periodo;
    }

}
