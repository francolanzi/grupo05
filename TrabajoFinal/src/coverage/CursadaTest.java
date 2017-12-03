package coverage;

import model.Controlador;
import model.Cursada;
import model.EntidadInvalidaException;
import model.HoraInvalidaException;
import model.IdInvalidoException;
import model.PeriodoInvalidoException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class CursadaTest extends AbstractTest
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
            Cursada cursada = new Cursada(super.asignatura(1), "01-2017", "Lunes", "13:00", "15:00");
            assertNotNull("La cursada no deberia ser null", cursada);
            assertEquals("La asignatura no es correcta", super.asignatura(1), cursada.getAsignatura());
            assertEquals("El periodo no es correcto", "01-2017", cursada.getPeriodo());
            assertEquals("El dia no es correcto", "Lunes", cursada.getDia());
            assertEquals("La hora de inicio no es correcta", "13:00", cursada.getHoraInicio());
            assertEquals("La hora de finalizacion no es correcta", "15:00", cursada.getHoraFin());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
    }

    @Test
    public void testModificar1()
    {
        try
        {
            super.cursada(1).modificar("03-2017", "Lunes", "13:00", "15:00");
            fail("Debio lanzarse PeriodoInvalidoException");
        }
        catch (PeriodoInvalidoException e){}
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
    }

    @Test
    public void testModificar2()
    {
        try
        {
            super.cursada(1).modificar("01-2017", "Lunes", "13:70", "15:00");
            fail("Debio lanzarse HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e){}
    }

    @Test
    public void testModificar3()
    {
        try
        {
            super.cursada(1).modificar("01-2017", "Lunes", "13:00", "100:00");
            fail("Debio lanzarse HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e){}
    }

    @Test
    public void testModificar4()
    {
        try
        {
            super.cursada(1).modificar("01-2017", "Lunes", "15:00", "13:00");
            fail("Debio lanzarse HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e){}
    }

    @Test
    public void testModificar5()
    {
        try
        {
            super.cursada(1).modificar("01-2017", "Lunes", "13:00", "15:00");
            assertEquals("El periodo no se modifico correctamente", "01-2017", super.cursada(1).getPeriodo());
            assertEquals("El dia no se modifico correctamente", "Lunes", super.cursada(1).getDia());
            assertEquals("La hora de inicio no se modifico correctamente", "13:00", super.cursada(1).getHoraInicio());
            assertEquals("La hora de finalizacion no se modifico correctamente", "15:00", super.cursada(1).getHoraFin());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
    }

    @Test
    public void testAddAlumno1()
    {
        try
        {
            super.cursada(1).addAlumno(super.alumno(1));
            fail("Debio lanzarse EntidadInvalidaException");
        }
        catch (EntidadInvalidaException e){}
    }

    @Test
    public void testAddAlumno2()
    {
        try
        {
            super.cursada(2).addAlumno(super.alumno(2));
            fail("Debio lanzarse EntidadInvalidaException");
        }
        catch (EntidadInvalidaException e){}
    }

    @Test
    public void testAddAlumno3()
    {
        try
        {
            super.cursada(3).addAlumno(super.alumno(2));
            assertTrue("El alumno debio ser agregado", super.cursada(3).hasAlumno("ALU0001"));
        }
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }

    @Test
    public void testAddProfesor1()
    {
        try
        {
            super.cursada(1).addProfesor(super.profesor(2));
            fail("Debio lanzarse EntidadInvalidaException");
        }
        catch (EntidadInvalidaException e){}
    }

    @Test
    public void testAddProfesor2()
    {
        try
        {
            super.cursada(1).addProfesor(super.profesor(3));
            assertTrue("El profesor debio ser agregado", super.cursada(1).hasProfesor("PRO0002"));
        }
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }

    @Test
    public void testRemoveAlumno1()
    {
        try
        {
            super.cursada(1).removeAlumno("ALU0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }

    @Test
    public void testRemoveAlumno2()
    {
        try
        {
            super.cursada(1).removeAlumno("ALU0001");
            assertFalse("El alumno debio ser removido", super.cursada(1).hasAlumno("ALU0001"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }

    @Test
    public void testRemoveProfesor1()
    {
        try
        {
            super.cursada(1).removeProfesor("PRO0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }

    @Test
    public void testRemoveProfesor2()
    {
        try
        {
            super.cursada(1).removeProfesor("PRO0000");
            assertFalse("El profesor debio ser removido", super.cursada(1).hasProfesor("PRO0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }

    @Test
    public void testHasAlumno()
    {
        assertFalse("El alumno no deberia pertenecer a la cursada", super.cursada(1).hasAlumno("ALU0000"));
    }

    @Test
    public void testHasProfesor()
    {
        assertTrue("El profesor deberia pertenecer a la cursada", super.cursada(1).hasProfesor("PRO0000"));
    }

    @Test
    public void testAprobarAlumno1()
    {
        try
        {
            super.cursada(1).aprobarAlumno("ALU0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }

    @Test
    public void testAprobarAlumno2()
    {
        try
        {
            super.cursada(1).aprobarAlumno("ALU0001");
            assertFalse("El alumno no deberia a la cursada", super.cursada(1).hasAlumno("ALU0001"));
            assertTrue("El alumno debio aprobar la asignatura", super.alumno(2).isAprobada("ASI0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }

    @Test
    public void testIsCompatible()
    {
        assertFalse("La cursada no deberia ser compatible", super.cursada(1).isCompatible("01-2016", "Martes", "21:00", "23:00"));
    }

    @Test
    public void testEquals1()
    {
        assertTrue("Deberian ser iguales", super.cursada(1).equals(super.cursada(1)));
    }

    @Test
    public void testEquals2()
    {
        assertFalse("No deberian ser iguales", super.cursada(1).equals(super.profesor(1)));
    }

    @Test
    public void testEquals3()
    {
        assertFalse("No deberian ser iguales", super.cursada(5).equals(super.cursada(1)));
    }

    @Test
    public void testEquals4()
    {
        assertFalse("No deberian ser iguales", super.cursada(1).equals(super.cursada(2)));
    }

    @Test
    public void testEquals5()
    {
        assertTrue("Deberian ser iguales", super.cursada(1).equals(super.cursada(4)));
    }

    @Test
    public void testHasCode1()
    {
        assertEquals("El hash code no es el esperado", super.cursada(5).hashCode(), 37);
    }

    @Test
    public void testHasCode2()
    {
        assertEquals("El hash code no es el esperado", super.cursada(1).hashCode(), 37 + super.cursada(1).getId().hashCode());
    }

    @Test
    public void testUpdate()
    {
        super.cursada(1).update(Controlador.getInstance(), "ASI0000");
        assertFalse("Se deberia eliminar la cursada", Controlador.getInstance().getCursadas().containsKey("CUR0000"));
    }

}
