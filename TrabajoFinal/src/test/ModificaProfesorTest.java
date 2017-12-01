package test;

import java.util.TreeMap;

import model.Profesor;
import model.Controlador;
import model.EmailInvalidoException;
import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ModificaProfesorTest
{
    
    private Profesor profesor;
    
    @Before
    public void setUp()
    {
        try
        {
            profesor = new Profesor("Ponce", "Emanuel", "Colon", 1234, "2236543210", "eeee@eeee.com");
        }
        catch (EmailInvalidoException e)
        {
            throw new InternalError();
        }
        profesor.setLegajo("PRO0001");
        
        TreeMap<String, Profesor> profesores = new TreeMap<String, Profesor>();
        profesores.put("PRO0001", profesor);
        Controlador.getInstance().setProfesores(profesores);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", "Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            Profesor profesor = Controlador.getInstance().consultaProfesor("PRO0001");
            assertEquals("El apellido no se modifico correctamente", "Pico", profesor.getApellido());
            assertEquals("El nombre no se modifico correctamente", "Juan", profesor.getNombre());
            assertEquals("La calle no se modifico correctamente", "Falucho", profesor.getDomicilio().getCalle());
            assertEquals("El numero no se modifico correctamente", 3433, profesor.getDomicilio().getNumero());
            assertEquals("El telefono no se modifico correctamente", "2235357381", profesor.getTelefono());
            assertEquals("El email no se modifico correctamente", "jjjj@jjjj.com", profesor.getEmail());
        }
        catch (EmailInvalidoException | IdInvalidoException e)
        {
            fail("El profesor debio ser modificado correctamente");
        }
    }
    
    @Test
    public void testEmailSinArroba()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", "Pico", "Juan", "Falucho", 3433, "2235357381", "jjjjjjjj.com");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testEmailSinCaracteresAntes()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", "Pico", "Juan", "Falucho", 3433, "2235357381", "@jjjj.com");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testEmailSinCaracteresDespues()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", "Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testLegajoNull()
    {
        try
        {
            Controlador.getInstance().modificaProfesor(null, "Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testLegajoVacio()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("", "Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testLegajoInexistente()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO2323", "Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testNombreNull()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", "Pico", null, "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser modificado");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testNombreVacio()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", "Pico", "", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser modificado");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testApellidoNull()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", null, "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser modificado");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testApellidoVacio()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", "", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser modificado");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testCalleNull()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", "Pico", "Juan", null, 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser modificado");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testCalleVacia()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", "Pico", "Juan", "", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser modificado");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testNumeroValorLimite()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", "Pico", "Juan", "Falucho", -1, "2235357381", "jjjj@jjjj.com");
            fail("El profesor no debio ser modificado");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testTelefonoNull()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", "Pico", "Juan", "Falucho", 3433, null, "jjjj@jjjj.com");
            fail("El profesor no debio ser modificado");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testTelefonoVacio()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0001", "Pico", "Juan", "Falucho", 3433, "", "jjjj@jjjj.com");
            fail("El profesor no debio ser modificado");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
}