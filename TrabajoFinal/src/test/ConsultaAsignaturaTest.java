package test;

import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;

import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ConsultaAsignaturaTest
{
    
    private Asignatura asignatura;
    
    @Before
    public void setUp()
    {
        asignatura = new Asignatura("mateA");
        asignatura.setIdentificacion("ASI0001");
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0001", asignatura);
        Controlador.getInstance().setAsignaturas(asignaturas);
    }
    
    @Test
    public void testIdentificacionExistente()
    {
        try
        {
            Asignatura otro = Controlador.getInstance().consultaAsignatura("ASI0001");
            assertEquals("La asignatura no es la esperada", asignatura, otro);
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
            Controlador.getInstance().consultaAsignatura(null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdentificacionVacia()
    {
        try
        {
            Controlador.getInstance().consultaAsignatura("");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdentificacionInvalida()
    {
        try
        {
            Controlador.getInstance().consultaAsignatura("XXXXXX");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdentificacionInexistente()
    {
        try
        {
            Controlador.getInstance().consultaAsignatura("ASI2222");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
