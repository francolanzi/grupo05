package test;

import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;
import model.EntidadInvalidaException;

import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RemoveCorrelativaTest
{
    
    private Asignatura asignatura;
    
    @Before
    public void setUp()
    {
        asignatura = new Asignatura("mateC");
        asignatura.setIdentificacion("ASI0000");
        Asignatura asignatura1 = new Asignatura("mateA");
        asignatura1.setIdentificacion("ASI0001");
        Asignatura asignatura2 = new Asignatura("mateB");
        asignatura2.setIdentificacion("ASI0002");
        try
        {
            asignatura.addCorrelativa(asignatura2);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
        
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0000", asignatura);
        asignaturas.put("ASI0001", asignatura1);
        asignaturas.put("ASI0002", asignatura2);
        Controlador.getInstance().setAsignaturas(asignaturas);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0000", "ASI0002");
            assertFalse("La correlativa debio haber sido eliminada", asignatura.isCorrelativa("ASI0001"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdAsignaturaNull()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa(null, "ASI0002");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAsignaturaVacio()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("", "ASI0002");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAsignaturaInexistente()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI2222", "ASI0002");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCorrelativaNull()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0000", null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCorrelativaVacio()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0000", "");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCorrelativaInexistente()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0000", "ASI2222");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testCorrelativaNoAgregada()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0000", "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
