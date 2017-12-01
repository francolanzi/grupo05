package test;

import java.util.Iterator;
import java.util.TreeMap;

import model.Alumno;
import model.Controlador;
import model.EmailInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AltaAlumnoTest
{
    
    @Before
    public void setUp()
    {
        TreeMap<String, Alumno> alumnos = new TreeMap<String, Alumno>();
        Controlador.getInstance().setAlumnos(alumnos);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            Iterator<Alumno> alumnos = Controlador.getInstance().ubicaAlumno("Pico", "Juan");
            Alumno alumno = alumnos.next();
            assertFalse("Deberia haber un unico alumno", alumnos.hasNext());
            assertNotNull("El alumno no deberia ser null", alumno);
            assertEquals("El apellido no es correcto", "Pico", alumno.getApellido());
            assertEquals("El nombre no es correcto", "Juan", alumno.getNombre());
            assertEquals("La calle no es correcto", "Falucho", alumno.getDomicilio().getCalle());
            assertEquals("El numero no es correcto", 3433, alumno.getDomicilio().getNumero());
            assertEquals("El telefono no es correcto", "2235357381", alumno.getTelefono());
            assertEquals("El email no es correcto", "jjjj@jjjj.com", alumno.getEmail());
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testValoresLimites()
    {
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 1, "2", "j@j");
        }
        catch (EmailInvalidoException e)
        {
            fail("El alumno debio ser creado correctamente");
        }
    }
    
    @Test
    public void testEmailSinArroba()
    {
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjjjjjj.com");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testEmailSinCaracteresAntes()
    {
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "@jjjj.com");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testEmailSinCaracteresDespues()
    {
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testEmailUnCaracterDespues()
    {
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "@j");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testLegajoUnicoValido()
    {
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            Controlador.getInstance().altaAlumno("Ponce", "Emanuel", "Colon", 1234, "2236543210", "eeee@eeee.com");
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
        Iterator<Alumno> alumnos = Controlador.getInstance().getAlumnosIterator();
        String legajo1 = alumnos.next().getId();
        String legajo2 = alumnos.next().getId();
        assertTrue("El legajo deberia ser valido", IdValido.idValido("ALU", legajo1));
        assertTrue("El legajo deberia ser valido", IdValido.idValido("ALU", legajo2));
        assertNotEquals("Los alumnos no deberian tener el mismo legajo", legajo1, legajo2);
    }
    
    @Test
    public void testNombreNull()
    {
        try
        {
            Controlador.getInstance().altaAlumno("Pico", null, "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
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
            Controlador.getInstance().altaAlumno("Pico", "", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
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
            Controlador.getInstance().altaAlumno(null, "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
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
            Controlador.getInstance().altaAlumno("", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
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
            Controlador.getInstance().altaAlumno("Pico", "Juan", null, 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
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
            Controlador.getInstance().altaAlumno("Pico", "Juan", "", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testNumeroNegativo()
    {
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", -1233, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
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
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", -1, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
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
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, null, "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
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
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
}
