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
        if (alumnos.containsValue(alumno))
            throw new AltaException(alumno);
        else
            alumnos.put(alumno.getId(), alumno);
    }
    
    public void altaProfesor(Profesor profesor) throws AltaException
    {
        if (profesores.containsValue(profesor))
            throw new AltaException(profesor);
        else
            profesores.put(profesor.getId(), profesor);
    }
    
    public void altaAsignatura(Asignatura asignatura) throws AltaException
    {
        if (asignaturas.containsValue(asignatura))
            throw new AltaException(asignatura);
        else
            asignaturas.put(asignatura.getId(), asignatura);
    }

    public TreeMap<String, Alumno> getAlumnos() {
        return alumnos;
    }

    public TreeMap<String, Profesor> getProfesores() {
        return profesores;
    }

    public TreeMap<String, Asignatura> getAsignaturas() {
        return asignaturas;
    }

}
