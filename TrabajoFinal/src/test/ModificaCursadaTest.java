package test;

import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;
import model.Cursada;
import model.HoraInvalidaException;
import model.HorarioNoViableException;
import model.IdInvalidoException;
import model.PeriodoInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ModificaCursadaTest
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
            cursada = new Cursada(asignatura, "02-2017", "MIERCOLES", "18:00", "20:00");
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
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0001", "01-2017", "LUNES", "10:00", "12:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdentificacionNull()
    {
        try
        {
            Controlador.getInstance().modificaCursada(null, "01-2017", "LUNES", "10:00", "12:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdentificacionVacia()
    {
        try
        {
            Controlador.getInstance().modificaCursada("", "01-2017", "LUNES", "10:00", "12:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdentificacionInexistente()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR3333", "01-2017", "LUNES", "10:00", "12:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testHoraInicioNegativa()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0001", "01-2017", "LUNES", "-34:00", "12:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testHoraInicioGrande()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0001", "01-2017", "LUNES", "65:00", "10:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testHoraInicioNoNumerica()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0001", "01-2017", "LUNES", "xxx", "10:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testHoraFinNegativa()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0001", "01-2017", "LUNES", "08:00", "-12:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testHoraFinGrande()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0001", "01-2017", "LUNES", "08:00", "65:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testHoraFinNoNumerica()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0001", "01-2017", "LUNES", "08:00", "xxx");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testPeriodoNull()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0001", null, "LUNES", "10:00", "12:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testPeriodoVacio()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0001", "", "LUNES", "10:00", "12:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testPeriodoInvalido()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0001", "adsadasd", "LUNES", "10:00", "12:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testHoraFinMenorInicio()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0001", "01-2017", "LUNES", "12:00", "10:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testHoraFinMenorInicioLimite()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0001", "01-2017", "LUNES", "11:00", "10:00");
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
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
}
