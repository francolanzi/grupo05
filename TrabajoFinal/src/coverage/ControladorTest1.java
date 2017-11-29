package coverage;

import java.util.Iterator;

import model.Alumno;
import model.Asignatura;
import model.Controlador;

import model.EmailInvalidoException;

import model.EntidadInvalidaException;
import model.HoraInvalidaException;
import model.HorarioNoViableException;
import model.IdInvalidoException;
import model.PeriodoInvalidoException;
import model.Profesor;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ControladorTest1 extends AbstractTest
{
    
    @Before
    public void setUp()
    {
        super.escenario1();
    }
    
    @Test
    public void testGetInstance()
    {
        assertNotNull("El controlador no deberia ser null", Controlador.getInstance());
    }
    
    @Test
    public void testAltaAlumno()
    {
        try
        {
            Controlador.getInstance().altaAlumno("Son", "Goku", "DBZ", 1234, "767666666", "songoku@capsulecorp.com");
            Iterator<Alumno> alumnos = Controlador.getInstance().ubicaAlumno("Son", "Goku");
            Alumno alumno = alumnos.next();
            assertFalse("Deberia haber un unico alumno", alumnos.hasNext());
            assertNotNull("El alumno no deberia ser null", alumno);
            assertEquals("El apellido no es correcto", "Son", alumno.getApellido());
            assertEquals("El nombre no es correcto", "Goku", alumno.getNombre());
            assertEquals("La calle no es correcto", "DBZ", alumno.getDomicilio().getCalle());
            assertEquals("El numero no es correcto", 1234, alumno.getDomicilio().getNumero());
            assertEquals("El telefono no es correcto", "767666666", alumno.getTelefono());
            assertEquals("El email no es correcto", "songoku@capsulecorp.com", alumno.getEmail());
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testAltaProfesor()
    {
        try
        {
            Controlador.getInstance().altaProfesor("Son", "Goku", "DBZ", 1234, "767666666", "songoku@capsulecorp.com");
            Iterator<Profesor> profesores = Controlador.getInstance().ubicaProfesor("Son", "Goku");
            Profesor profesor = profesores.next();
            assertFalse("Deberia haber un unico alumno", profesores.hasNext());
            assertNotNull("El profesor no deberia ser null", profesor);
            assertEquals("El apellido no es correcto", "Son", profesor.getApellido());
            assertEquals("El nombre no es correcto", "Goku", profesor.getNombre());
            assertEquals("La calle no es correcto", "DBZ", profesor.getDomicilio().getCalle());
            assertEquals("El numero no es correcto", 1234, profesor.getDomicilio().getNumero());
            assertEquals("El telefono no es correcto", "767666666", profesor.getTelefono());
            assertEquals("El email no es correcto", "songoku@capsulecorp.com", profesor.getEmail());
        }
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testAltaAsignatura()
    {
        Controlador.getInstance().altaAsignatura("Introduccion al Nen");
        Iterator<Asignatura> asignaturas = Controlador.getInstance().ubicaAsignatura("Introduccion al Nen");
        Asignatura asignatura = asignaturas.next();
        assertFalse("Deberia haber una unica asignatura", asignaturas.hasNext());
        assertNotNull("La asignatura no deberia ser null", asignatura);
        assertEquals("El nombre no es correcto", "Introduccion al Nen", asignatura.getNombre());
    }
    
    @Test
    public void testAltaCursada()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0000", "01-2017", "Miercoles", "13:00", "15:00");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
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
    public void testBajaAlumno()
    {
        try
        {
            Controlador.getInstance().bajaAlumno("ALU0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testBajaProfesor()
    {
        try
        {
            Controlador.getInstance().bajaProfesor("PRO0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testBajaAsignatura()
    {
        try
        {
            Controlador.getInstance().bajaAsignatura("ASI0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testBajaCursada()
    {
        try
        {
            Controlador.getInstance().bajaCursada("CUR0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testModificaAlumno()
    {
        try
        {
            Controlador.getInstance().modificaAlumno("ALU0000", "Son", "Goten", "DBZ", 1234, "767666666", "songoku@capsulecorp.com");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testModificaProfesor()
    {
        try
        {
            Controlador.getInstance().modificaProfesor("PRO0000", "Son", "Goten", "DBZ", 1234, "767666666", "songoku@capsulecorp.com");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EmailInvalidoException e)
        {
            fail("EmailInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testModificaAsignatura()
    {
        try
        {
            Controlador.getInstance().modificaAsignatura("ASI0000", "Guitarra");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testModificaCursada()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0000", "01-2017", "Lunes", "13:00", "15:00");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testConsultaAlumno()
    {
        try
        {
            Controlador.getInstance().consultaAlumno("ALU0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testConsultaProfesor()
    {
        try
        {
            Controlador.getInstance().consultaProfesor("PRO0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testConsultaAsignatura()
    {
        try
        {
            Controlador.getInstance().consultaAsignatura("ASI0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testConsultaCursada()
    {
        try
        {
            Controlador.getInstance().consultaCursada("CUR0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testAprobarAlumno()
    {
        try
        {
            Controlador.getInstance().aprobarAlumno("ALU0000", "CUR0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testRemoveAsignaturaAlumno()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("ALU0000", "ASI0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testAddCompetencia()
    {
        try
        {
            Controlador.getInstance().addCompetencia("PRO0000", "CUR0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testRemoveCompetencia()
    {
        try
        {
            Controlador.getInstance().removeCompetencia("PRO0000", "ASI0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testAddCorrelativa()
    {
        try
        {
            Controlador.getInstance().addCorrelativa("ASI0000", "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testRemoveCorrelativa()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0000", "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testAddAlumnoCursada()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU0000", "CUR0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testRemoveAlumnoCursada()
    {
        try
        {
            Controlador.getInstance().removeAlumnoCursada("ALU0000", "CUR0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testAddProfesorCursada()
    {
        try
        {
            Controlador.getInstance().addProfesorCursada("PRO0000", "CUR0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e)
        {
            fail("HorarioNoViableException no debio ser lanzada");
        }
    }
    
    @Test
    public void testRemoveProfesorCursada()
    {
        try
        {
            Controlador.getInstance().removeProfesorCursada("PRO0000", "CUR0000");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
