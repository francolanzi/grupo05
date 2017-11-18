package test;

import java.util.TreeMap;

import model.Alumno;
import model.Asignatura;
import model.Controlador;
import model.Cursada;
import model.EmailInvalidoException;
import model.EntidadInvalidaException;
import model.HoraInvalidaException;
import model.HorarioNoViableException;
import model.IdInvalidoException;
import model.PeriodoInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AprobarAlumnoTest
{
    
    @Before
    public void setUp()
    {
        Alumno alumno;
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
        
        Asignatura asignatura = new Asignatura("mateA");
        asignatura.setIdentificacion("ASI0001");
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0001", asignatura);
        Controlador.getInstance().setAsignaturas(asignaturas);
        
        Cursada cursada;
        try
        {
            cursada = new Cursada(asignatura, "01-2017", "LUNES", "10:00", "12:00");
        }
        catch (HoraInvalidaException | PeriodoInvalidoException e)
        {
            throw new InternalError();
        }
        cursada.setIdentificacion("CUR0001");
        TreeMap<String, Cursada> cursadas = new TreeMap<String, Cursada>();
        cursadas.put("CUR0001", cursada);
        Controlador.getInstance().setCursadas(cursadas);

        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU0001", "CUR0001");
        }
        catch (EntidadInvalidaException | HorarioNoViableException | IdInvalidoException e)
        {
            throw new InternalError();
        }
    }
    
    @Test
    public void testValoresValidos()
    {
        try
        {
            Controlador.getInstance().aprobarAlumno("ALU0001", "CUR0001");
            boolean aprobada = Controlador.getInstance().consultaAlumno("ALU0001").isAprobada("ASI0001");
            assertTrue("El alumno debio aprobar la asignatura", aprobada);
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdAlumnoNull()
    {
        try
        {
            Controlador.getInstance().aprobarAlumno(null, "CUR0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdAlumnoVacio()
    {
        try
        {
            Controlador.getInstance().aprobarAlumno("", "CUR0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdAlumnoInexistente()
    {
        try
        {
            Controlador.getInstance().aprobarAlumno("ALU2222", "CUR0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdCursadaNull()
    {
        try
        {
            Controlador.getInstance().aprobarAlumno("ALU0001", null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdCursadaVacio()
    {
        try
        {
            Controlador.getInstance().aprobarAlumno("ALU0001", "");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdCursadaInexistente()
    {
        try
        {
            Controlador.getInstance().aprobarAlumno("ALU0001", "CUR2222");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
}
