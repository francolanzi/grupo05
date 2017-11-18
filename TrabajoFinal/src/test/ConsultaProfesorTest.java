package test;

import java.util.TreeMap;

import model.Profesor;
import model.Controlador;
import model.EmailInvalidoException;
import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ConsultaProfesorTest
{
    
    private Profesor profesor;
    
    @Before
    public void setUp()
    {
        try
        {
            profesor = new Profesor("Pico", "Juan", "Falucho", 3433, "2235357381", "jjj@jjj.com");
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
    public void testLegajoExistente()
    {
        try
        {
            Profesor otro = Controlador.getInstance().consultaProfesor("PRO0001");
            assertEquals("El profesor no es el esperado", profesor, otro);
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
            Controlador.getInstance().consultaProfesor(null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testLegajoVacio()
    {
        try
        {
            Controlador.getInstance().consultaProfesor("");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testLegajInvalido()
    {
        try
        {
            Controlador.getInstance().consultaProfesor("XXXXXX");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testLegajoInexistente()
    {
        try
        {
            Controlador.getInstance().consultaProfesor("PRO2222");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
