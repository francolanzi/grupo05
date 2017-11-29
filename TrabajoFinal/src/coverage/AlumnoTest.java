package coverage;

import model.Alumno;

import model.EmailInvalidoException;

import model.EntidadInvalidaException;

import model.IdInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AlumnoTest extends AbstractTest
{
    
    @Before
    public void setUp()
    {
        super.entidades();
    }
    
    @Test
    public void testConstructor()
    {
        try
        {
            assertNotNull("El alumno no deberia ser null", new Alumno("Son", "Goku", "DBZ", 1234, "161718", "songoku@cc.com"));
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testModificar1()
    {
        try
        {
            super.alumno(1).modificar("Son", "Goku", "DBZ", 1234, "161718", "g@");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testModificar2()
    {
        try
        {
            super.alumno(1).modificar("Son", "Gohan", "DBZ", 1234, "161718", "songohan@cc.com");
            assertEquals("El apellido no se modifico correctamente", "Son", super.alumno(1).getApellido());
            assertEquals("El nombre no se modifico correctamente", "Gohan", super.alumno(1).getNombre());
            assertEquals("La calle no se modifico correctamente", "DBZ", super.alumno(1).getDomicilio().getCalle());
            assertEquals("El numero no se modifico correctamente", 1234, super.alumno(1).getDomicilio().getNumero());
            assertEquals("El telefono no se modifico correctamente", "161718", super.alumno(1).getTelefono());
            assertEquals("El email no se modifico correctamente", "songohan@cc.com", super.alumno(1).getEmail());
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testAprobarAsignatura1()
    {
        try
        {
            super.alumno(1).aprobarAsignatura(super.asignatura(1));
            fail("Debio lanzarse EntidadInvalidaException");
        }
        catch (EntidadInvalidaException e){}
    }
    
    @Test
    public void testAprobarAsignatura2()
    {
        try
        {
            super.alumno(2).aprobarAsignatura(super.asignatura(1));
            assertTrue("El alumno debio aprobar la asignatura", super.alumno(2).isAprobada(super.asignatura(1).getId()));
        }
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testRemoveAsignatura1()
    {
        try
        {
            super.alumno(2).removeAsignatura("ASI0000");
            fail("Debio lanzarse EntidadInvalidaException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testRemoveAsignatura2()
    {
        try
        {
            super.alumno(1).removeAsignatura("ASI0000");
            assertFalse("La asignatura debio ser removida", super.alumno(1).isAprobada("ASI0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIsAprobada()
    {
        assertTrue("El alumno deberia tener aprobada la asignatura", super.alumno(1).isAprobada("ASI0000"));
    }
    
    @Test
    public void testEquals1()
    {
        assertTrue("Deberian ser iguales", super.alumno(1).equals(super.alumno(1)));
    }
    
    @Test
    public void testEquals2()
    {
        assertFalse("No deberian ser iguales", super.alumno(1).equals(super.profesor(1)));
    }
    
    @Test
    public void testEquals3()
    {
        assertFalse("No deberian ser iguales", super.alumno(4).equals(super.alumno(2)));
    }
    
    @Test
    public void testEquals4()
    {
        assertFalse("No deberian ser iguales", super.alumno(1).equals(super.alumno(2)));
    }
    
    @Test
    public void testEquals5()
    {
        assertTrue("Deberian ser iguales", super.alumno(1).equals(super.alumno(3)));
    }
    
    @Test
    public void testHashCode1()
    {
        assertEquals("El hash code no es el esperado", super.alumno(4).hashCode(), 37);
    }
    
    @Test
    public void testHashCode2()
    {
        assertEquals("El hash code no es el esperado", super.alumno(1).hashCode(), 37 + super.alumno(1).getId().hashCode());
    }
    
}
