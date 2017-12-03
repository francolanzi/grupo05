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
            Alumno alumno = new Alumno("Son", "Goku", "DBZ", 1234, "161718", "songoku@cc.com");
            assertNotNull("El alumno no deberia ser null", alumno);
            assertEquals("El apellido no es correcto", "Son", alumno.getApellido());
            assertEquals("El nombre no es correcto", "Goku", alumno.getNombre());
            assertEquals("La calle no es correcta", "DBZ", alumno.getDomicilio().getCalle());
            assertEquals("El numero no es correcto", 1234, alumno.getDomicilio().getNumero());
            assertEquals("El telefono no es correcto", "161718", alumno.getTelefono());
            assertEquals("El email no es correcto", "songoku@cc.com", alumno.getEmail());
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
            super.alumno(1).modificar("Sona", "Goten", "DBZS", 12345, "16171819", "songoten@cc.com");
            assertEquals("El apellido no se modifico correctamente", "Sona", super.alumno(1).getApellido());
            assertEquals("El nombre no se modifico correctamente", "Goten", super.alumno(1).getNombre());
            assertEquals("La calle no se modifico correctamente", "DBZS", super.alumno(1).getDomicilio().getCalle());
            assertEquals("El numero no se modifico correctamente", 12345, super.alumno(1).getDomicilio().getNumero());
            assertEquals("El telefono no se modifico correctamente", "16171819", super.alumno(1).getTelefono());
            assertEquals("El email no se modifico correctamente", "songoten@cc.com", super.alumno(1).getEmail());
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
            assertTrue("El alumno debio aprobar la asignatura", super.alumno(2).isAprobada("ASI0000"));
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
