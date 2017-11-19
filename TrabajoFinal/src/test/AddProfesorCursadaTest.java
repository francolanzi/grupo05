package test;

import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;
import model.Cursada;
import model.EmailInvalidoException;
import model.EntidadInvalidaException;
import model.HoraInvalidaException;
import model.HorarioNoViableException;
import model.IdInvalidoException;
import model.PeriodoInvalidoException;
import model.Profesor;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AddProfesorCursadaTest
{
    
    private Cursada cursada;
    
    @Before
    public void setUp()
    {
        Asignatura asignatura1 = new Asignatura("mateA");
        asignatura1.setIdentificacion("ASI0001");
        Asignatura asignatura2 = new Asignatura("mateB");
        asignatura2.setIdentificacion("ASI0002");
        
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0001", asignatura1);
        asignaturas.put("ASI0002", asignatura2);
        Controlador.getInstance().setAsignaturas(asignaturas);
        
        Profesor profesor;
        try
        {
            profesor = new Profesor("Pico", "Juan", "Falucho", 3433, "2235357381", "jjj@jjj.com");
        }
        catch (EmailInvalidoException e)
        {
            throw new InternalError();
        }
        profesor.setLegajo("PRO0001");
        try
        {
            profesor.addCompetencia(asignatura1);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }

        TreeMap<String, Profesor> profesores = new TreeMap<String, Profesor>();
        profesores.put("PRO0001", profesor);
        Controlador.getInstance().setProfesores(profesores);
        
        Cursada cursada1, cursada2, cursada3;
        try
        {
            cursada = new Cursada(asignatura1, "01-2017", "MIERCOLES", "18:00", "20:00");
            cursada1 = new Cursada(asignatura1, "01-2017", "LUNES", "10:00", "12:00");
            cursada2 = new Cursada(asignatura1, "01-2017", "LUNES", "10:00", "12:00");
            cursada3 = new Cursada(asignatura2, "02-2017", "VIERNES", "15:00", "17:00");
        }
        catch (HoraInvalidaException | PeriodoInvalidoException e)
        {
            throw new InternalError();
        }
        cursada.setIdentificacion("CUR0000");
        cursada1.setIdentificacion("CUR0001");
        cursada2.setIdentificacion("CUR0002");
        cursada3.setIdentificacion("CUR0003");
        try
        {
            cursada1.addProfesor(profesor);
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
        Controlador.getInstance().setCursadas(cursadas);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().addProfesorCursada("PRO0001", "CUR0000");
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
    public void testIdProfesorNull()
    {
        try
        {
            Controlador.getInstance().addProfesorCursada(null, "CUR0000");
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
    public void testIdProfesorVacio()
    {
        try
        {
            Controlador.getInstance().addProfesorCursada("", "CUR0000");
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
    public void testIdProfesorInexistente()
    {
        try
        {
            Controlador.getInstance().addProfesorCursada("PRO2222", "CUR0000");
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
            Controlador.getInstance().addProfesorCursada("PRO0001", null);
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
            Controlador.getInstance().addProfesorCursada("PRO0001", "");
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
            Controlador.getInstance().addProfesorCursada("PRO0001", "CUR2222");
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
    public void testProfesorNoCompetente()
    {
        try
        {
            Controlador.getInstance().addProfesorCursada("PRO0001", "CUR0003");
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
    public void testDisponibilidadHoraria()
    {
        try
        {
            Controlador.getInstance().addProfesorCursada("PRO0001", "CUR0002");
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
