package coverage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Iterator;

import model.Alumno;
import model.Asignatura;
import model.Controlador;
import model.Cursada;
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

public class ControladorTest2 extends AbstractTest
{
    
    @Before
    public void setUp()
    {
        super.escenario2();
    }
    
    @Test
    public void testGetInstance()
    {
        assertNotNull("El controlador no deberia ser null", Controlador.getInstance());
    }
    
    private boolean isCursadaNueva(Cursada cursada)
    {
        return cursada.getAsignatura().equals(super.asignatura(1)) &&
               cursada.getPeriodo().equals("01-2017") &&
               cursada.getDia().equals("Miercoles") &&
               cursada.getHoraInicio().equals("13:00") &&
               cursada.getHoraFin().equals("15:00");
    }
    
    @Test
    public void testAltaCursada()
    {
        try
        {
            Controlador.getInstance().altaCursada("ASI0000", "01-2017", "Miercoles", "13:00", "15:00");
            Iterator<Cursada> cursadas = Controlador.getInstance().ubicaCursada("Introduccion al Ki");
            Cursada cursada;
            do
                cursada = cursadas.next();
            while (cursadas.hasNext() && !this.isCursadaNueva(cursada));
            assertTrue("La cursada no fue creada correctamente", this.isCursadaNueva(cursada));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
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
    public void testBajaAlumno()
    {
        try
        {
            Controlador.getInstance().bajaAlumno("ALU0000");
            assertFalse("El alumno debio haber sido eliminado", Controlador.getInstance().getAlumnos().containsKey("ALU0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testBajaProfesor()
    {
        try
        {
            Controlador.getInstance().bajaProfesor("PRO0000");
            assertFalse("El profesor debio haber sido eliminado", Controlador.getInstance().getProfesores().containsKey("PRO0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testBajaAsignatura()
    {
        try
        {
            Controlador.getInstance().bajaAsignatura("ASI0000");
            assertFalse("La asignatura debio haber sido eliminada", Controlador.getInstance().getAsignaturas().containsKey("ASI0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testBajaCursada()
    {
        try
        {
            Controlador.getInstance().bajaCursada("CUR0000");
            assertFalse("La cursada debio haber sido eliminada", Controlador.getInstance().getCursadas().containsKey("CUR0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testModificaAlumno()
    {
        try
        {
            Controlador.getInstance().modificaAlumno("ALU0000", "Son", "Goten", "DBZS", 1234, "767666676", "songoten@capsulecorp.com");
            Alumno alumno = Controlador.getInstance().consultaAlumno("ALU0000");
            assertEquals("El apellido no se modifico correctamente", "Son", alumno.getApellido());
            assertEquals("El nombre no se modifico correctamente", "Goten", alumno.getNombre());
            assertEquals("La calle no se modifico correctamente", "DBZS", alumno.getDomicilio().getCalle());
            assertEquals("El numero no se modifico correctamente", 1234, alumno.getDomicilio().getNumero());
            assertEquals("El telefono no se modifico correctamente", "767666676", alumno.getTelefono());
            assertEquals("El email no se modifico correctamente", "songoten@capsulecorp.com", alumno.getEmail());
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
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
            Controlador.getInstance().modificaProfesor("PRO0000", "Son", "Goku", "DBZ", 1234, "767666666", "songoku@capsulecorp.com");
            Profesor profesor = Controlador.getInstance().consultaProfesor("PRO0000");
            assertEquals("El apellido no se modifico correctamente", "Son", profesor.getApellido());
            assertEquals("El nombre no se modifico correctamente", "Goku", profesor.getNombre());
            assertEquals("La calle no se modifico correctamente", "DBZ", profesor.getDomicilio().getCalle());
            assertEquals("El numero no se modifico correctamente", 1234, profesor.getDomicilio().getNumero());
            assertEquals("El telefono no se modifico correctamente", "767666666", profesor.getTelefono());
            assertEquals("El email no se modifico correctamente", "songoku@capsulecorp.com", profesor.getEmail());
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
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
            Asignatura asignatura = Controlador.getInstance().consultaAsignatura("ASI0000");
            assertEquals("El nombre no se modifico correctamente", "Guitarra", asignatura.getNombre());
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testModificaCursada1()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0000", "01-2016", "Lunes", "20:00", "22:00");
            fail("Debio lanzarse HorarioNoViableException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e){}
    }
    
    @Test
    public void testModificaCursada2()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0000", "01-2016", "Miercoles", "20:00", "22:00");
            fail("Debio lanzarse HorarioNoViableException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("PeriodoInvalidoException no debio ser lanzada");
        }
        catch (HoraInvalidaException e)
        {
            fail("HoraInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e){}
    }
    
    @Test
    public void testModificaCursada3()
    {
        try
        {
            Controlador.getInstance().modificaCursada("CUR0000", "01-2017", "Lunes", "19:00", "21:00");
            Cursada cursada = Controlador.getInstance().consultaCursada("CUR0000");
            assertEquals("El periodo no se modifico correctamente", "01-2017", cursada.getPeriodo());
            assertEquals("El dia no se modifico correctamente", "Lunes", cursada.getDia());
            assertEquals("La hora de inicio no se modifico correctamente", "19:00", cursada.getHoraInicio());
            assertEquals("La hora de finalizacion no se modifico correctamente", "21:00", cursada.getHoraFin());
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
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
    public void testUbicaAlumno()
    {
        Iterator<Alumno> alumnos = Controlador.getInstance().ubicaAlumno("Son", "Gohan");
        Alumno alumno = alumnos.next();
        assertFalse("Deberia haber un unico alumno", alumnos.hasNext());
        assertEquals("El alumno no es el esperado", super.alumno(2), alumno);
    }
    
    @Test
    public void testUbicaProfesor()
    {
        Iterator<Profesor> profesores = Controlador.getInstance().ubicaProfesor("Vados", "Angel");
        Profesor profesor = profesores.next();
        assertFalse("Deberia haber un unico profesor", profesores.hasNext());
        assertEquals("El profesor no es el esperado", super.profesor(2), profesor);
    }
    
    @Test
    public void testUbicaAsignatura()
    {
        Iterator<Asignatura> asignaturas = Controlador.getInstance().ubicaAsignatura("Coreano avanzado");
        Asignatura asignatura = asignaturas.next();
        assertFalse("Deberia haber una unica asignatura", asignaturas.hasNext());
        assertEquals("La asignatura no es la esperada", super.asignatura(3), asignatura);
    }
    
    @Test
    public void testUbicaCursada()
    {
        Iterator<Cursada> cursadas = Controlador.getInstance().ubicaCursada("Coreano avanzado");
        Cursada cursada = cursadas.next();
        assertFalse("Deberia haber una unica cursada", cursadas.hasNext());
        assertEquals("La cursada no es la esperada", super.cursada(2), cursada);
    }
    
    @Test
    public void testConsultaAlumno()
    {
        try
        {
            assertEquals("El alumno no es el esperado", super.alumno(1), Controlador.getInstance().consultaAlumno("ALU0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testConsultaProfesor()
    {
        try
        {
            assertEquals("El profesor no es el esperado", super.profesor(1), Controlador.getInstance().consultaProfesor("PRO0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testConsultaAsignatura()
    {
        try
        {
            assertEquals("La asignatura no es la esperada", super.asignatura(1), Controlador.getInstance().consultaAsignatura("ASI0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testConsultaCursada()
    {
        try
        {
            assertEquals("La cursada no es la esperada", super.cursada(1), Controlador.getInstance().consultaCursada("CUR0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testAprobarAlumno1()
    {
        try
        {
            Controlador.getInstance().aprobarAlumno("ALU0000", "CUR9999");
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
            Controlador.getInstance().aprobarAlumno("ALU0001", "CUR0000");
            assertTrue("El alumno debio aprobar la asignatura", super.alumno(2).isAprobada("ASI0000"));
            assertFalse("El alumno debio ser removido de la cursada", super.cursada(1).hasAlumno("ALU0001"));
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
    public void testRemoveAsignaturaAlumno1()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("ALU0000", "ASI9999");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testRemoveAsignaturaAlumno2()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("ALU0003", "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testRemoveAsignaturaAlumno3()
    {
        try
        {
            Controlador.getInstance().removeAsignaturaAlumno("ALU0000", "ASI0000");
            assertFalse("La asignatura debio ser removida de la historia del alumno", super.alumno(1).isAprobada("ASI0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testAddCompetencia1()
    {
        try
        {
            Controlador.getInstance().addCompetencia("PRO0000", "ASI9999");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testAddCompetencia2()
    {
        try
        {
            Controlador.getInstance().addCompetencia("PRO0001", "ASI0001");
            assertTrue("El profesor deberia ser competente", super.profesor(2).isCompetente("ASI0001"));
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
    public void testRemoveCompetencia1()
    {
        try
        {
            Controlador.getInstance().removeCompetencia("PRO0000", "ASI9999");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testRemoveCompetencia2()
    {
        try
        {
            Controlador.getInstance().removeCompetencia("PRO0000", "ASI0000");
            assertFalse("El no profesor deberia ser competente", super.profesor(1).isCompetente("ASI0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testAddCorrelativa1()
    {
        try
        {
            Controlador.getInstance().addCorrelativa("ASI0000", "ASI9999");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
    }
    
    @Test
    public void testAddCorrelativa2()
    {
        try
        {
            Controlador.getInstance().addCorrelativa("ASI0000", "ASI0001");
            assertTrue("La correlativa debio ser agregada a la asignatura", super.asignatura(1).isCorrelativa("ASI0001"));
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
    public void testRemoveCorrelativa1()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0000", "ASI9999");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testRemoveCorrelativa2()
    {
        try
        {
            Controlador.getInstance().removeCorrelativa("ASI0002", "ASI0001");
            assertFalse("La correlativa debio ser removida a la asignatura", super.asignatura(3).isCorrelativa("ASI0001"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testCompatibilidadHorariaAlumno1()
    {
        try
        {
            Class paramTypes[] = new Class[2];
            paramTypes[0] = String.class;
            paramTypes[1] = Cursada.class;
            Method method = Controlador.class.getDeclaredMethod("compatibilidadHorariaAlumno", paramTypes);
            Object args[] = new Object[2];
            args[0] = "ALU0001";
            args[1] = super.cursada(3);
            method.setAccessible(true);
            Boolean result = (Boolean) method.invoke(Controlador.getInstance(), args);
            assertTrue("El alumno deberia tener compatibilidad horaria", result);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            throw new InternalError();
        }
    }
    
    @Test
    public void testCompatibilidadHorariaProfesor1()
    {
        try
        {
            Class paramTypes[] = new Class[2];
            paramTypes[0] = String.class;
            paramTypes[1] = Cursada.class;
            Method method = Controlador.class.getDeclaredMethod("compatibilidadHorariaProfesor", paramTypes);
            Object args[] = new Object[2];
            args[0] = "PRO0000";
            args[1] = super.cursada(3);
            method.setAccessible(true);
            Boolean result = (Boolean) method.invoke(Controlador.getInstance(), args);
            assertTrue("El profesor deberia tener compatibilidad horaria", result);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            throw new InternalError();
        }
    }
    
    @Test
    public void testCompatibilidadHorariaAlumno2()
    {
        try
        {
            Class paramTypes[] = new Class[5];
            for (int i = 0; i < 5; i++)
                paramTypes[i] = String.class;
            Method method = Controlador.class.getDeclaredMethod("compatibilidadHorariaAlumno", paramTypes);
            Object args[] = new Object[5];
            args[0] = "ALU0001";
            args[1] = "01-2018";
            args[2] = "Domingo";
            args[3] = "04:00";
            args[4] = "06:00";
            method.setAccessible(true);
            Boolean result = (Boolean) method.invoke(Controlador.getInstance(), args);
            assertTrue("El alumno deberia tener compatibilidad horaria", result);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            throw new InternalError();
        }
    }
    
    @Test
    public void testCompatibilidadHorariaProfesor2()
    {
        try
        {
            Class paramTypes[] = new Class[5];
            for (int i = 0; i < 5; i++)
                paramTypes[i] = String.class;
            Method method = Controlador.class.getDeclaredMethod("compatibilidadHorariaAlumno", paramTypes);
            Object args[] = new Object[5];
            args[0] = "PRO0000";
            args[1] = "01-2018";
            args[2] = "Domingo";
            args[3] = "04:00";
            args[4] = "06:00";
            method.setAccessible(true);
            Boolean result = (Boolean) method.invoke(Controlador.getInstance(), args);
            assertTrue("El profesor deberia tener compatibilidad horaria", result);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            throw new InternalError();
        }
    }
    
    @Test
    public void testAddAlumnoCursada1()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU0000", "CUR9999");
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
    public void testAddAlumnoCursada2()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU0001", "CUR0004");
            fail("Debio lanzarse HorarioNoViableException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e){}
    }
    
    @Test
    public void testAddAlumnoCursada3()
    {
        try
        {
            Controlador.getInstance().addAlumnoCursada("ALU0001", "CUR0002");
            assertTrue("El alumno debio ser agregado a la cursada", super.cursada(3).hasAlumno("ALU0001"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
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
    public void testRemoveAlumnoCursada1()
    {
        try
        {
            Controlador.getInstance().removeAlumnoCursada("ALU0000", "CUR9999");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testRemoveAlumnoCursada2()
    {
        try
        {
            Controlador.getInstance().removeAlumnoCursada("ALU0001", "CUR0000");
            assertFalse("El alumno debio ser removido de la cursada", super.cursada(1).hasAlumno("ALU0001"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testAddProfesorCursada1()
    {
        try
        {
            Controlador.getInstance().addProfesorCursada("PRO0000", "CUR9999");
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
    public void testAddProfesorCursada2()
    {
        try
        {
            Controlador.getInstance().addProfesorCursada("PRO0000", "CUR0007");
            fail("Debio lanzarse HorarioNoViableException");
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
        catch (EntidadInvalidaException e)
        {
            fail("EntidadInvalidaException no debio ser lanzada");
        }
        catch (HorarioNoViableException e){}
    }
    
    @Test
    public void testAddProfesorCursada3()
    {
        try
        {
            Controlador.getInstance().addProfesorCursada("PRO0004", "CUR0000");
            assertTrue("El profesor debio ser agregado a la cursada", super.cursada(1).hasProfesor("PRO0004"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
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
    public void testRemoveProfesorCursada1()
    {
        try
        {
            Controlador.getInstance().removeProfesorCursada("PRO0000", "CUR9999");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testRemoveProfesorCursada2()
    {
        try
        {
            Controlador.getInstance().removeProfesorCursada("PRO0000", "CUR0000");
            assertFalse("El profesor debio ser removido de la cursada", super.cursada(1).hasProfesor("PRO0000"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
}
