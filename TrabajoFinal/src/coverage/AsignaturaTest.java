package coverage;

import model.Asignatura;

import model.EntidadInvalidaException;

import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AsignaturaTest extends AbstractTest
{
    
    @Before
    public void setUp()
    {
        super.entidades();
    }
    
    @Test
    public void testConstructor()
    {
        Asignatura asignatura = new Asignatura("Introduccion al Nen");
        assertNotNull("La asignatura no deberia ser null", asignatura);
        assertEquals("El nombre no es correcto", "Introduccion al Nen", asignatura.getNombre());
    }
    
    @Test
    public void testAddCorrelativa1()
    {
        try
        {
            super.asignatura(3).addCorrelativa(super.asignatura(2));
            fail("Debio lanzarse EntidadInvalidaException");
        }
        catch (EntidadInvalidaException e){}
    }
    
    @Test
    public void testAddCorrelativa2()
    {
        try
        {
            super.asignatura(1).addCorrelativa(super.asignatura(2));
            assertTrue("La correlativa debio ser agregada", super.asignatura(1).isCorrelativa("ASI0001"));
        }
        catch (EntidadInvalidaException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testRemoveCorrelativa1()
    {
        try
        {
            super.asignatura(1).removeCorrelativa("ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testRemoveCorrelativa2()
    {
        try
        {
            super.asignatura(3).removeCorrelativa("ASI0001");
            assertFalse("La competencia debio ser removida", super.asignatura(3).isCorrelativa("ASI0001"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIsCorrelativa()
    {
        assertFalse("La asignatura no deberia tener la correlativa", super.asignatura(1).isCorrelativa("ASI0001"));
    }
    
    @Test
    public void testEquals1()
    {
        assertTrue("Deberian ser iguales", super.asignatura(1).equals(super.asignatura(1)));
    }
    
    @Test
    public void testEquals2()
    {
        assertFalse("No deberian ser iguales", super.asignatura(1).equals(super.alumno(1)));
    }
    
    @Test
    public void testEquals3()
    {
        assertFalse("No deberian ser iguales", super.asignatura(5).equals(super.asignatura(1)));
    }
    
    @Test
    public void testEquals4()
    {
        assertFalse("No deberian ser iguales", super.asignatura(1).equals(super.asignatura(2)));
    }
    
    @Test
    public void testEquals5()
    {
        assertTrue("Deberian ser iguales", super.asignatura(1).equals(super.asignatura(4)));
    }
    
    @Test
    public void testHashCode1()
    {
        assertEquals("El hash code no es el esperado", super.asignatura(5).hashCode(), 37);
    }
    
    @Test
    public void testHashCode2()
    {
        assertEquals("El hash code no es el esperado", super.asignatura(1).hashCode(), 37 + super.asignatura(1).getId().hashCode());
    }
    
}
