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

public class AddAlumnoCursadaTest
{
    
    private Cursada cursada;
    
    @Before
    public void setUp()
    {        
        Asignatura asignatura0 = new Asignatura("mateA");
        asignatura0.setIdentificacion("ASI0000");
        Asignatura asignatura1 = new Asignatura("mateB");
        asignatura1.setIdentificacion("ASI0001");        
        Asignatura asignatura2 = new Asignatura("mateC");
        asignatura2.setIdentificacion("ASI0002");
        Asignatura asignatura3 = new Asignatura("fisica");
        asignatura3.setIdentificacion("ASI0003");
        try
        {
            asignatura2.addCorrelativa(asignatura1);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
        
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0000", asignatura0);
        asignaturas.put("ASI0001", asignatura1);
        asignaturas.put("ASI0002", asignatura2);
        asignaturas.put("ASI0003", asignatura3);
        Controlador.getInstance().setAsignaturas(asignaturas);
        
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
        try
        {
            alumno.aprobarAsignatura(asignatura3);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }

        TreeMap<String, Alumno> alumnos = new TreeMap<String, Alumno>();
        alumnos.put("ALU0001", alumno);
        Controlador.getInstance().setAlumnos(alumnos);

        Cursada cursada1, cursada2, cursada3, cursada4;
        try
        {
            cursada = new Cursada(asignatura1, "01-2017", "MIERCOLES", "18:00", "20:00");
            cursada1 = new Cursada(asignatura0, "01-2017", "LUNES", "10:00", "12:00");
            cursada2 = new Cursada(asignatura1, "01-2017", "LUNES", "10:00", "12:00");
            cursada3 = new Cursada(asignatura2, "02-2017", "VIERNES", "15:00", "17:00");
            cursada4 = new Cursada(asignatura3, "02-2017", "SABADO", "08:00", "10:00");
        }
        catch (HoraInvalidaException | PeriodoInvalidoException e)
        {
            throw new InternalError();
        }
        cursada.setIdentificacion("CUR0000");
        cursada1.setIdentificacion("CUR0001");
        cursada2.setIdentificacion("CUR0002");
        cursada3.setIdentificacion("CUR0003");
        cursada4.setIdentificacion("CUR0004");
        try
        {
            cursada1.addAlumno(alumno);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
        
        TreeMap<String, Cursada> cursadas = new TreeMap<String, Cursada>();
        cursadas.put("CUR0000", cursada);
        cursadas.put("CUR0001", cursada1);
        cursadas.put("CUR0002", cursada2);
        cursadas.put("CUR0003", cursada3);
        cursadas.put("CUR0004", cursada4);
        Controlador.getInstance().setCursadas(cursadas);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU0001", "CUR0000");
            assertTrue("El alumno deberia estar en la cursada", cursada.hasAlumno("ALU0001"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdAlumnoNull()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada(null, "CUR0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdAlumnoVacio()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("", "CUR0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdAlumnoInexistente()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU2222", "CUR0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdCursadaNull()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU0001", null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdCursadaVacio()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU0001", "");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdCursadaInexistente()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU0001", "CUR2222");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testAsignaturaAprobada()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU0001", "CUR0004");
            fail("Debio lanzarse EntidadInvalidaException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EntidadInvalidaException e){}
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testAlumnoNoHabilitado()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU0001", "CUR0003");
            fail("Debio lanzarse EntidadInvalidaException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EntidadInvalidaException e){}
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testHorarioNoViable()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU0001", "CUR0002");
            fail("Debio lanzarse HorarioNoViableException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e){}
    }
    
}
