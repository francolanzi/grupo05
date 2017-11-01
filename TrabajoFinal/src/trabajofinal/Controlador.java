package trabajofinal;

import java.util.Iterator;
import java.util.Observable;
import java.util.TreeMap;

public class Controlador extends Observable
{
    
    private static Controlador controlador = null;
    
    private TreeMap<String, Alumno> alumnos;
    private TreeMap<String, Profesor> profesores;
    private TreeMap<String, Asignatura> asignaturas;
    private TreeMap<String, Cursada> cursadas;
    
    private Controlador()
    {
        this.alumnos = new TreeMap<String, Alumno>();
        this.profesores = new TreeMap<String, Profesor>();
        this.asignaturas = new TreeMap<String, Asignatura>();
        this.cursadas = new TreeMap<String,Cursada>();
    }
    
    public static Controlador getInstance()
    {
        if (controlador == null)
            controlador = new Controlador();
        return controlador;
    }
    
    public void altaAlumno(String apellido, String nombre, String calle, int numero, String telefono, String email)
    throws EmailInvalidoException
    {
        Alumno alumno = new Alumno(apellido, nombre, calle, numero, telefono, email);
        this.alumnos.put(alumno.getId(), alumno);
    }
    
    public void altaProfesor(String apellido, String nombre, String calle, int numero, String telefono, String email)
    throws EmailInvalidoException
    {
        Profesor profesor = new Profesor(apellido, nombre, calle, numero, telefono, email);
        this.profesores.put(profesor.getId(), profesor);
    }
    
    public void altaAsignatura(String nombre)
    {
        Asignatura asignatura = new Asignatura(nombre);
        this.asignaturas.put(asignatura.getId(), asignatura);
    }
    
    public void altaCursada(String identificacion, String periodo, String dia, String horaInicio, String horaFin)
    throws IdInvalidoException, PeriodoInvalidoException, HoraInvalidaException
    {
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        Cursada cursada = new Cursada(this.asignaturas.get(identificacion), periodo, dia, horaInicio, horaFin);
        this.cursadas.put(cursada.getId(), cursada);
    }
    
