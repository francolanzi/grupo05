package model;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

public class Cursada implements Entidad, Observer
{
    
    private static int sigIdentificacion = 0;
    public static final String PREFIJO = "CUR";
    
    private String identificacion;
    private Asignatura asignatura;
    private String periodo;
    private String dia;
    private String horaInicio;
    private String horaFin;
    private ObserverTreeMap<Profesor> profesores;
    private ObserverTreeMap<Alumno> alumnos;

    /**
     * Constructor de la clase Cursada
     * <br>
     * <b>Pre:</b> asignatura y dia son validos
     * <br>
     * <b>Post:</b> se ha creado una nueva cursada con una nueva identificacion unica
     * @param asignatura Asignatura de la cursada
     * @param periodo Periodo de la cursada
     * @param dia Dia de la cursada
     * @param horaInicio Hora de inicio de la cursada
     * @param horaFin Hora de finalizacion de la cursada
     * @throws model.PeriodoInvalidoException El periodo no cumple con la mascara CC-AAAA
     * @throws model.HoraInvalidaException La hora no existe o no cumple con la mascara 99:99
     */
    public Cursada(Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin)
    throws PeriodoInvalidoException, HoraInvalidaException
    {
        this.modificar(periodo, dia, horaInicio, horaFin);
        this.identificacion = Mascaras.genId(sigIdentificacion++, PREFIJO);
        this.asignatura = asignatura;
        this.profesores = new ObserverTreeMap<Profesor>();
        this.alumnos = new ObserverTreeMap<Alumno>();
        Controlador.getInstance().addObserver(this);
    }
    
    //...................................................INSPECCION...................................................
    //Las verificaciones del periodo y la hora se realizan dentro de la clase para asegurar la integridad de la misma
    
