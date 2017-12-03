package coverage;

import model.EmailInvalidoException;
import model.EntidadInvalidaException;
import model.IdInvalidoException;

import model.Profesor;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ProfesorTest extends AbstractTest
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
            Profesor profesor = new Profesor("Whis", "Angel", "TemploBeerus", 1234, "070707", "angelwhis@cc.com");
            assertNotNull("El profesor no deberia ser null", profesor);
            assertEquals("El apellido no es correcto", "Whis", profesor.getApellido());
            assertEquals("El nombre no es correcto", "Angel", profesor.getNombre());
            assertEquals("La calle no es correcta", "TemploBeerus", profesor.getDomicilio().getCalle());
            assertEquals("El numero no es correcto", 1234, profesor.getDomicilio().getNumero());
            assertEquals("El telefono no es correcto", "070707", profesor.getTelefono());
            assertEquals("El email no es correcto", "angelwhis@cc.com", profesor.getEmail());
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
            super.profesor(1).modificar("Whis", "Angel", "TemploBeerus", 1234, "070707", "a@");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
    }
    
    @Test
    public void testModificar2()
    {
        try
        {
            super.profesor(1).modificar("Wfis", "Antel", "TemploGeerus", 1434, "071707", "antelwfis@cc.com");
            assertEquals("El apellido no se modifico correctamente", "Wfis", super.profesor(1).getApellido());
            assertEquals("El nombre no se modifico correctamente", "Antel", super.profesor(1).getNombre());
            assertEquals("La calle no se modifico correctamente", "TemploGeerus", super.profesor(1).getDomicilio().getCalle());
            assertEquals("El numero no se modifico correctamente", 1434, super.profesor(1).getDomicilio().getNumero());
            assertEquals("El telefono no se modifico correctamente", "071707", super.profesor(1).getTelefono());
            assertEquals("El email no se modifico correctamente", "antelwfis@cc.com", super.profesor(1).getEmail());
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testAddCompetencia1()
    {
        try
        {
            super.profesor(1).addCompetencia(super.asignatura(1));
            fail("Debio lanzarse EntidadInvalidaException");
        }
        catch (EntidadInvalidaException e){}
    }
    
    @Test
    public void testAddCompetencia2()
    {
        try
        {
            super.profesor(2).addCompetencia(super.asignatura(1));
            assertTrue("El profesor deberia ser competente", super.profesor(2).isCompetente(super.asignatura(1).getId()));
        }
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testRemoveCompetencia1()
    {
        try
        {
            super.profesor(2).removeCompetencia("ASI0000");
            fail("Debio lanzarse EntidadInvalidaException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testRemoveCompetencia2()
    {
        try
        {
            super.profesor(1).removeCompetencia("ASI0000");
            assertFalse("La competencia debio ser removida", super.profesor(1).isCompetente("ASI0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIsCompetente()
    {
        assertTrue("El profesor deberia ser competente para la asignatura", super.profesor(1).isCompetente("ASI0000"));
    }
    
    @Test
    public void testEquals1()
    {
        assertTrue("Deberian ser iguales", super.profesor(1).equals(super.profesor(1)));
    }
    
    @Test
    public void testEquals2()
    {
        assertFalse("No deberian ser iguales", super.profesor(1).equals(super.alumno(1)));
    }
    
    @Test
    public void testEquals3()
    {
        assertFalse("No deberian ser iguales", super.profesor(5).equals(super.profesor(1)));
    }
    
    @Test
    public void testEquals4()
    {
        assertFalse("No deberian ser iguales", super.profesor(1).equals(super.profesor(2)));
    }
    
    @Test
    public void testEquals5()
    {
        assertTrue("Deberian ser iguales", super.profesor(1).equals(super.profesor(4)));
    }
    
    @Test
    public void testHashCode1()
    {
        assertEquals("El hash code no es el esperado", super.profesor(5).hashCode(), 37);
    }
    
    @Test
    public void testHashCode2()
    {
        assertEquals("El hash code no es el esperado", super.profesor(1).hashCode(), 37 + super.profesor(1).getId().hashCode());
    }
    
}
