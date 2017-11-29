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
            new Alumno("Son", "Goku", "DBZ", 1234, "161718", "songoku@cc.com");
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
        assertFalse("Deberian ser iguales", super.alumno(1).equals(super.alumno(3)));
    }
    
    @Test
    public void testHashCode1()
    {
        assertEquals("El hash code no es el esperado", super.alumno(4), 37);
    }
    
    @Test
    public void testHashCode2()
    {
        assertEquals("El hash code no es el esperado", super.alumno(1), 37 + ("ALU0000").hashCode());
    }
    
}
