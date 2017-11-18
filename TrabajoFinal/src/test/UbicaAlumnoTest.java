package test;

import java.util.Iterator;
import java.util.TreeMap;

import model.Alumno;
import model.Controlador;
import model.EmailInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UbicaAlumnoTest
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
    public void testAlumnoExistente()
    {
        Iterator<Alumno> alumnos = Controlador.getInstance().ubicaAlumno("Pico", "Juan");
        assertEquals("El alumno no es el esperado", alumno, alumnos.next());
        assertFalse("Deberia haber un solo alumno", alumnos.hasNext());
    }
    
    @Test
    public void testAlumnoInexistente()
    {
        Iterator<Alumno> alumnos = Controlador.getInstance().ubicaAlumno("Ponce", "Emanuel");
        assertFalse("El iterator deberia estar vacio", alumnos.hasNext());
    }
    
    @Test
    public void testNombreNull()
    {
        Controlador.getInstance().ubicaAlumno("Pico", null);
        fail("La busqueda debio fallar");
    }
    
    @Test
    public void testApellidoNull()
    {
        Controlador.getInstance().ubicaAlumno(null, "Juan");
        fail("La busqueda debio fallar");
    }
    
}
