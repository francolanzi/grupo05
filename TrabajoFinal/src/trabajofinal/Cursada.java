package trabajofinal;

import java.util.Iterator;
import java.util.TreeMap;

public class Cursada implements Entidad
{
    
    private static int sigIdentificacion = 0;
    private static final String prefijo = "CUR";
    
    private String identificacion;
    private Asignatura asignatura;
    private String periodo;
    private String dia;
    private String horaInicio;
    private String horaFin;
    private ObserverTreeMap<Profesor> profesores;
    private ObserverTreeMap<Alumno> alumnos;

    public Cursada(Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin) throws PeriodoInvalidoException, HoraInvalidaException
    {
        this.modificar(asignatura, periodo, dia, horaInicio, horaFin);
        this.identificacion = Mascaras.genId(sigIdentificacion++, prefijo);
        this.profesores = new ObserverTreeMap<Profesor>();
        this.alumnos = new ObserverTreeMap<Alumno>();
    }
    
    public void addAlumno(Alumno alumno) throws EntidadExistenteException
    {
        this.alumnos.add(alumno);
    }
    
    public void addProfesor(Profesor profesor) throws EntidadExistenteException
    {
        this.profesores.add(profesor);
    }
    
    public void removeAlumno(String legajo) throws IdNoExistenteException
    {
        this.alumnos.remove(legajo);
    }
    
    public void removeProfesor(String legajo) throws IdNoExistenteException
    {
        this.profesores.remove(legajo);
    }

    @Override
    public String getId()
    {
        return this.identificacion;
    }

    public Asignatura getAsignatura()
    {
        return this.asignatura;
    }

    public void modificar(Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin) throws PeriodoInvalidoException, HoraInvalidaException
    {
        if (!Mascaras.periodoValido(periodo))
            throw new PeriodoInvalidoException(periodo);
        if (!Mascaras.horaValida(horaInicio))
            throw new HoraInvalidaException(horaInicio);
        if (!Mascaras.horaValida(horaFin))
            throw new HoraInvalidaException(horaFin);
        this.asignatura = asignatura;
        this.periodo = periodo;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    public void aprobarAlumno(String legajo) throws IdNoExistenteException, EntidadExistenteException
    {
        this.alumnos.remove(legajo).aprobarAsignatura(asignatura);
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Cursada))
        {
            return false;
        }
        final Cursada other = (Cursada) object;
        if (!(identificacion == null? other.identificacion == null: identificacion.equals(other.identificacion)))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((identificacion == null)? 0: identificacion.hashCode());
        return result;
    }

}
