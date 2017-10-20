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

    public HorarioNoViableException(){}

    public void setEntidad(Entidad entidad)
    {
        this.entidad = entidad;
    }

    public Entidad getEntidad()
    {
        return this.entidad;
    }

    public void setCursada(Cursada cursada)
    {
        this.cursada = cursada;
    }

    public Cursada getCursada()
    {
        return this.cursada;
    }

}
