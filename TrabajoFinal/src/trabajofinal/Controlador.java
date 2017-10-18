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
    
    public void altaAlumno(Alumno alumno) throws EntidadExistenteException
    {
        if (this.alumnos.containsValue(alumno))
            throw new EntidadExistenteException(alumno);
        this.alumnos.put(alumno.getId(), alumno);
    }
    
    public void altaProfesor(Profesor profesor) throws EntidadExistenteException
    {
        if (this.profesores.containsValue(profesor))
            throw new EntidadExistenteException(profesor);
        this.profesores.put(profesor.getId(), profesor);
    }
    
    public void altaAsignatura(Asignatura asignatura) throws EntidadExistenteException
    {
        if (this.asignaturas.containsValue(asignatura))
            throw new EntidadExistenteException(asignatura);
        this.asignaturas.put(asignatura.getId(), asignatura);
    }
    
    public void altaCursada(Cursada cursada) throws EntidadExistenteException, HorarioNoViableException
    {
        if (this.asignaturas.containsValue(cursada))
            throw new EntidadExistenteException(cursada);
        this.cursadas.put(cursada.getId(), cursada);
    }
    
    public void bajaAlumno(String legajo) throws IdNoExistenteException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdNoExistenteException(legajo);
        this.alumnos.remove(legajo);
        setChanged();
        notifyObservers(legajo);
    }
    
    public void bajaProfesor(String legajo) throws IdNoExistenteException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdNoExistenteException(legajo);
        this.profesores.remove(legajo);
        setChanged();
        notifyObservers(legajo);
    }
    
    public void bajaAsignatura(String identificacion) throws IdNoExistenteException
    {
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdNoExistenteException(identificacion);
        this.asignaturas.remove(identificacion);
        setChanged();
        notifyObservers(identificacion);
    }
    
    public void bajaCursada(String identificacion) throws IdNoExistenteException
    {
        if (!this.cursadas.containsKey(identificacion))
            throw new IdNoExistenteException(identificacion);
        this.cursadas.remove(identificacion);
        setChanged();
        notifyObservers(identificacion);
    }
    
    public void modificaAlumno(String legajo, String apellido, String nombre, String calle, int numero, String email)
    throws IdNoExistenteException, EmailInvalidoException
    {
        if(!this.alumnos.containsKey(legajo))
            throw new IdNoExistenteException(legajo);
        this.alumnos.get(legajo).modificar(apellido, nombre, calle, numero, email);
    }
    
    public void modificaProfesor(String legajo, String apellido, String nombre, String calle, int numero, String telefono, String email)
    throws IdNoExistenteException, EmailInvalidoException
    {
        if(!this.profesores.containsKey(legajo))
            throw new IdNoExistenteException(legajo);
        this.profesores.get(legajo).modificar(apellido, nombre, calle, numero, telefono, email);
    }
    
    public void modificaAsignatura(String identificacion, String nombre) throws IdNoExistenteException
    {
        if(!this.asignaturas.containsKey(identificacion))
            throw new IdNoExistenteException(identificacion);
        this.asignaturas.get(identificacion).setNombre(nombre);
    }
    
    public void modificaCursada(String identificacion, Asignatura asignatura, String periodo, String dia, String hora)
    throws IdNoExistenteException, PeriodoInvalidoException, HoraInvalidaException
    {
        if (!this.cursadas.containsKey(identificacion))
            throw new IdNoExistenteException(identificacion);
        this.cursadas.get(identificacion).modificar(asignatura, periodo, dia, hora);
    }
    
    public Iterator<Alumno> ubicaAlumno(String apellido, String nombre)
    {
        TreeMap<String, Alumno> coleccion= new TreeMap<String, Alumno>();
        Iterator<Alumno> iterator= alumnos.values().iterator();
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
        Iterator<Profesor> iterator= profesores.values().iterator();
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
        Iterator<Asignatura> iterator= asignaturas.values().iterator();
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
        Iterator<Cursada> iterator= cursadas.values().iterator();
        while(iterator.hasNext()){
            Cursada otro = iterator.next();
            if (otro.getAsignatura().equals(nombre))
                coleccion.put(otro.getId(), otro);
        }
        return coleccion.values().iterator();
    }
    
    public void aprobarAlumno(String legajo, String identificacion) throws IdNoExistenteException, EntidadExistenteException
    {
        if (!this.cursadas.containsKey(identificacion))
            throw new IdNoExistenteException(identificacion);
        this.cursadas.get(identificacion).aprobarAlumno(legajo);
    }
    
    public void addCompetencia(String legajo, String identificacion) throws IdNoExistenteException, EntidadExistenteException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdNoExistenteException(legajo);
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdNoExistenteException(identificacion);
        this.profesores.get(legajo).addCompetencia(this.asignaturas.get(identificacion));
    }
    
    public void removeCompetencia(String legajo, String identificacion) throws IdNoExistenteException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdNoExistenteException(legajo);
        this.profesores.get(legajo).removeCompetencia(identificacion);
    }
    
    public void addCorrelativa(String idAsignatura, String idCorrelativa) throws IdNoExistenteException, EntidadExistenteException
    {
        if (!this.asignaturas.containsKey(idAsignatura))
            throw new IdNoExistenteException(idAsignatura);
        if (!this.asignaturas.containsKey(idCorrelativa))
            throw new IdNoExistenteException(idCorrelativa);
        this.asignaturas.get(idAsignatura).addCorrelativa(this.asignaturas.get(idCorrelativa));
    }
    
    public void removeCorrelativa(String idAsignatura, String idCorrelativa) throws IdNoExistenteException
    {
        if (!this.asignaturas.containsKey(idAsignatura))
            throw new IdNoExistenteException(idAsignatura);
        this.asignaturas.get(idAsignatura).removeCorrelativa(idCorrelativa);
    }
    
    public void addAlumnoCursada(String legajo, String identificacion) throws IdNoExistenteException, EntidadExistenteException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdNoExistenteException(legajo);
        if (!this.cursadas.containsKey(identificacion))
            throw new IdNoExistenteException(identificacion);
        this.cursadas.get(identificacion).addAlumno(this.alumnos.get(legajo));
    }
    
    public void removeAlumnoCursada(String legajo, String identificacion) throws IdNoExistenteException
    {
        if (!this.cursadas.containsKey(identificacion))
            throw new IdNoExistenteException(identificacion);
        this.cursadas.get(identificacion).removeAlumno(legajo);
    }
    
    public void addProfesorCursada(String legajo, String identificacion) throws IdNoExistenteException, EntidadExistenteException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdNoExistenteException(legajo);
        if (!this.cursadas.containsKey(identificacion))
            throw new IdNoExistenteException(identificacion);
        this.cursadas.get(identificacion).addProfesor(this.profesores.get(legajo));
    }
    
    public void removeProfesorCursada(String legajo, String identificacion) throws IdNoExistenteException
    {
        if (!this.cursadas.containsKey(identificacion))
            throw new IdNoExistenteException(identificacion);
        this.cursadas.get(identificacion).removeProfesor(legajo);
    }

}
