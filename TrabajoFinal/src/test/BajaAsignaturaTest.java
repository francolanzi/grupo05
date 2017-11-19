package test;

import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;
import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BajaAsignaturaTest
{
    
    @Before
    public void setUp()
    {
        Asignatura asignatura = new Asignatura("mateA");
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
            Controlador.getInstance().bajaAsignatura("ASI0001");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        try
        {
            Controlador.getInstance().consultaAsignatura("ASI0001");
            fail("La asignatura debio haber sido eliminada");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdentificacionNull()
    {
        try
        {
            Controlador.getInstance().bajaAsignatura(null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdentificacionInvalida()
    {
        try
        {
            Controlador.getInstance().bajaAsignatura("adadada");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdentificacionInexistente()
    {
        try
        {
            Controlador.getInstance().bajaAsignatura("ASI0003");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
