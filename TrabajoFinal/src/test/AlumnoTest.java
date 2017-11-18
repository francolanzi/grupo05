package test;

import java.util.TreeMap;

import model.Alumno;
import model.Controlador;

import model.EmailInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class AlumnoTest
{
    
    @Before
    public void setUp()
    {
        TreeMap<String, Alumno> alumnos = new TreeMap<String, Alumno>();
        Controlador.getInstance().setAlumnos(alumnos);
    }
    
    @Test
    public void altaAlumno()
    {
        
        //Clases correctas
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjj@jjj.com");
        }
        catch (EmailInvalidoException e)
        {
            fail("El alumno debio ser creado correctamente");
        }
        
        //Valores limites
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 1, "2", "j@j");
        }
        catch (EmailInvalidoException e)
        {
            fail("El alumno debio ser creado correctamente");
        }
        
        //El email no contiene @
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjjjjjj.com");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
        
        //El email no contiene carcateres antes de @
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "@jjj.com");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
        
        //El email no contiene carcateres despues de @
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
        
        //El email no contiene carcateres antes de @ y solo uno despues
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "@j");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
        
        //El nombre es null
        try
        {
            Controlador.getInstance().altaAlumno("Pico", null, "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El nombre es vacio
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El apellido es null
        try
        {
            Controlador.getInstance().altaAlumno(null, "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El apellido es vacio
        try
        {
            Controlador.getInstance().altaAlumno("", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //La calle es null
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", null, 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //La calle es vacia
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El numero es negativo
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", -1233, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El numero es -1
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", -1, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El telefono es null
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, null, "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El telefono es vacio
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}

    }
    
}
