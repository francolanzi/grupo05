package test;

import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;
import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class BajaAsignaturaTest
{
    
    private Asignatura asignatura;
    
    @Before
    public void setUp()
    {
        asignatura = new Asignatura("mateA");
        asignatura.setIdentificacion("ALU0001");
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0001", asignatura);
        Controlador.getInstance().setAsignaturas(asignaturas);
    }
    
    @Test
    public void testLegajoExistente()
    {
        try
        {
            Controlador.getInstance().bajaAsignatura("ASI0001");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        try
        {
            Asignatura otra = Controlador.getInstance().consultaAsignatura("ASI0001");
            assertNotEquals("La asignatura debio haber sido eliminada", asignatura, otra);
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testLegajoNull()
    {
        try
        {
            Controlador.getInstance().bajaAsignatura(null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testLegajoInvalido()
    {
        try
        {
            Controlador.getInstance().bajaAsignatura("adadada");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testLegajoInexistente()
    {
        try
        {
            Controlador.getInstance().bajaAsignatura("ASI0003");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
