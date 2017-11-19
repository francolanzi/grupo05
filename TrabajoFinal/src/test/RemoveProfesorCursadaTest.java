package test;

import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;
import model.Cursada;
import model.EmailInvalidoException;
import model.EntidadInvalidaException;
import model.HoraInvalidaException;
import model.IdInvalidoException;
import model.PeriodoInvalidoException;
import model.Profesor;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RemoveProfesorCursadaTest
{
    
    private Cursada cursada;
    
    @Before
    public void setUp()
    {
        Asignatura asignatura = new Asignatura("mateA");
        asignatura.setIdentificacion("ASI0001");
        
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0001", asignatura);
        Controlador.getInstance().setAsignaturas(asignaturas);
        
        Profesor profesor1, profesor2;
        try
        {
            profesor1 = new Profesor("Pico", "Juan", "Falucho", 3433, "2235357381", "jjj@jjj.com");
            profesor2 = new Profesor("Ponce", "Emanuel", "Colon", 1234, "2236543210", "eee@eee.com");
        }
        catch (EmailInvalidoException e)
        {
            throw new InternalError();
        }
        profesor1.setLegajo("PRO0001");
        profesor2.setLegajo("PRO0002");
        try
        {
            profesor1.addCompetencia(asignatura);
            profesor2.addCompetencia(asignatura);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }

        TreeMap<String, Profesor> profesores = new TreeMap<String, Profesor>();
        profesores.put("PRO0001", profesor1);
        profesores.put("PRO0002", profesor2);
        Controlador.getInstance().setProfesores(profesores);

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
            cursada.addProfesor(profesor1);
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
            Controlador.getInstance().removeProfesorCursada("PRO0001", "CUR0001");
            assertFalse("El profesor debio haber sido eliminado", cursada.hasProfesor("PRO0001"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdProfesorNull()
    {
        try
        {
            Controlador.getInstance().removeProfesorCursada(null, "CUR0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdProfesorVacio()
    {
        try
        {
            Controlador.getInstance().removeProfesorCursada("", "CUR0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdProfesorInexistente()
    {
        try
        {
            Controlador.getInstance().removeProfesorCursada("PRO2222", "CUR0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCursadaNull()
    {
        try
        {
            Controlador.getInstance().removeProfesorCursada("PRO0001", null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCursadaVacio()
    {
        try
        {
            Controlador.getInstance().removeProfesorCursada("PRO0001", "");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCursadaInexistente()
    {
        try
        {
            Controlador.getInstance().removeProfesorCursada("PRO0001", "CUR2222");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testProfesorNoAgregado()
    {
        try
        {
            Controlador.getInstance().removeProfesorCursada("PRO0002", "CUR0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
