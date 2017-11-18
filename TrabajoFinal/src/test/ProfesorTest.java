package test;

import java.util.TreeMap;

import model.Profesor;
import model.Controlador;

import model.EmailInvalidoException;

import model.Profesor;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class ProfesorTest
{
    
    @Before
    public void setUp()
    {
        TreeMap<String, Profesor> profesores = new TreeMap<String, Profesor>();
        Controlador.getInstance().setProfesores(profesores);
    }
    
    @Test
    public void altaProfesor()
    {
        
        //Clases correctas
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, "2235357381", "jjj@jjj.com");
        }
        catch (EmailInvalidoException e)
        {
            fail("El profesor debio ser creado correctamente");
        }
        
        //Valores limites
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 1, "2", "j@j");
        }
        catch (EmailInvalidoException e)
        {
            fail("El profesor debio ser creado correctamente");
        }
        
        //El email no contiene @
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjjjjjj.com");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
        
        //El email no contiene carcateres antes de @
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, "2235357381", "@jjj.com");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
        
        //El email no contiene carcateres despues de @
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
        
        //El email no contiene carcateres antes de @ y solo uno despues
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, "2235357381", "@j");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
        
        //El nombre es null
        try
        {
            Controlador.getInstance().altaProfesor("Pico", null, "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El nombre es vacio
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El apellido es null
        try
        {
            Controlador.getInstance().altaProfesor(null, "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El apellido es vacio
        try
        {
            Controlador.getInstance().altaProfesor("", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //La calle es null
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", null, 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //La calle es vacia
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El numero es negativo
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", -1233, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El numero es -1
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", -1, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El telefono es null
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, null, "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El telefono es vacio
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, "", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}

    }
    
}
