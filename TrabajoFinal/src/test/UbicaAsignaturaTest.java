package test;

import java.util.Iterator;
import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UbicaAsignaturaTest
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
    public void testAsignaturaExistente()
    {
        Iterator<Asignatura> asignaturas = Controlador.getInstance().ubicaAsignatura("mateA");
        assertEquals("El asignatura no es el esperado", asignatura, asignaturas.next());
        assertFalse("Deberia haber un solo asignatura", asignaturas.hasNext());
    }
    
    @Test
    public void testAsignaturaInexistente()
    {
        Iterator<Asignatura> asignaturas = Controlador.getInstance().ubicaAsignatura("mateB");
        assertFalse("El iterator deberia estar vacio", asignaturas.hasNext());
    }
    
    @Test
    public void testNombreNull()
    {
        Controlador.getInstance().ubicaAsignatura(null);
        fail("La busqueda debio fallar");
    }
    
}
