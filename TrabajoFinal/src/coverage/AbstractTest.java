package coverage;

import java.util.TreeMap;

import model.Alumno;
import model.Asignatura;
import model.Controlador;
import model.Cursada;
import model.EmailInvalidoException;
import model.EntidadInvalidaException;
import model.HoraInvalidaException;
import model.PeriodoInvalidoException;
import model.Profesor;

public abstract class AbstractTest
{
    
    private Alumno alumnos[];
    private Profesor profesores[];
    private Asignatura asignaturas[];
    private Cursada cursadas[];
    
    public AbstractTest()
    {
        this.alumnos = new Alumno[6];
        this.profesores = new Profesor[7];
        this.asignaturas = new Asignatura[6];
        this.cursadas = new Cursada[10];
    }
    
    public void entidades()
    {
        this.alumnos[1] = this.nuevoAlumno("ALU0000", "Son", "Goku", "DBZ", 1234, "161718", "songoku@cc.com");
        this.alumnos[2] = this.nuevoAlumno("ALU0001", "Son", "Gohan", "DBZ", 1234, "161718", "songohan@cc.com");
        this.alumnos[3] = this.nuevoAlumno("ALU0000", "Black", "Goku", "Futuro alterno", 666, "767", "blackgoku@cc.com");
        this.alumnos[4] = this.nuevoAlumno(null, "Chi Chi", "Milk", "DBZ", 1234, "161718", "milk@cc.com");
        this.alumnos[5] = this.nuevoAlumno("ALU0003", "Del​ ​Potro", "​Juan​ ​Martin", "Mar​ ​Del​ ​Plata", 7600, "155604998", "jm@dp.com");
        
        this.profesores[1] = this.nuevoProfesor("PRO0000", "Whis", "Angel", "TemploBeerus", 1234, "070707", "angelwhis@cc.com");
        this.profesores[2] = this.nuevoProfesor("PRO0001", "Vados", "Angel", "TemploChampa", 1234, "060606", "angelvados@cc.com");
        this.profesores[3] = this.nuevoProfesor("PRO0002", "Pitt", "Brad", "USA", 9999, "4911111", "bradpitt@cc.com");
        this.profesores[4] = this.nuevoProfesor("PRO0000", "Zeno", "Dios", "TemploZeno", 1234, "101010", "zeno@cc.com");
        this.profesores[5] = this.nuevoProfesor(null, "Putin", "Vladimir", "Mother Russia", 12345, "08001010", "putinv@na.com");
        this.profesores[6] = this.nuevoProfesor("PRO0004", "Daniels", "Jack", "Whiskey", 90, "1981", "jackdaniels@jd.com");
        
        this.asignaturas[1] = this.nuevaAsignatura("ASI0000", "Introduccion al Ki");
        this.asignaturas[2] = this.nuevaAsignatura("ASI0001", "Defensa Contra las Artes Oscuras");
        this.asignaturas[3] = this.nuevaAsignatura("ASI0002", "Coreano avanzado");
        this.asignaturas[4] = this.nuevaAsignatura("ASI0000", "Microeconomia");
        this.asignaturas[5] = this.nuevaAsignatura(null, "Combos de Street Fighter V");
        
        this.cursadas[1] = this.nuevaCursada("CUR0000", 1, "01-2016", "Martes", "20:00", "22:00");
        this.cursadas[2] = this.nuevaCursada("CUR0001", 3, "02-2015", "Jueves", "16:00", "18:00");
        this.cursadas[3] = this.nuevaCursada("CUR0002", 2, "01-2018", "Domingo", "04:00", "06:00");
        this.cursadas[4] = this.nuevaCursada("CUR0000", 1, "01-2016", "Miercoles", "20:00", "22:00");
        this.cursadas[5] = this.nuevaCursada(null, 1, "01-2018", "Sabado", "04:00", "06:00");
        this.cursadas[6] = this.nuevaCursada("CUR0004", 2, "01-2016", "Martes", "20:00", "22:00");
        this.cursadas[7] = this.nuevaCursada("CUR0005", 2, "01-2016", "Lunes", "20:00", "22:00");
        this.cursadas[8] = this.nuevaCursada("CUR0006", 1, "01-2016", "Miercoles", "20:00", "22:00");
        this.cursadas[9] = this.nuevaCursada("CUR0007", 1, "01-2016", "Martes", "19:00", "21:00");
        
        this.aprobarAsignatura(1, 1);
        this.aprobarAsignatura(3, 1);
        this.aprobarAsignatura(5, 2);
        this.aprobarAsignatura(5, 3);
        
        this.addCompetencia(1, 1);
        this.addCompetencia(3, 1);
        this.addCompetencia(3, 2);
        this.addCompetencia(6, 1);
        
        this.addCorrelativa(3, 2);
        
        this.addAlumno(1, 2);
        this.addAlumno(7, 2);
        this.addProfesor(1, 1);
        this.addProfesor(8, 1);
        
        Controlador.getInstance().deleteObserver(this.cursadas[5]);
    }
    
    public Alumno alumno(int i)
    {
        return this.alumnos[i];
    }
    
    public Profesor profesor(int i)
    {
        return this.profesores[i];
    }
    
    public Asignatura asignatura(int i)
    {
        return this.asignaturas[i];
    }
    
