package test;

import java.util.TreeMap;

import model.Alumno;
import model.Controlador;
import model.EmailInvalidoException;
import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class ConsultaAlumnoTest
{
    
    private Alumno alumno;
    
    @Before
    public void setUp()
    {
        try
        {
            alumno = new Alumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjj@jjj.com");
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
    public void testLegajoExistente()
    {
        try
        {
            Alumno otro = Controlador.getInstance().consultaAlumno("ALU0001");
            assertEquals("El alumno no es el esperado", alumno, otro);
        }
        catch (IdInvalidoException e)
        {
            fail("La excepcion no debio ser lanzada");
        }
    }
    
    @Test
    public void testLegajoNull()
    {
        try
        {
            Controlador.getInstance().consultaAlumno(null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testLegajoVacio()
    {
        try
        {
            Controlador.getInstance().consultaAlumno("");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testLegajInvalido()
    {
        try
        {
            Controlador.getInstance().consultaAlumno("XXXXXX");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testLegajoInexistente()
    {
        try
        {
            Controlador.getInstance().consultaAlumno("ALU2222");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
