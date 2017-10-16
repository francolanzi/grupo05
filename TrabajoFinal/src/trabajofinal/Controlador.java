package trabajofinal;

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
        else
            this.alumnos.put(alumno.getId(), alumno);
    }
    
    public void altaProfesor(Profesor profesor) throws EntidadExistenteException
    {
        if (this.profesores.containsValue(profesor))
            throw new EntidadExistenteException(profesor);
        else
            this.profesores.put(profesor.getId(), profesor);
    }
    
    public void altaAsignatura(Asignatura asignatura) throws EntidadExistenteException
    {
        if (this.asignaturas.containsValue(asignatura))
            throw new EntidadExistenteException(asignatura);
        else
            this.asignaturas.put(asignatura.getId(), asignatura);
    }
    
    public void bajaAlumno(String legajo) throws IdNoExistenteException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdNoExistenteException(legajo);
        else
        {
            this.alumnos.remove(legajo);
            setChanged();
            notifyObservers(legajo);
        }
    }
    
    public void bajaProfesor(String legajo) throws IdNoExistenteException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdNoExistenteException(legajo);
        else
        {
            this.profesores.remove(legajo);
            setChanged();
            notifyObservers(legajo);
        }
    }
    
    public void bajaAsignatura(String identificacion) throws IdNoExistenteException
    {
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdNoExistenteException(identificacion);
        else
        {
            this.asignaturas.remove(identificacion);
            setChanged();
            notifyObservers(identificacion);
        }
    }
    
    public void modificaAlumno(String legajo, String apellido, String nombre, String calle, int numero, String email) throws IdNoExistenteException, EmailInvalidoException
    {
        if(!this.alumnos.containsKey(legajo))
            throw new IdNoExistenteException(legajo);
        else
            this.alumnos.get(legajo).modificar(apellido, nombre, calle, numero, email);
    }
    
    public void modificaProfesor(String legajo, String apellido, String nombre, String calle, int numero, String telefono, String email) throws IdNoExistenteException, EmailInvalidoException
    {
        if(!this.profesores.containsKey(legajo))
            throw new IdNoExistenteException(legajo);
        else
            this.profesores.get(legajo).modificar(apellido, nombre, calle, numero, telefono, email);
    }
    
    public void modificaAsignatura(String identificacion, String nombre) throws IdNoExistenteException
    {
        if(!this.asignaturas.containsKey(identificacion))
            throw new IdNoExistenteException(identificacion);
        else
            this.asignaturas.get(identificacion).setNombre(nombre);
    }

}
