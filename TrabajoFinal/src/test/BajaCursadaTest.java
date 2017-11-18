package test;

import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;
import model.Cursada;

import model.HoraInvalidaException;
import model.IdInvalidoException;
import model.PeriodoInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BajaCursadaTest
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
    }
    
    @Test
    public void testIdentificacionExistente()
    {
        try
        {
            Controlador.getInstance().bajaCursada("CUR0001");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        try
        {
            Cursada otra = Controlador.getInstance().consultaCursada("CUR0001");
            assertNotEquals("La cursada debio haber sido eliminada", cursada, otra);
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdentificacionNull()
    {
        try
        {
            Controlador.getInstance().bajaCursada(null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdentificacionInvalida()
    {
        try
        {
            Controlador.getInstance().bajaCursada("adadada");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdentificacionInexistente()
    {
        try
        {
            Controlador.getInstance().bajaCursada("CUR0003");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
