package trabajofinal;

public class HorarioNoViableException extends Exception
{
    
    private Cursada cursada;

    public HorarioNoViableException(Cursada cursada)
    {
        this.cursada = cursada;
    }

}
