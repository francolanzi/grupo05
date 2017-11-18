package test;

import java.util.Iterator;
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

public class AltaCursadaTest
{
    
    @Before
    public void setUp()
    {
        Asignatura asignatura = new Asignatura("mateA");
        asignatura.setIdentificacion("ASI0001");
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0001", asignatura);
        Controlador.getInstance().setAsignaturas(asignaturas);
        
        TreeMap<String, Cursada> cursadas = new TreeMap<String, Cursada>();
        Controlador.getInstance().setCursadas(cursadas);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", "01-2017", "LUNES", "10:00", "12:00");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdAsignaturaNull()
    {
        try
        {
            Controlador.getInstance().altaCursada(null, "01-2017", "LUNES", "10:00", "12:00");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdAsignaturaVacio()
    {
        try
        {
            Controlador.getInstance().altaCursada("", "01-2017", "LUNES", "10:00", "12:00");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdAsignaturaInexistente()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI3333", "01-2017", "LUNES", "10:00", "12:00");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdentificacionUnicaValida()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", "01-2017", "LUNES", "10:00", "12:00");
            Controlador.getInstance().altaCursada("ASI0001", "02-2017", "MIERCOLES", "18:00", "20:00");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
        Iterator<Cursada> cursadas = Controlador.getInstance().getCursadasIterator();
        String idenficacion1 = cursadas.next().getId();
        String idenficacion2 = cursadas.next().getId();
        assertTrue("La identificacion deberia ser valida", IdValido.idValido("CUR", idenficacion1));
        assertTrue("La identificacion deberia ser valida", IdValido.idValido("CUR", idenficacion2));
        assertNotEquals("Las cursadas no deberian tener la misma identificacion", idenficacion1, idenficacion2);
    }
    
    @Test
    public void testHoraInicioNegativa()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", "01-2017", "LUNES", "-34:00", "12:00");
            fail("Debio lanzarse HoraInvalidaException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e){}
    }
    
    @Test
    public void testHoraInicioGrande()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", "01-2017", "LUNES", "65:00", "10:00");
            fail("Debio lanzarse HoraInvalidaException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e){}
    }
    
    @Test
    public void testHoraInicioNoNumerica()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", "01-2017", "LUNES", "xxx", "10:00");
            fail("Debio lanzarse HoraInvalidaException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e){}
    }
    
    @Test
    public void testHoraFinNegativa()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", "01-2017", "LUNES", "08:00", "-12:00");
            fail("Debio lanzarse HoraInvalidaException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e){}
    }
    
    @Test
    public void testHoraFinGrande()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", "01-2017", "LUNES", "08:00", "65:00");
            fail("Debio lanzarse HoraInvalidaException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e){}
    }
    
    @Test
    public void testHoraFinNoNumerica()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", "01-2017", "LUNES", "08:00", "xxx");
            fail("Debio lanzarse HoraInvalidaException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e){}
    }
    
    @Test
    public void testPeriodoNull()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", null, "LUNES", "10:00", "12:00");
            fail("Debio lanzarse PeriodoInvalidoException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e){}
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testPeriodoVacio()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", "", "LUNES", "10:00", "12:00");
            fail("Debio lanzarse PeriodoInvalidoException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e){}
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testPeriodoInvalido()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", "adsadasd", "LUNES", "10:00", "12:00");
            fail("Debio lanzarse PeriodoInvalidoException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e){}
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testHoraFinMenorInicio()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", "01-2017", "LUNES", "12:00", "10:00");
            fail("Debio lanzarse HoraInvalidaException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e){}
    }
    
    @Test
    public void testHoraFinMenorInicioLimite()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0001", "01-2017", "LUNES", "11:00", "10:00");
            fail("Debio lanzarse HoraInvalidaException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e){}
    }
    
}
