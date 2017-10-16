package trabajofinal;

import java.util.TreeMap;

public class Cursada implements Entidad
{
    
    private static int sigIdentificacion = 0;
    private static final String prefijo = "CUR";
    
    private String identificacion;
    private Asignatura asignatura;
    private String periodo;
    private String dia;
    private String hora;
    private ObserverTreeMap<Profesor> profesores;
    private ObserverTreeMap<Alumno> alumnos;

    public Cursada(Asignatura asignatura, String periodo, String dia, String hora) throws PeriodoInvalidoException, HoraInvalidaException
    {
        if (!Mascaras.periodoValido(periodo))
            throw new PeriodoInvalidoException(periodo);
        if (!Mascaras.horaValida(hora))
            throw new HoraInvalidaException(hora);
        this.identificacion = Mascaras.genId(sigIdentificacion++, prefijo);
        this.asignatura = asignatura;
        this.periodo = periodo;
        this.dia = dia;
        this.hora = hora;
        this.profesores = new ObserverTreeMap<Profesor>();
        this.alumnos = new ObserverTreeMap<Alumno>();
    }

    @Override
    public String getId()
    {
        return this.identificacion;
    }


    public Asignatura getAsignatura() {
        return asignatura;
    }
}
