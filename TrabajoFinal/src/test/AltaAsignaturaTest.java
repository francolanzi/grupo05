package test;

import java.util.Iterator;
import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;

import static org.junit.Assert.*;
import org.junit.Before;
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
    public void testIdentificacionUnicaValida()
    {
        Controlador.getInstance().altaAsignatura("mateA");
        Controlador.getInstance().altaAsignatura("mateB");
        Iterator<Asignatura> asignaturas = Controlador.getInstance().getAsignaturasIterator();
        String idenficacion1 = asignaturas.next().getId();
        String idenficacion2 = asignaturas.next().getId();
        assertTrue("La identificacion deberia ser valida", IdValido.idValido("ASI", idenficacion1));
        assertTrue("La identificacion deberia ser valida", IdValido.idValido("ASI", idenficacion2));
        assertNotEquals("Las asignaturas no deberian tener la misma identificacion", idenficacion1, idenficacion2);
    }
    
}
