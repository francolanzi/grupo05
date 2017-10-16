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
    
    public void altaAlumno(Alumno alumno) throws AltaException
    {
        if (this.alumnos.containsValue(alumno))
            throw new AltaException(alumno);
        else
            this.alumnos.put(alumno.getId(), alumno);
    }
    
    public void altaProfesor(Profesor profesor) throws AltaException
    {
        if (this.profesores.containsValue(profesor))
            throw new AltaException(profesor);
        else
            this.profesores.put(profesor.getId(), profesor);
    }
    
    public void altaAsignatura(Asignatura asignatura) throws AltaException
    {
        if (this.asignaturas.containsValue(asignatura))
            throw new AltaException(asignatura);
        else
            this.asignaturas.put(asignatura.getId(), asignatura);
    }
    
    public void bajaAlumno(String legajo) throws BajaException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new BajaException(legajo);
        else
        {
            this.alumnos.remove(legajo);
            setChanged();
            notifyObservers(legajo);
        }
    }
    
    public void bajaProfesor(String legajo) throws BajaException
    {
        if (!this.profesores.containsKey(legajo))
            throw new BajaException(legajo);
        else
        {
            this.profesores.remove(legajo);
            setChanged();
            notifyObservers(legajo);
        }
    }
    
    public void bajaAsignatura(String identificacion) throws BajaException
    {
        if (!this.asignaturas.containsKey(identificacion))
            throw new BajaException(identificacion);
        else
        {
            this.asignaturas.remove(identificacion);
            setChanged();
            notifyObservers(identificacion);
        }
    }

}
