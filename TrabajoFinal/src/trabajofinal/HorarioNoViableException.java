package trabajofinal;

public class HorarioNoViableException extends Exception
{
    
    private String periodo;
    private String dia;
    private String hora;

    public HorarioNoViableException(String periodo, String dia, String hora)
    {
        super();
        this.periodo = periodo;
        this.dia = dia;
        this.hora = hora;
    }

}
