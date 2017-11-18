package test;

import java.util.Iterator;
import java.util.TreeMap;

import model.Profesor;
import model.Controlador;

import model.EmailInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class AltaProfesorTest
{
    
    private Profesor profesor;
    
    @Before
    public void setUp()
    {
        TreeMap<String, Profesor> profesores = new TreeMap<String, Profesor>();
        Controlador.getInstance().setProfesores(profesores);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, "2235357381", "jjj@jjj.com");
        }
        catch (EmailInvalidoException e)
        {
            fail("El profesor debio ser creado correctamente");
        }
    }
    
    @Test
    public void testValoresLimites()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 1, "2", "j@j");
        }
        catch (EmailInvalidoException e)
        {
            fail("El profesor debio ser creado correctamente");
        }
    }
    
    @Test
    public void testEmailSinArroba()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjjjjjj.com");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testEmailSinCaracteresAntes()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, "2235357381", "@jjj.com");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testEmailSinCaracteresDespues()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testEmailUnCaracterDespues()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, "2235357381", "@j");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testNombreNull()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", null, "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testNombreVacio()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testApellidoNull()
    {
        try
        {
            Controlador.getInstance().altaProfesor(null, "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testApellidoVacio()
    {
        try
        {
            Controlador.getInstance().altaProfesor("", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testCalleNull()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", null, 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testCalleVacia()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testNumeroNegativo()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", -1233, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testNumeroValorLimite()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", -1, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testTelefonoNull()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, null, "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testTelefonoVacio()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Pico", "Juan", "Falucho", 3433, "", "jjjj@jjjj.com");
            fail("El profesor no debio ser creado");
        }
        catch (EmailInvalidoException e){}
    }
    
}
