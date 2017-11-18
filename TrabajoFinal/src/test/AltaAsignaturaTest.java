package test;

import java.util.Iterator;
import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class AltaAsignaturaTest
{
    
    @Before
    public void setUp()
    {
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        Controlador.getInstance().setAsignaturas(asignaturas);
    }
    
    @Test
    public void testNombreCorrecto()
    {
        Controlador.getInstance().altaAsignatura("mateA");
    }
    
    @Test
    public void testNombreNull()
    {
        Controlador.getInstance().altaAsignatura(null);
        fail("La asignatura no debio ser creada");
    }
    
    @Test
    public void testNombreVacio()
    {
        Controlador.getInstance().altaAsignatura("");
        fail("La asignatura no debio ser creada");
    }
    
    @Test
    public void testIdentificacionUnica()
    {
        Controlador.getInstance().altaAsignatura("mateA");
        Controlador.getInstance().altaAsignatura("mateB");
        Iterator<Asignatura> asignaturas = Controlador.getInstance().getAsignaturasIterator();
        assertNotEquals("Las asignaturas no deberian tener la misma identificacion", asignaturas.next().getId(), asignaturas.next().getId());
    }
    
}
