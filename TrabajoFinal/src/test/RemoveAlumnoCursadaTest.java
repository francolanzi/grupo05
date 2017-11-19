package test;

import java.util.TreeMap;

import model.Alumno;
import model.Asignatura;
import model.Controlador;
import model.Cursada;

import model.EmailInvalidoException;

import model.EntidadInvalidaException;
import model.HoraInvalidaException;
import model.IdInvalidoException;
import model.PeriodoInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RemoveAlumnoCursadaTest
{
    
    private Cursada cursada;
    
    @Before
    public void setUp()
    {
        Alumno alumno1, alumno2;
        try
        {
            alumno1 = new Alumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            alumno2 = new Alumno("Ponce", "Emanuel", "Colon", 1234, "2236543210", "eeee@eeee.com");
        }
        catch (EmailInvalidoException e)
        {
            throw new InternalError();
        }
        alumno1.setLegajo("ALU0001");
        alumno2.setLegajo("ALU0002");
        
        TreeMap<String, Alumno> alumnos = new TreeMap<String, Alumno>();
        alumnos.put("ALU0001", alumno1);
        alumnos.put("ALU0002", alumno2);
        Controlador.getInstance().setAlumnos(alumnos);
        
        Asignatura asignatura = new Asignatura("mateA");
        asignatura.setIdentificacion("ASI0001");
        
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0001", asignatura);
        Controlador.getInstance().setAsignaturas(asignaturas);

        try
        {
            cursada = new Cursada(asignatura, "01-2017", "LUNES", "10:00", "12:00");
        }
        catch (HoraInvalidaException | PeriodoInvalidoException e)
        {
            throw new InternalError();
        }
        cursada.setIdentificacion("CUR0001");
        try
        {
            cursada.addAlumno(alumno1);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }

        TreeMap<String, Cursada> cursadas = new TreeMap<String, Cursada>();
        cursadas.put("CUR0001", cursada);
        Controlador.getInstance().setCursadas(cursadas);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().removeAlumnoCursada("ALU0001", "CUR0001");
            assertFalse("El alumno debio haber sido eliminado", cursada.hasAlumno("ALU0001"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdAlumnoNull()
    {
        try
        {
            Controlador.getInstance().removeAlumnoCursada(null, "CUR0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAlumnoVacio()
    {
        try
        {
            Controlador.getInstance().removeAlumnoCursada("", "CUR0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAlumnoInexistente()
    {
        try
        {
            Controlador.getInstance().removeAlumnoCursada("ALU2222", "CUR0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCursadaNull()
    {
        try
        {
            Controlador.getInstance().removeAlumnoCursada("ALU0001", null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCursadaVacio()
    {
        try
        {
            Controlador.getInstance().removeAlumnoCursada("ALU0001", "");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCursadaInexistente()
    {
        try
        {
            Controlador.getInstance().removeAlumnoCursada("ALU0001", "CUR2222");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testAlumnoNoAgregado()
    {
        try
        {
            Controlador.getInstance().removeAlumnoCursada("ALU0002", "CUR0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
