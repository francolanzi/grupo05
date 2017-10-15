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
    
    public void altaAlumno(Alumno alu) throws Exception_Entidad_Existente{
        if (alumnos.containsValue(alu))
            throw new Exception_Entidad_Existente("El alumno ya fue registrado");
        else{
            alumnos.put(alu.getLegajo(), alu);
            //exception con mensaje de alta ok?
        }
    }
    
    public void altaProfesor(Profesor prof) throws Exception_Entidad_Existente{
        if (profesores.containsValue(prof))
            throw new Exception_Entidad_Existente("El profesor ya fue registrado");
        else{
            profesores.put(prof.getLegajo(), prof);
            //exception con mensaje de alta ok?
        }
    }
    
    public void altaAsignatura(Asignatura asi) throws Exception_Entidad_Existente{
        if (asignaturas.containsValue(asi))
            throw new Exception_Entidad_Existente("La asignatura ya fue registrada");
        else{
            asignaturas.put(asi.getIdentificacion(), asi);
            //exception con mensaje de alta ok?
        }
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
