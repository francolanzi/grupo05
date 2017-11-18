package test;

import java.util.TreeMap;

import model.Profesor;
import model.Controlador;
import model.EmailInvalidoException;
import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class BajaProfesorTest
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
            Controlador.getInstance().bajaProfesor("PRO0001");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        try
        {
            Profesor otro = Controlador.getInstance().consultaProfesor("PRO0001");
            assertNotEquals("El profesor debio haber sido eliminado", profesor, otro);
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testLegajoNull()
    {
        try
        {
            Controlador.getInstance().bajaProfesor(null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testLegajoInvalido()
    {
        try
        {
            Controlador.getInstance().bajaProfesor("adadada");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testLegajoInexistente()
    {
        try
        {
            Controlador.getInstance().bajaProfesor("PRO0003");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
