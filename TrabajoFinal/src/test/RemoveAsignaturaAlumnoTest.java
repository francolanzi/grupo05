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
        Asignatura asignatura0 = new Asignatura("mateA");
        asignatura0.setIdentificacion("ASI0000");
        Asignatura asignatura1 = new Asignatura("mateB");
        asignatura1.setIdentificacion("ASI0001");
        try
        {
            asignatura1.addCorrelativa(asignatura0);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
        
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0000", asignatura0);
        asignaturas.put("ASI0001", asignatura1);
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
            alumno.aprobarAsignatura(asignatura0);
            alumno.aprobarAsignatura(asignatura1);
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
            Controlador.getInstance().removeAsignaturaAlumno("ALU0001", "ASI0001");
            assertFalse("La asignatura debio haber sido eliminada", alumno.isAprobada("ASI0001"));
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
            Controlador.getInstance().removeAsignaturaAlumno(null, "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAlumnoVacio()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("", "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAlumnoInexistente()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("ALU2222", "ASI0001");
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
            Controlador.getInstance().removeAsignaturaAlumno("ALU0001", "ASI0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