    public Cursada cursada(int i)
    {
        return this.cursadas[i];
    }
    
    public void escenario1()
    {
        this.entidades();
        
        TreeMap<String, Alumno> alumnos = new TreeMap<String, Alumno>();
        TreeMap<String, Profesor> profesores = new TreeMap<String, Profesor>();
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        TreeMap<String, Cursada> cursadas = new TreeMap<String, Cursada>();
        
        Controlador.getInstance().setAlumnos(alumnos);
        Controlador.getInstance().setProfesores(profesores);
        Controlador.getInstance().setAsignaturas(asignaturas);
        Controlador.getInstance().setCursadas(cursadas);
    }
    
    public void escenario2()
    {
        this.entidades();
        
        TreeMap<String, Alumno> alumnos = new TreeMap<String, Alumno>();
        TreeMap<String, Profesor> profesores = new TreeMap<String, Profesor>();
        TreeMap<String, Asignatura> asignaturas = new TreeMap<String, Asignatura>();
        TreeMap<String, Cursada> cursadas = new TreeMap<String, Cursada>();
        
        alumnos.put(this.alumnos[1].getId(), this.alumnos[1]);
        alumnos.put(this.alumnos[2].getId(), this.alumnos[2]);
        alumnos.put(this.alumnos[5].getId(), this.alumnos[5]);
        
        profesores.put(this.profesores[1].getId(), this.profesores[1]);
        profesores.put(this.profesores[2].getId(), this.profesores[2]);
        profesores.put(this.profesores[3].getId(), this.profesores[3]);
        profesores.put(this.profesores[6].getId(), this.profesores[6]);
        
        asignaturas.put(this.asignaturas[1].getId(), this.asignaturas[1]);
        asignaturas.put(this.asignaturas[2].getId(), this.asignaturas[2]);
        asignaturas.put(this.asignaturas[3].getId(), this.asignaturas[3]);
        
        cursadas.put(this.cursadas[1].getId(), this.cursadas[1]);
        cursadas.put(this.cursadas[2].getId(), this.cursadas[2]);
        cursadas.put(this.cursadas[3].getId(), this.cursadas[3]);
        cursadas.put(this.cursadas[6].getId(), this.cursadas[6]);
        cursadas.put(this.cursadas[7].getId(), this.cursadas[7]);
        cursadas.put(this.cursadas[8].getId(), this.cursadas[8]);
        cursadas.put(this.cursadas[9].getId(), this.cursadas[9]);
        
        Controlador.getInstance().setAlumnos(alumnos);
        Controlador.getInstance().setProfesores(profesores);
        Controlador.getInstance().setAsignaturas(asignaturas);
        Controlador.getInstance().setCursadas(cursadas);
    }
    
    private Alumno nuevoAlumno(String legajo, String apellido, String nombre, String calle, int numero, String telefono, String email)
    {
        Alumno alumno;
        try
        {
            alumno = new Alumno(apellido, nombre, calle, numero, telefono, email);
        }
        catch (EmailInvalidoException e)
        {
            throw new InternalError();
        }
        alumno.setLegajo(legajo);
        return alumno;
    }
    
    private void aprobarAsignatura(int alumno, int asignatura)
    {
        try
        {
            this.alumnos[alumno].aprobarAsignatura(this.asignaturas[asignatura]);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
    }
    
    private Profesor nuevoProfesor(String legajo, String apellido, String nombre, String calle, int numero, String telefono, String email)
    {
        Profesor profesor;
        try
        {
            profesor = new Profesor(apellido, nombre, calle, numero, telefono, email);
        }
        catch (EmailInvalidoException e)
        {
            throw new InternalError();
        }
        profesor.setLegajo(legajo);
        return profesor;
    }
    
    private void addCompetencia(int profesor, int asignatura)
    {
        try
        {
            this.profesores[profesor].addCompetencia(this.asignaturas[asignatura]);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
    }
    
    private Asignatura nuevaAsignatura(String identificacion, String nombre)
    {
        Asignatura asignatura = new Asignatura(nombre);
        asignatura.setIdentificacion(identificacion);
        return asignatura;
    }
    
    private void addCorrelativa(int asignatura, int correlativa)
    {
        try
        {
            this.asignaturas[asignatura].addCorrelativa(this.asignaturas[correlativa]);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
    }
    
    private Cursada nuevaCursada(String identificacion, int asignatura, String periodo, String dia, String horaInicio, String horaFin)
    {
        Cursada cursada;
        try
        {
            cursada = new Cursada(this.asignaturas[asignatura], periodo, dia, horaInicio, horaFin);
        }
        catch (HoraInvalidaException | PeriodoInvalidoException e)
        {
            throw new InternalError();
        }
        cursada.setIdentificacion(identificacion);
        return cursada;
    }
    
    private void addAlumno(int cursada, int alumno)
    {
        try
        {
            this.cursadas[cursada].addAlumno(this.alumnos[alumno]);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
    }
    
    private void addProfesor(int cursada, int profesor)
    {
        try
        {
            this.cursadas[cursada].addProfesor(this.profesores[profesor]);
        }
        catch (EntidadInvalidaException e)
        {
            throw new InternalError();
        }
    }
    
}
