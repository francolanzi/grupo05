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
    }
    
    public static Controlador getInstance()
    {
        if (controlador == null)
            controlador = new Controlador();
        return controlador;
    }
    
}