    public void bajaAlumno(String legajo) 
    throws IdInvalidoException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        this.alumnos.remove(legajo);
        setChanged();
        notifyObservers(legajo);
    }
    
    public void bajaProfesor(String legajo)
    throws IdInvalidoException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        this.profesores.remove(legajo);
        setChanged();
        notifyObservers(legajo);
    }
    
    public void bajaAsignatura(String identificacion)
    throws IdInvalidoException
    {
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        this.asignaturas.remove(identificacion);
        setChanged();
        notifyObservers(identificacion);
    }
    
    public void bajaCursada(String identificacion)
    throws IdInvalidoException
    {
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        this.cursadas.remove(identificacion);
    }
    
    public void modificaAlumno(String legajo, String apellido, String nombre, String calle, int numero, String telefono, String email)
    throws IdInvalidoException, EmailInvalidoException
    {
        if(!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        this.alumnos.get(legajo).modificar(apellido, nombre, calle, numero, telefono, email);
    }
    
    public void modificaProfesor(String legajo, String apellido, String nombre, String calle, int numero, String telefono, String email)
    throws IdInvalidoException, EmailInvalidoException
    {
        if(!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        this.profesores.get(legajo).modificar(apellido, nombre, calle, numero, telefono, email);
    }
    
    public void modificaAsignatura(String identificacion, String nombre)
    throws IdInvalidoException
    {
        if(!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        this.asignaturas.get(identificacion).setNombre(nombre);
    }
    
    public void modificaCursada(String identificacion, String periodo, String dia, String horaInicio, String horaFin)
    throws IdInvalidoException, PeriodoInvalidoException, HoraInvalidaException, HorarioNoViableException
    {
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        Iterator<Alumno> alumnos = this.getAlumnosIterator();
        boolean compatible = true;
        while (alumnos.hasNext() && compatible)
            compatible = this.compatibilidadHorariaAlumno(alumnos.next().getId(), periodo, dia, horaInicio, horaFin);
        if (!compatible)
            throw new HorarioNoViableException(periodo, dia, horaInicio, horaFin, "Algun alumno no puede cursar en ese horario");
        Iterator<Profesor> profesores = this.getProfesoresIterator();
        while (profesores.hasNext() && compatible)
            compatible = this.compatibilidadHorariaProfesor(profesores.next().getId(), periodo, dia, horaInicio, horaFin);
        if (!compatible)
            throw new HorarioNoViableException(periodo, dia, horaInicio, horaFin, "Algun profesor no puede cursar en ese horario");
        this.cursadas.get(identificacion).modificar(periodo, dia, horaInicio, horaFin);
    }
    
    public Iterator<Alumno> ubicaAlumno(String apellido, String nombre)
    {
        TreeMap<String, Alumno> retorno = new TreeMap<String, Alumno>();
        Iterator<Alumno> alumnos = this.getAlumnosIterator();
        while(alumnos.hasNext())
        {
            Alumno otro = alumnos.next();
            if (otro.getApellido().contains(apellido) && otro.getNombre().contains(nombre))
                retorno.put(otro.getId(), otro);
        }
        return retorno.values().iterator();
    }

    public Iterator<Profesor> ubicaProfesor(String apellido, String nombre)
    {
        TreeMap<String, Profesor> retorno = new TreeMap<String, Profesor>();
        Iterator<Profesor> profesores = this.getProfesoresIterator();
        while(profesores.hasNext())
        {
            Profesor otro = profesores.next();
            if (otro.getApellido().contains(apellido) && otro.getNombre().contains(nombre))
                retorno.put(otro.getId(), otro);
        }
        return retorno.values().iterator();
    }
    
    public Iterator<Asignatura> ubicaAsignatura(String nombre)
    {
        TreeMap<String, Asignatura> retorno = new TreeMap<String, Asignatura>();
        Iterator<Asignatura> asignaturas = this.getAsignaturasIterator();
        while(asignaturas.hasNext())
        {
            Asignatura otro = asignaturas.next();
            if (otro.getNombre().contains(nombre))
                retorno.put(otro.getId(), otro);
        }
        return retorno.values().iterator();
    }
    
    public Iterator<Cursada> ubicaCursada(String nombre)
    {
        TreeMap<String, Cursada> retorno = new TreeMap<String, Cursada>();
        Iterator<Cursada> cursadas = this.getCursadasIterator();
        while(cursadas.hasNext())
        {
            Cursada otro = cursadas.next();
            if (otro.getAsignatura().getNombre().contains(nombre))
                retorno.put(otro.getId(), otro);
        }
        return retorno.values().iterator();
    }
    
    public Alumno consultaAlumno(String legajo)
    throws IdInvalidoException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        return this.alumnos.get(legajo);
    }
    
    public Profesor consultaProfesor(String legajo)
    throws IdInvalidoException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        return this.profesores.get(legajo);
    }
    
    public Asignatura consultaAsignatura(String identificacion)
    throws IdInvalidoException
    {
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        return this.asignaturas.get(identificacion);
    }
    
    public Cursada consultaCursada(String identificacion)
    throws IdInvalidoException
    {
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        return this.cursadas.get(identificacion);
    }
    
    public void aprobarAlumno(String legajo, String identificacion)
    throws IdInvalidoException, EntidadInvalidaException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        this.cursadas.get(identificacion).aprobarAlumno(legajo);
    }
    
    public void removeAsignaturaAlumno(String legajo, String identificacion)
    throws IdInvalidoException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        Alumno alumno = this.alumnos.get(legajo);
        Iterator<Asignatura> historia = alumno.getHistoriaIterator();
        boolean correlativa = true;
        while (historia.hasNext() && !correlativa)
            correlativa = historia.next().isCorrelativa(identificacion);
        if (correlativa)
            throw new IdInvalidoException(identificacion, "La asignatura no puede ser removida");
        alumno.removeAsignatura(identificacion);
        Iterator<Cursada> cursadas = this.getCursadasIterator();
        while (cursadas.hasNext())
        {
            Cursada cursada = cursadas.next();
            if (cursada.hasAlumno(legajo) && cursada.getAsignatura().getId().equals(identificacion))
                cursada.removeAlumno(legajo);
        }
    }
    
    public void addCompetencia(String legajo, String identificacion)
    throws IdInvalidoException, EntidadInvalidaException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        this.profesores.get(legajo).addCompetencia(this.asignaturas.get(identificacion));
    }
    
    public void removeCompetencia(String legajo, String identificacion)
    throws IdInvalidoException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        this.profesores.get(legajo).removeCompetencia(identificacion);
        Iterator<Cursada> cursadas = this.getCursadasIterator();
        while (cursadas.hasNext())
        {
            Cursada cursada = cursadas.next();
            if (cursada.hasProfesor(legajo) && cursada.getAsignatura().getId().equals(identificacion))
                cursada.removeProfesor(legajo);
        }
    }
    
    public void addCorrelativa(String idAsignatura, String idCorrelativa)
    throws IdInvalidoException, EntidadInvalidaException
    {
        if (!this.asignaturas.containsKey(idAsignatura))
            throw new IdInvalidoException(idAsignatura, "La asignatura ingresada no existe");
        if (!this.asignaturas.containsKey(idCorrelativa))
            throw new IdInvalidoException(idCorrelativa, "La correlativa ingresada no existe");
        this.asignaturas.get(idAsignatura).addCorrelativa(this.asignaturas.get(idCorrelativa));
    }
    
    public void removeCorrelativa(String idAsignatura, String idCorrelativa)
    throws IdInvalidoException
    {
        if (!this.asignaturas.containsKey(idAsignatura))
            throw new IdInvalidoException(idAsignatura, "La asignatura ingresada no existe");
        if (!this.asignaturas.containsKey(idCorrelativa))
            throw new IdInvalidoException(idCorrelativa, "La correlativa ingresada no existe");
        this.asignaturas.get(idAsignatura).removeCorrelativa(idCorrelativa);
    }
    
    private boolean compatibilidadHorariaAlumno(String legajo, Cursada cursada)
    {
        return this.compatibilidadHorariaAlumno(legajo, cursada.getPeriodo(), cursada.getDia(),
                                                cursada.getHoraInicio(), cursada.getHoraFin());
    }
    
    private boolean compatibilidadHorariaProfesor(String legajo, Cursada cursada)
    {
        return this.compatibilidadHorariaProfesor(legajo, cursada.getPeriodo(), cursada.getDia(),
                                                  cursada.getHoraInicio(), cursada.getHoraFin());
    }
    
    private boolean compatibilidadHorariaAlumno(String legajo, String periodo, String dia, String horaInicio, String horaFin)
    {
        Iterator<Cursada> cursadas = this.getCursadasIterator();
        boolean retorno = true;
        while (retorno && cursadas.hasNext())
        {
            Cursada cursada = cursadas.next();
            retorno = !cursada.hasAlumno(legajo) || cursada.isCompatible(periodo, dia, horaInicio, horaFin);
        }
        return retorno;
    }
    
    private boolean compatibilidadHorariaProfesor(String legajo, String periodo, String dia, String horaInicio, String horaFin)
    {
        Iterator<Cursada> cursadas = this.getCursadasIterator();
        boolean retorno = true;
        while (retorno && cursadas.hasNext())
        {
            Cursada cursada = cursadas.next();
            retorno = !cursada.hasProfesor(legajo) || cursada.isCompatible(periodo, dia, horaInicio, horaFin);
        }
        return retorno;
    }
    
    public void addAlumnoCursada(String legajo, String identificacion)
    throws IdInvalidoException, EntidadInvalidaException, HorarioNoViableException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        Cursada cursada = this.cursadas.get(identificacion);
        Alumno alumno = this.alumnos.get(legajo);
        if (!this.compatibilidadHorariaAlumno(legajo, cursada))
            throw new HorarioNoViableException(alumno, cursada, "El alumno no puede cursar en ese horario");
        cursada.addAlumno(alumno);
    }
    
    public void removeAlumnoCursada(String legajo, String identificacion)
    throws IdInvalidoException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        this.cursadas.get(identificacion).removeAlumno(legajo);
    }
    
    public void addProfesorCursada(String legajo, String identificacion)
    throws IdInvalidoException, EntidadInvalidaException, HorarioNoViableException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        Cursada cursada = this.cursadas.get(identificacion);
        Profesor profesor = this.profesores.get(legajo);
        if (!this.compatibilidadHorariaProfesor(legajo, this.cursadas.get(identificacion)))
            throw new HorarioNoViableException(profesor, cursada, "El profesor no puede dar clases en ese horario");
        this.cursadas.get(identificacion).addProfesor(this.profesores.get(legajo));
    }
    
    public void removeProfesorCursada(String legajo, String identificacion)
    throws IdInvalidoException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        this.cursadas.get(identificacion).removeProfesor(legajo);
    }
    
    public Iterator<Alumno> getAlumnosIterator()
    {
        return this.alumnos.values().iterator();
    }
    
    public Iterator<Profesor> getProfesoresIterator()
    {
        return this.profesores.values().iterator();
    }
    
    public Iterator<Asignatura> getAsignaturasIterator()
    {
        return this.asignaturas.values().iterator();
    }
    
    public Iterator<Cursada> getCursadasIterator()
    {
        return this.cursadas.values().iterator();
    }

    //Getters y setters
    //Necesarios para serializar en XML

    public void setAlumnos(TreeMap<String, Alumno> alumnos)
    {
        this.alumnos = alumnos;
    }

    public TreeMap<String, Alumno> getAlumnos()
    {
        return this.alumnos;
    }

    public void setProfesores(TreeMap<String, Profesor> profesores)
    {
        this.profesores = profesores;
    }

    public TreeMap<String, Profesor> getProfesores()
    {
        return this.profesores;
    }

    public void setAsignaturas(TreeMap<String, Asignatura> asignaturas)
    {
        this.asignaturas = asignaturas;
    }

    public TreeMap<String, Asignatura> getAsignaturas()
    {
        return this.asignaturas;
    }

    public void setCursadas(TreeMap<String, Cursada> cursadas)
    {
        this.cursadas = cursadas;
    }

    public TreeMap<String, Cursada> getCursadas()
    {
        return this.cursadas;
    }

}
