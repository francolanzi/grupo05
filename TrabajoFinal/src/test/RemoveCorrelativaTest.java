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
        asignatura.setIdentificacion("ASI0002");
        Asignatura otra = new Asignatura("mateB");
        otra.setIdentificacion("ASI0001");
        try
        {
            asignatura.addCorrelativa(otra);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0002", asignatura);
        asignaturas.put("ASI0001", otra);
        otra = new Asignatura("mateA");
        otra.setIdentificacion("ASI0000");
        asignaturas.put("ASI0000", otra);
        Controlador.getInstance().setAsignaturas(asignaturas);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0002", "ASI0001");
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
            Controlador.getInstance().removeCorrelativa(null, "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAsignaturaVacio()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("", "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAsignaturaInexistente()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI2222", "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCorrelativaNull()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0002", null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCorrelativaVacio()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0002", "");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCorrelativaInexistente()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0002", "ASI2222");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdCorrelativaNoAgregada()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0002", "ASI0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
