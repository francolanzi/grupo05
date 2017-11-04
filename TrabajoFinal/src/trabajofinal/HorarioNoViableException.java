package trabajofinal;

public class HorarioNoViableException extends Exception
{
    
    //..........................................INSPECCION..........................................
    //Si bien en la interfaz la informacion de las excepciones es irrelevante, salvo por elmensaje,
    //es necesario que brinden dicha informacion ya que podrian llegar hasta una zona del codigo
    //donde sea importante conocer los detalles sobre lo que dio origen a la excepcion
    
    private Entidad entidad;
    private String periodo;
    private String dia;
    private String horaInicio;
    private String horaFin;
    
    public HorarioNoViableException(Entidad entidad, Cursada cursada, String mensaje)
    {
        this(entidad, cursada.getPeriodo(), cursada.getDia(), cursada.getHoraInicio(), cursada.getHoraFin(), mensaje);
    }

    public HorarioNoViableException(Entidad entidad, String periodo, String dia, String horaInicio, String horaFin, String mensaje)
    {
        super(mensaje);
        this.entidad = entidad;
        this.periodo = periodo;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    public HorarioNoViableException(Cursada cursada, String mensaje)
    {
        this(cursada.getPeriodo(), cursada.getDia(), cursada.getHoraInicio(), cursada.getHoraFin(), mensaje);
    }
    
    public HorarioNoViableException(String periodo, String dia, String horaInicio, String horaFin, String mensaje)
    {
        this(null, periodo, dia, horaInicio, horaFin, mensaje);
    }

    public Entidad getEntidad()
    {
        return this.entidad;
    }

    public String getPeriodo()
    {
        return this.periodo;
    }

    public String getDia()
    {
        return this.dia;
    }

    public String getHoraInicio()
    {
        return this.horaInicio;
    }

    public String getHoraFin()
    {
        return this.horaFin;
    }

}
