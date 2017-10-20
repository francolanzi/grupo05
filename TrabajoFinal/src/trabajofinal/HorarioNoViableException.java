package trabajofinal;

public class HorarioNoViableException extends Exception
{
    
    private Entidad entidad;
    private Cursada cursada;
    
    public HorarioNoViableException(Entidad entidad, Cursada cursada, String mensaje)
    {
        super(mensaje);
        this.entidad = entidad;
        this.cursada = cursada;
    }

    public HorarioNoViableException(Entidad entidad, Cursada cursada)
    {
        this.entidad = entidad;
        this.cursada = cursada;
    }

    public Entidad getEntidad()
    {
        return this.entidad;
    }

    public Cursada getCursada()
    {
        return this.cursada;
    }

}
