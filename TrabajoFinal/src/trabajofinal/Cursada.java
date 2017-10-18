package trabajofinal;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

public class Cursada implements Entidad, Observer
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
        Controlador.getInstance().addObserver(this);
    }
    
    public void addAlumno(Alumno alumno) throws EntidadInvalidaException
    {
        Iterator<Asignatura> historia = alumno.getHistoria();
        Iterator<Asignatura> correlativas = this.asignatura.getCorrelativas();
        int cantCorrelativas = 0;
        while (correlativas.hasNext())
        {
            correlativas.next();
            cantCorrelativas++;
        }
        while (historia.hasNext() && cantCorrelativas > 0)
        {
            Asignatura asignatura = historia.next();
            correlativas = this.asignatura.getCorrelativas();
            boolean aprobada = false;
            while (correlativas.hasNext() && !aprobada)
                aprobada = correlativas.next().equals(asignatura);
            if (aprobada)
                cantCorrelativas--;
            
        }
        if (cantCorrelativas > 0)
            throw new EntidadInvalidaException(alumno);
        this.alumnos.add(alumno);
    }
    
    public void addProfesor(Profesor profesor) throws EntidadInvalidaException
    {
        Iterator<Asignatura> competencias = profesor.getCompetencias();
        boolean competente = false;
        while (competencias.hasNext() && !competente)
            competente = competencias.next().getId().equals(this.asignatura.getId());
        if (!competente)
            throw new EntidadInvalidaException(profesor);
        this.profesores.add(profesor);
    }
    
    public void removeAlumno(String legajo) throws IdInvalidoException
    {
        this.alumnos.remove(legajo);
    }
    
    public void removeProfesor(String legajo) throws IdInvalidoException
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
    
    public Iterator<Profesor> getProfesores()
    {
        return this.profesores.getIterator();
    }
    
    public Iterator<Alumno> getAlumno()
    {
        return this.alumnos.getIterator();
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
    
    public void aprobarAlumno(String legajo) throws IdInvalidoException, EntidadInvalidaException
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

    @Override
    public void update(Observable observable, Object object)
    {
        if (observable == Controlador.getInstance() && this.asignatura.getId().equals(object))
            try
            {
                Controlador.getInstance().bajaCursada(this.identificacion);
            }
            catch (IdInvalidoException e){}
    }
}
