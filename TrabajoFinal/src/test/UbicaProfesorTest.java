package test;

import java.util.Iterator;
import java.util.TreeMap;

import model.Profesor;
import model.Controlador;
import model.EmailInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UbicaProfesorTest
{
    
    private Profesor profesor;
    
    @Before
    public void setUp()
    {
        try
        {
            profesor = new Profesor("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
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
    public void testProfesorExistente()
    {
        Iterator<Profesor> profesores = Controlador.getInstance().ubicaProfesor("Pico", "Juan");
        assertEquals("El profesor no es el esperado", profesor, profesores.next());
        assertFalse("Deberia haber un solo profesor", profesores.hasNext());
    }
    
    @Test
    public void testProfesorInexistente()
    {
        Iterator<Profesor> profesores = Controlador.getInstance().ubicaProfesor("Ponce", "Emanuel");
        assertFalse("El iterator deberia estar vacio", profesores.hasNext());
    }
    
    @Test
    public void testNombreNull()
    {
        Controlador.getInstance().ubicaProfesor("Pico", null);
        fail("La busqueda debio fallar");
    }
    
    @Test
    public void testNombreVacio()
    {
        Iterator<Profesor> profesores = Controlador.getInstance().ubicaProfesor("Pico", "");
        assertEquals("El profesor no es el esperado", profesor, profesores.next());
        assertFalse("Deberia haber un solo profesor", profesores.hasNext());
    }
    
    @Test
    public void testApellidoNull()
    {
        Controlador.getInstance().ubicaProfesor(null, "Juan");
        fail("La busqueda debio fallar");
    }
    
    @Test
    public void testApellidoVacio()
    {
        Iterator<Profesor> profesores = Controlador.getInstance().ubicaProfesor("", "Juan");
        assertEquals("El profesor no es el esperado", profesor, profesores.next());
        assertFalse("Deberia haber un solo profesor", profesores.hasNext());
    }
    
}
