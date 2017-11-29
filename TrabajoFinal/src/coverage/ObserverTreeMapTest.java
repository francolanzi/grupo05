package coverage;

import model.Asignatura;
import model.Controlador;
import model.EntidadInvalidaException;
import model.IdInvalidoException;
import model.ObserverTreeMap;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ObserverTreeMapTest extends AbstractTest
{
    
    @Before
    public void setUp()
    {
        super.entidades();
    }
    
    @Test
    public void testConstructor()
    {
        assertNotNull("El ObserverTreeMap no deberia ser null", new ObserverTreeMap());
    }
    
    @Test
    public void testAdd1()
    {
        try
        {
            super.alumno(1).getHistoria().add(super.asignatura(1));
            fail("Debio lanzarse EntidadInvalidaException");
        }
        catch (EntidadInvalidaException e){}
    }
    
    @Test
    public void testAdd2()
    {
        try
        {
            super.alumno(1).getHistoria().add(super.asignatura(2));
            assertTrue("La asignatura debio ser agregada", super.alumno(1).getHistoria().contains(super.asignatura(2).getId()));
        }
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testGet1()
    {
        try
        {
            super.alumno(1).getHistoria().get("ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testGet2()
    {
        try
        {
            Asignatura asignatura = super.alumno(1).getHistoria().get("ASI0000");
            assertEquals("La asignatura obtenida no es la esperada", "ASI0000", asignatura.getId());
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testRemove1()
    {
        try
        {
            super.alumno(1).getHistoria().remove("ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testRemove2()
    {
        try
        {
            Asignatura asignatura = super.alumno(1).getHistoria().remove("ASI0000");
            assertFalse("La asignatura debio ser removida", super.alumno(1).getHistoria().contains("ASI0000"));
            assertEquals("La asignatura obtenida no es la esperada", "ASI0000", asignatura.getId());
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testContains()
    {
        assertTrue("El alumno deberia contener a la asignatura", super.alumno(1).getHistoria().contains("ASI0000"));
    }
    
    @Test
    public void testUpdate()
    {
        super.alumno(1).getHistoria().update(Controlador.getInstance(), "ASI0000");
        assertFalse("La asignatura debio ser removida", super.alumno(1).getHistoria().contains("ASI0000"));
    }
    
}
