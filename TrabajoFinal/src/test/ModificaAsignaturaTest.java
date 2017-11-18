package test;

import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;

import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ModificaAsignaturaTest
{
    
    private Asignatura asignatura;
    
    @Before
    public void setUp()
    {
        asignatura = new Asignatura("mateB");
        asignatura.setIdentificacion("ASI0001");
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0001", asignatura);
        Controlador.getInstance().setAsignaturas(asignaturas);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().modificaAsignatura("ASI0001", "mateA");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testNombreNull()
    {
        try
        {
            Controlador.getInstance().modificaAsignatura("ASI0001", null);
            fail("La asignatura no debio ser modificada");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testNombreVacio()
    {
        try
        {
            Controlador.getInstance().modificaAsignatura("ASI0001", "");
            fail("La asignatura no debio ser modificada");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdentificacionNull()
    {
        try
        {
            Controlador.getInstance().modificaAsignatura(null, "mateA");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdentificacionVacia()
    {
        try
        {
            Controlador.getInstance().modificaAsignatura("", "mateA");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdentificacionInexistente()
    {
        try
        {
            Controlador.getInstance().modificaAsignatura("ASI2322", "mateA");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
