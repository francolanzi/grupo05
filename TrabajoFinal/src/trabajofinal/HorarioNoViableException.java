package trabajofinal;

public class HorarioNoViableException extends Exception
{
    
    private Entidad entidad;
    private Cursada cursada;

    public HorarioNoViableException(Entidad entidad, Cursada cursada)
    {
        this.entidad = entidad;
        this.cursada = cursada;
    }

}
