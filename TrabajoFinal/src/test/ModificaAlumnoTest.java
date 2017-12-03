package test;

import java.util.TreeMap;

import model.Alumno;
import model.Controlador;
import model.EmailInvalidoException;
import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ModificaAlumnoTest
{
    
    private Alumno alumno;
    
    @Before
    public void setUp()
    {
        try
        {
            alumno = new Alumno("Ponce", "Emanuel", "Colon", 1234, "2236543210", "eeee@eeee.com");
        }
        catch (EmailInvalidoException e)
        {
            throw new InternalError();
        }
        alumno.setLegajo("ALU0001");
        
        TreeMap<String, Alumno> alumnos = new TreeMap<String, Alumno>();
        alumnos.put("ALU0001", alumno);
        Controlador.getInstance().setAlumnos(alumnos);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().modificaAlumno("ALU0001", "Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            Alumno alumno = Controlador.getInstance().consultaAlumno("ALU0001");
            assertEquals("El apellido no se modifico correctamente", "Pico", alumno.getApellido());
            assertEquals("El nombre no se modifico correctamente", "Juan", alumno.getNombre());
            assertEquals("La calle no se modifico correctamente", "Falucho", alumno.getDomicilio().getCalle());
            assertEquals("El numero no se modifico correctamente", 3433, alumno.getDomicilio().getNumero());
            assertEquals("El telefono no se modifico correctamente", "2235357381", alumno.getTelefono());
            assertEquals("El email no se modifico correctamente", "jjjj@jjjj.com", alumno.getEmail());
        }
        catch (EmailInvalidoException | IdInvalidoException e)
        {
            fail("El alumno debio ser modificado correctamente");
        }
    }
    
    @Test
    public void testEmailSinArroba()
    {
        try
        {
            Controlador.getInstance().modificaAlumno("ALU0001", "Pico", "Juan", "Falucho", 3433, "2235357381", "jjjjjjjj.com");
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
            Controlador.getInstance().modificaAlumno("ALU0001", "Pico", "Juan", "Falucho", 3433, "2235357381", "@jjjj.com");
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
            Controlador.getInstance().modificaAlumno("ALU0001", "Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@");
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
            Controlador.getInstance().modificaAlumno(null, "Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
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
            Controlador.getInstance().modificaAlumno("", "Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
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
            Controlador.getInstance().modificaAlumno("ALU2323", "Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
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
            Controlador.getInstance().modificaAlumno("ALU0001", "Pico", null, "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser modificado");
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
            Controlador.getInstance().modificaAlumno("ALU0001", "Pico", "", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser modificado");
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
            Controlador.getInstance().modificaAlumno("ALU0001", null, "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser modificado");
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
            Controlador.getInstance().modificaAlumno("ALU0001", "", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser modificado");
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
            Controlador.getInstance().modificaAlumno("ALU0001", "Pico", "Juan", null, 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser modificado");
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
            Controlador.getInstance().modificaAlumno("ALU0001", "Pico", "Juan", "", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser modificado");
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
            Controlador.getInstance().modificaAlumno("ALU0001", "Pico", "Juan", "Falucho", -1, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser modificado");
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
            Controlador.getInstance().modificaAlumno("ALU0001", "Pico", "Juan", "Falucho", 3433, null, "jjjj@jjjj.com");
            fail("El alumno no debio ser modificado");
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
            Controlador.getInstance().modificaAlumno("ALU0001", "Pico", "Juan", "Falucho", 3433, "", "jjjj@jjjj.com");
            fail("El alumno no debio ser modificado");
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
