package test;

import java.util.TreeMap;

import model.Asignatura;
import model.Controlador;
import model.EmailInvalidoException;
import model.EntidadInvalidaException;
import model.IdInvalidoException;
import model.Profesor;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RemoveCompetenciaTest
{
    
    private Profesor profesor;
    
    @Before
    public void setUp()
    {
        Asignatura asignatura1 = new Asignatura("mateA");
        asignatura1.setIdentificacion("ASI0001");
        Asignatura asignatura2 = new Asignatura("mateB");
        asignatura2.setIdentificacion("ASI0002");
        
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        asignaturas.put("ASI0001", asignatura1);
        asignaturas.put("ASI0002", asignatura2);
        Controlador.getInstance().setAsignaturas(asignaturas);
        
        try
        {
            profesor = new Profesor("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
        }
        catch (EmailInvalidoException e)
        {
            throw new InternalError();
        }
        profesor.setLegajo("PRO0001");
        try
        {
            profesor.addCompetencia(asignatura1);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
        
        TreeMap<String, Profesor> profesores = new TreeMap<String, Profesor>();
        profesores.put("PRO0001", profesor);
        Controlador.getInstance().setProfesores(profesores);
    }
    
    @Test
    public void testValoresCorrectos()
    {
        try
        {
            Controlador.getInstance().removeCompetencia("PRO0001", "ASI0001");
            assertFalse("La competencia debio haber sido eliminada", profesor.isCompetente("ASI0001"));
        }
        catch (IdInvalidoException e)
        {
            fail("IdInvalidoException no debio ser lanzada");
        }
    }
    
    @Test
    public void testIdProfesorNull()
    {
        try
        {
            Controlador.getInstance().removeCompetencia(null, "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdProfesorVacio()
    {
        try
        {
            Controlador.getInstance().removeCompetencia("", "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdProfesorInexistente()
    {
        try
        {
            Controlador.getInstance().removeCompetencia("PRO2222", "ASI0001");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAsignaturaNull()
    {
        try
        {
            Controlador.getInstance().removeCompetencia("PRO0001", null);
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAsignaturaVacio()
    {
        try
        {
            Controlador.getInstance().removeCompetencia("PRO0001", "");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testIdAsignaturaInexistente()
    {
        try
        {
            Controlador.getInstance().removeCompetencia("PRO0001", "ASI2222");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
    @Test
    public void testCompentenciaNoAgregada()
    {
        try
        {
            Controlador.getInstance().removeCompetencia("PRO0001", "ASI0002");
            fail("Debio lanzarse IdInvalidoException");
        }
        catch (IdInvalidoException e){}
    }
    
}
