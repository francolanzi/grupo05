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
    
    public void altaAlumno(String apellido, String nombre, String calle, int numero, String email)
    throws EmailInvalidoException
    {
        Alumno alumno = new Alumno(apellido, nombre, calle, numero, email);
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
        setChanged();
        notifyObservers(identificacion);
    }
    
    public void modificaAlumno(String legajo, String apellido, String nombre, String calle, int numero, String email)
    throws IdInvalidoException, EmailInvalidoException
    {
        if(!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        this.alumnos.get(legajo).modificar(apellido, nombre, calle, numero, email);
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
    
    public void modificaCursada(String idCursada, String idAsignatura, String periodo, String dia, String horaInicio, String horaFin)
    throws IdInvalidoException, PeriodoInvalidoException, HoraInvalidaException
    {
        if (!this.cursadas.containsKey(idCursada))
            throw new IdInvalidoException(idCursada, "La cursada ingresada no existe");
        if (!this.asignaturas.containsKey(idAsignatura))
            throw new IdInvalidoException(idAsignatura, "La cursada ingresada no existe");
        this.cursadas.get(idCursada).modificar(this.asignaturas.get(idAsignatura), periodo, dia, horaInicio, horaFin);
    }
    
    public Iterator<Alumno> ubicaAlumno(String apellido, String nombre)
    {
        TreeMap<String, Alumno> coleccion= new TreeMap<String, Alumno>();
        Iterator<Alumno> iterator = alumnos.values().iterator();
        while(iterator.hasNext()){
            Alumno otro = iterator.next();
            if (otro.getApellido().equals(apellido) && otro.getNombre().equals(nombre))
                coleccion.put(otro.getId(), otro);
        }
        return coleccion.values().iterator();
    }

    public Iterator<Profesor> ubicaProfesor(String apellido, String nombre)
    {
        TreeMap<String, Profesor> coleccion= new TreeMap<String, Profesor>();
        Iterator<Profesor> iterator = profesores.values().iterator();
        while(iterator.hasNext()){
            Profesor otro = iterator.next();
            if (otro.getApellido().equals(apellido) && otro.getNombre().equals(nombre))
                coleccion.put(otro.getId(), otro);
        }
        return coleccion.values().iterator();
    }
    
    public Iterator<Asignatura> ubicaAsignatura(String nombre)
    {
        TreeMap<String, Asignatura> coleccion= new TreeMap<String, Asignatura>();
        Iterator<Asignatura> iterator = asignaturas.values().iterator();
        while(iterator.hasNext()){
            Asignatura otro = iterator.next();
            if (otro.getNombre().equals(nombre))
                coleccion.put(otro.getId(), otro);
        }
        return coleccion.values().iterator();
    }
    
    public Iterator<Cursada> ubicaCursada(String nombre)
    {
        TreeMap<String, Cursada> coleccion= new TreeMap<String, Cursada>();
        Iterator<Cursada> iterator = cursadas.values().iterator();
        while(iterator.hasNext()){
            Cursada otro = iterator.next();
            if (otro.getAsignatura().equals(nombre))
                coleccion.put(otro.getId(), otro);
        }
        return coleccion.values().iterator();
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
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        this.cursadas.get(identificacion).aprobarAlumno(legajo);
    }
    
    public void addCompetencia(String legajo, String identificacion)
    throws IdInvalidoException, EntidadInvalidaException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "El profesor ingresado no existe");
        this.profesores.get(legajo).addCompetencia(this.asignaturas.get(identificacion));
    }
    
    public void removeCompetencia(String legajo, String identificacion)
    throws IdInvalidoException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        this.profesores.get(legajo).removeCompetencia(identificacion);
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
        this.asignaturas.get(idAsignatura).removeCorrelativa(idCorrelativa);
    }
    
    private boolean compatibilidadHorariaAlumno(String legajo, Cursada cursada)
    {
        Iterator<Cursada> cursadas = this.cursadas.values().iterator();
        boolean retorno = true;
        while (retorno && cursadas.hasNext())
        {
            Cursada otra = cursadas.next();
            retorno = !(otra.hasAlumno(legajo) && otra.getPeriodo().equals(cursada.getPeriodo()) &&
            otra.getDia().equals(cursada.getDia()) && otra.getHoraInicio().compareTo(cursada.getHoraFin()) < 0
            && otra.getHoraFin().compareTo(cursada.getHoraInicio()) > 0);
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
        if (!this.compatibilidadHorariaAlumno(legajo, this.cursadas.get(identificacion)))
            throw new HorarioNoViableException(alumno, cursada, "El alumno no puede cursar en ese horario");
        cursada.addAlumno(alumno);
    }
    
    public void removeAlumnoCursada(String legajo, String identificacion)
    throws IdInvalidoException
    {
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        this.cursadas.get(identificacion).removeAlumno(legajo);
    }
    
    private boolean compatibilidadHorariaProfesor(String legajo, Cursada cursada)
    {
        Iterator<Cursada> cursadas = this.cursadas.values().iterator();
        boolean retorno = true;
        while (retorno && cursadas.hasNext())
        {
            Cursada otra = cursadas.next();
            retorno = !(otra.hasProfesor(legajo) && otra.getPeriodo().equals(cursada.getPeriodo()) &&
            otra.getDia().equals(cursada.getDia()) && otra.getHoraInicio().compareTo(cursada.getHoraFin()) < 0
            && otra.getHoraFin().compareTo(cursada.getHoraInicio()) > 0);
        }
        return retorno;
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
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        this.cursadas.get(identificacion).removeProfesor(legajo);
    }

}