    public void modificar(String periodo, String dia, String horaInicio, String horaFin)
    throws PeriodoInvalidoException, HoraInvalidaException
    {
        if (!Mascaras.periodoValido(periodo))
            throw new PeriodoInvalidoException(periodo, "El periodo ingresado es invalido");
        if (!Mascaras.horaValida(horaInicio))
            throw new HoraInvalidaException(horaInicio, "La hora de inicio es invalida");
        if (!Mascaras.horaValida(horaFin))
            throw new HoraInvalidaException(horaFin, "La hora de finalizacion es invalida");
        if (horaFin.compareTo(horaInicio) <= 0)
            throw new HoraInvalidaException(horaFin, "La hora de finalizacion es menor a la de inicio");
        this.periodo = periodo;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    @Override
    public String getId()
    {
        return this.identificacion;
    }

    /**
     * Agrega un alumno a la cursada
     * <br>
     * <b>Pre:</b> el alumno es valido
     * <br>
     * <b>Post:</b> el alumno ha sido agregado a la cursada
     * @param alumno Alumno a agregar
     * @throws model.EntidadInvalidaException El alumno ya ha aprobado la asignatura o no esta habilitado a cursarla
     */
    public void addAlumno(Alumno alumno) throws EntidadInvalidaException
    {
        if (alumno.isAprobada(this.asignatura.getId()))
            throw new EntidadInvalidaException(alumno, "El alumno ya ha aprobado la asignatura");
        boolean agregar = true;
        Iterator<Asignatura> correlativas = this.asignatura.getCorrelativasIterator();
        while (agregar && correlativas.hasNext())
            agregar = alumno.isAprobada(correlativas.next().getId());
        if (!agregar)
            throw new EntidadInvalidaException(alumno, "El alumno no esta habilitado a cursar la asignatura");
        this.alumnos.add(alumno);
    }

    /**
     * Agregar un profesor a la cursada
     * <br>
     * <b>Pre:</b> el profesor es valido
     * <br>
     * <b>Post:</b> el profesor ha sido agregado a la cursada
     * @param profesor Profesor a agregar
     * @throws model.EntidadInvalidaException El profesor no es competente para la asignatura
     */
    public void addProfesor(Profesor profesor)
    throws EntidadInvalidaException
    {
        if (!profesor.isCompetente(this.asignatura.getId()))
            throw new EntidadInvalidaException(profesor, "El profesor no es competente");
        this.profesores.add(profesor);
    }

    /**
     * Elimina un alumno de la cursada
     * <br>
     * <b>Post:</b> el alumno ha sido eliminado de la cursada
     * @param legajo Legajo del alumno a eliminar
     * @throws model.IdInvalidoException El alumno no esta en la cursada
     */
    public void removeAlumno(String legajo) throws IdInvalidoException
    {
        try
        {
            this.alumnos.remove(legajo);
        }
        catch (IdInvalidoException e)
        {
            throw new IdInvalidoException(e.getId(), "El alumno no esta en la cursada");
        }
    }

    /**
     * Elimina a un profesor de la cursada
     * <br>
     * <b>Post:</b> el profesor ha sido eliminado de la cursada
     * @param legajo Legajo del profesor a eliminar
     * @throws model.IdInvalidoException El profesor no esta en la cursada
     */
    public void removeProfesor(String legajo) throws IdInvalidoException
    {
        try
        {
            this.profesores.remove(legajo);
        }
        catch (IdInvalidoException e)
        {
            throw new IdInvalidoException(e.getId(), "El profesor no esta en la cursada");
        }
    }

    /**
     * Verifica si un alumno pertenece a la cursada
     * @param legajo Legajo del alumno
     * @return true si el alumno pertence a la cursada, false en caso contrario
     */
    public boolean hasAlumno(String legajo)
    {
        return this.alumnos.contains(legajo);
    }

    /**
     * Verifica si un profesor pertenece a la cursada
     * @param legajo Legajo del profesor
     * @return true si el profesor pertenece a la cursada, false en caso contrario
     */
    public boolean hasProfesor(String legajo)
    {
        return this.profesores.contains(legajo);
    }

    /**
     * Agrega la asignatura a la historia de un alumno y lo elimina de la cursada
     * <br>
     * <b>Post:</b> la asignatura ha sido agregada a la historia del alumno
     * y el alumno ha sido eliminado de la cursada
     * @param legajo Legajo del alumno a aprobar
     * @throws model.IdInvalidoException El alumno no esta en la cursada
     * @throws model.EntidadInvalidaException La asignatura ya se encuentra en la historia del alumno
     */
    public void aprobarAlumno(String legajo) throws IdInvalidoException, EntidadInvalidaException
    {
        try
        {
            this.alumnos.remove(legajo).aprobarAsignatura(asignatura);
        }
        catch (IdInvalidoException e)
        {
            throw new IdInvalidoException(e.getId(), "El alumno ingresado no esta en la cursada");
        }
    }

    /**
     * Verifica si la cursada no se superpone con otra
     * <br>
     * <b>Pre:</b> periodo, dia, horaInicio y horaFin son validos
     * @param periodo Periodo de la otra cursada
     * @param dia Dia de la otra cursada
     * @param horaInicio Hora de inicio de la otra cursada
     * @param horaFin Hora de finalizacion de la otra cursada
     * @return true si las cursadas no se superponen, false en caso contrario
     */
    public boolean isCompatible(String periodo, String dia, String horaInicio, String horaFin)
    {
        return !(this.getPeriodo().equals(periodo) && this.getDia().equals(dia)
        && this.getHoraInicio().compareTo(horaFin) < 0
        && this.getHoraFin().compareTo(horaInicio) > 0);
    }

    public Iterator<Profesor> getProfesoresIterator()
    {
        return this.profesores.getIterator();
    }

    public Iterator<Alumno> getAlumnosIterator()
    {
        return this.alumnos.getIterator();
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
    
/*.........................................Constructor vacío, getters y setters.........................................
.............................................Necesarios para serializar en XML........................................*/

    public Cursada(){}

    public static void setSigIdentificacion(int sigIdentificacion)
    {
        Cursada.sigIdentificacion = sigIdentificacion;
    }

    public static int getSigIdentificacion()
    {
        return Cursada.sigIdentificacion;
    }

    public void setIdentificacion(String identificacion)
    {
        this.identificacion = identificacion;
    }
    
    public String getIdentificacion()
    {
        return this.identificacion;
    }

    public void setAsignatura(Asignatura asignatura)
    {
        this.asignatura = asignatura;
    }

    public Asignatura getAsignatura()
    {
        return this.asignatura;
    }

    public void setPeriodo(String periodo)
    {
        this.periodo = periodo;
    }

    public String getPeriodo()
    {
        return this.periodo;
    }

    public void setDia(String dia)
    {
        this.dia = dia;
    }

    public String getDia()
    {
        return this.dia;
    }

    public void setHoraInicio(String horaInicio)
    {
        this.horaInicio = horaInicio;
    }

    public String getHoraInicio()
    {
        return this.horaInicio;
    }

    public void setHoraFin(String horaFin)
    {
        this.horaFin = horaFin;
    }

    public String getHoraFin()
    {
        return this.horaFin;
    }

    public void setProfesores(ObserverTreeMap<Profesor> profesores)
    {
        this.profesores = profesores;
    }

    public ObserverTreeMap<Profesor> getProfesores()
    {
        return this.profesores;
    }

    public void setAlumnos(ObserverTreeMap<Alumno> alumnos)
    {
        this.alumnos = alumnos;
    }

    public ObserverTreeMap<Alumno> getAlumnos()
    {
        return this.alumnos;
    }

}
