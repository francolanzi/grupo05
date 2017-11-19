package test;

import java.util.TreeMap;

import model.Alumno;
import model.Asignatura;

import model.Controlador;

import model.EmailInvalidoException;

import model.EntidadInvalidaException;

import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RemoveAsignaturaAlumnoTest
{
    
    private Alumno alumno;
    
    @Before
    public void setUp()
    {
        Asignatura asignatura1 = new Asignatura("mateA");
        asignatura1.setIdentificacion("ASI0001");
        Asignatura asignatura2 = new Asignatura("mateB");
        asignatura2.setIdentificacion("ASI0002");
        try
        {
            asignatura2.addCorrelativa(asignatura1);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
        
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0001", asignatura1);
        asignaturas.put("ASI0002", asignatura2);
        Controlador.getInstance().setAsignaturas(asignaturas);
        
        try
        {
            alumno = new Alumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
        }
        catch (EmailInvalidoException e)
        {
            throw new InternalError();
        }
        alumno.setLegajo("ALU0001");
        try
        {
            alumno.aprobarAsignatura(asignatura1);
            alumno.aprobarAsignatura(asignatura2);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
        
        TreeMap<String, Alumno> alumnos = new TreeMap<String, Alumno>();
        alumnos.put("ALU0001", alumno);
        Controlador.getInstance().setAlumnos(alumnos);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("ALU0001", "ASI0002");
            assertFalse("La asignatura debio haber sido eliminada", alumno.isAprobada("ASI0002"));
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
            Controlador.getInstance().removeAsignaturaAlumno(null, "ASI0002");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAlumnoVacio()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("", "ASI0002");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAlumnoInexistente()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("ALU2222", "ASI0002");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAsignaturaNull()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("ALU0001", null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAsignaturaVacio()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("ALU0001", "");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAsignaturaInexistente()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("ALU0001", "ASI2222");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testAsignaturaConCorrelativas()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("ALU0001", "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
