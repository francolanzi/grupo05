package test;

import java.util.Iterator;
import java.util.TreeMap;

import model.Alumno;
import model.Controlador;

import model.EmailInvalidoException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class AlumnoTest
{
    
    private Alumno alumno;
    
    @Before
    public void setUp()
    {
        try
        {
            alumno = new Alumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjj@jjj.com");
        }
        catch (EmailInvalidoException e)
        {
            throw new InternalError();
        }
        alumno.setLegajo("ALU0001");
        TreeMap<String, Alumno> alumnos = new TreeMap<String, Alumno>();
        alumnos.put("ALU0001", alumno);
        Controlador.getInstance().setAlumnos(alumnos);
    }
    
    @Test
    public void testAltaAlumno()
    {
        
        //Clases correctas
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjj@jjj.com");
        }
        catch (EmailInvalidoException e)
        {
            fail("El alumno debio ser creado correctamente");
        }
        
        //Valores limites
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 1, "2", "j@j");
        }
        catch (EmailInvalidoException e)
        {
            fail("El alumno debio ser creado correctamente");
        }
        
        //El email no contiene @
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjjjjjj.com");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
        
        //El email no contiene carcateres antes de @
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "@jjj.com");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
        
        //El email no contiene carcateres despues de @
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "jjjj@");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
        
        //El email no contiene carcateres antes de @ y solo uno despues
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "2235357381", "@j");
            fail("Debio lanzarse EmailInvalidoException");
        }
        catch (EmailInvalidoException e){}
        
        //El nombre es null
        try
        {
            Controlador.getInstance().altaAlumno("Pico", null, "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El nombre es vacio
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El apellido es null
        try
        {
            Controlador.getInstance().altaAlumno(null, "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El apellido es vacio
        try
        {
            Controlador.getInstance().altaAlumno("", "Juan", "Falucho", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //La calle es null
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", null, 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //La calle es vacia
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "", 3433, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El numero es negativo
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", -1233, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El numero es -1
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", -1, "2235357381", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El telefono es null
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, null, "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}
        
        //El telefono es vacio
        try
        {
            Controlador.getInstance().altaAlumno("Pico", "Juan", "Falucho", 3433, "", "jjjj@jjjj.com");
            fail("El alumno no debio ser creado");
        }
        catch (EmailInvalidoException e){}

    }
    
    @Test
    public void testUbicaAlumno()
    {
        Iterator<Alumno> alumnos;
        
        //Alumno existente en la coleccion
        alumnos = Controlador.getInstance().ubicaAlumno("Pico", "Juan");
        assertEquals("El alumno no es el esperado", alumno, alumnos.next());
        assertFalse("Deberia haber un solo alumno", alumnos.hasNext());
        
        //Alumno inexistente en la coleccion
        alumnos = Controlador.getInstance().ubicaAlumno("Ponce", "Emanuel");
        assertFalse("El iterator deberia estar vacio", alumnos.hasNext());
        
        //El nombre es null
        alumnos = Controlador.getInstance().ubicaAlumno("Pico", null);
        fail("La busqueda debio fallar");
        
        //El apellido es null
        alumnos = Controlador.getInstance().ubicaAlumno(null, "Juan");
        fail("La busqueda debio fallar");
        
    }
    
}
