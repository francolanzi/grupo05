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
    
    public TreeMap<String, Alumno> ubicaAlumno(String apellido, String nombre) throws EntidadNoEncontradaException{
        TreeMap<String, Alumno> coleccion= new TreeMap<String, Alumno>();
        if (!alumnos.isEmpty()){
            Iterator iterator= alumnos.keySet().iterator();
            while(iterator.hasNext()){
                Alumno otro = (Alumno) iterator.next();
                if (otro.getApellido().equals(apellido) && otro.getNombre().equals(nombre))
                        coleccion.put(otro.getId(), otro);
            }
            if (coleccion.isEmpty())
                throw new EntidadNoEncontradaException(apellido,nombre);
            else
                return coleccion;
        }
        else{
            throw new EntidadNoEncontradaException(apellido,nombre);
        }
    }

    public TreeMap<String, Profesor> ubicaProfesor(String apellido, String nombre) throws EntidadNoEncontradaException{
        TreeMap<String, Profesor> coleccion= new TreeMap<String, Profesor>();
        if (!profesores.isEmpty()){
            Iterator iterator= profesores.keySet().iterator();
            while(iterator.hasNext()){
                Profesor otro = (Profesor) iterator.next();
                if (otro.getApellido().equals(apellido) && otro.getNombre().equals(nombre))
                        coleccion.put(otro.getId(), otro);
            }
            if (coleccion.isEmpty())
                throw new EntidadNoEncontradaException(apellido,nombre);
            else
                return coleccion;
        }
        else{
            throw new EntidadNoEncontradaException(apellido,nombre);
        }
    }
    
    public TreeMap<String, Asignatura> ubicaAsignatura(String nombre) throws EntidadNoEncontradaException{
        TreeMap<String, Asignatura> coleccion= new TreeMap<String, Asignatura>();
        if (!asignaturas.isEmpty()){
            Iterator iterator= asignaturas.keySet().iterator();
            while(iterator.hasNext()){
                Asignatura otro = (Asignatura) iterator.next();
                if (otro.getNombre().equals(nombre))
                    coleccion.put(otro.getId(), otro);
            }
            if (coleccion.isEmpty())
                throw new EntidadNoEncontradaException(nombre);
            else
                return coleccion;
        }
        else{
            throw new EntidadNoEncontradaException(nombre);
        }
    }
    
    public TreeMap<String, Cursada> ubicaCursada(String nombre) throws EntidadNoEncontradaException{
        TreeMap<String, Cursada> coleccion= new TreeMap<String, Cursada>();
        if (!cursadas.isEmpty()){
            Iterator iterator= cursadas.keySet().iterator();
            while(iterator.hasNext()){
                Cursada otro = (Cursada) iterator.next();
                if (otro.getAsignatura().equals(nombre))
                    coleccion.put(otro.getId(), otro);
            }
            if (coleccion.isEmpty())
                throw new EntidadNoEncontradaException(nombre);
            else
                return coleccion;
        }
        else{
            throw new EntidadNoEncontradaException(nombre);
        }
    }

}
