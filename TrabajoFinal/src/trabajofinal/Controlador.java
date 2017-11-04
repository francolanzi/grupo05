package trabajofinal;

import java.util.Iterator;
import java.util.Observable;
import java.util.TreeMap;

public class Controlador extends Observable
{
    
    private static Controlador controlador = null;
    
    private TreeMap<String, Alumno> alumnos;
    private TreeMap<String, Profesor> profesores;
    private TreeMap<String, Asignatura> asignaturas;
    private TreeMap<String, Cursada> cursadas;

    /**
     * Constructor privado de la clase Controlador
     * <br>
     * La clase implementa el patron Singleton
     * <br>
     * <b>Post:</b> se ha creado un nuevo controlador con todas sus colecciones vacias
     */
    private Controlador()
    {
        this.alumnos = new TreeMap<String, Alumno>();
        this.profesores = new TreeMap<String, Profesor>();
        this.asignaturas = new TreeMap<String, Asignatura>();
        this.cursadas = new TreeMap<String,Cursada>();
    }

    /**
     * Obtiene la unica instancia del Controlador y si no existe, la crea
     * @return Unica instancia del Controlador
     */
    public static Controlador getInstance()
    {
        if (controlador == null)
            controlador = new Controlador();
        return controlador;
    }
    
    //...........................................INSPECCION...........................................
    //Si bien en las altas es posible resumir las dos sentencias en una sola, instanciar a la entidad
    //antes de agregarla perimite que esta genere su id y ademas facilita la lectura del codigo

    /**
     * Agrega un nuevo alumno al sistema
     * <br>
     * <b>Pre:</b> apellido, nombre, calle, numero y telefono son validos
     * <br>
     * <b>Post:</b> se ha agregado al sistema un nuevo alumno con un legajo unico
     * @param apellido Apellido del alumno
     * @param nombre Nombre del alumno
     * @param calle Calle del domicilio del alumno
     * @param numero Numero del domicilio del alumno
     * @param telefono Telefono del alumno
     * @param email Email del alumno
     * @throws EmailInvalidoException El email no cumple con la mascara AAAAAA@AAAAAA
     */
    public void altaAlumno(String apellido, String nombre, String calle, int numero, String telefono, String email)
    throws EmailInvalidoException
    {
        Alumno alumno = new Alumno(apellido, nombre, calle, numero, telefono, email);
        this.alumnos.put(alumno.getId(), alumno);
    }

    /**
     * Agrega un nuevo profesor al sistema
     * <br>
     * <b>Pre:</b> apellido, nombre, calle, numero y telefono son validos
     * <br>
     * <b>Post:</b> se ha agregado al sistema un nuevo profesor con un legajo unico
     * @param apellido Apellido del profesor
     * @param nombre Nombre del profesor
     * @param calle Calle del domicilio del profesor
     * @param numero Numero del domicilio del profesor
     * @param telefono Telefono del profesor
     * @param email Email del profesor
     * @throws EmailInvalidoException El email no cumple con la mascara AAAAAA@AAAAAA
     */
    public void altaProfesor(String apellido, String nombre, String calle, int numero, String telefono, String email)
    throws EmailInvalidoException
    {
        Profesor profesor = new Profesor(apellido, nombre, calle, numero, telefono, email);
        this.profesores.put(profesor.getId(), profesor);
    }

    /**
     * Agrega una nueva asignatura al sistema
     * <br>
     * <b>Pre:</b> el nombre es valido
     * <br>
     * <b>Post:</b> se ha agregado al sistema una nueva asignatura con una identificacion unica
     * @param nombre Nombre de la asignatura
     */
    public void altaAsignatura(String nombre)
    {
        Asignatura asignatura = new Asignatura(nombre);
        this.asignaturas.put(asignatura.getId(), asignatura);
    }

    /**
     * Agrega una nueva cursada al sistema
     * <br>
     * <b>Pre:</b> el dia es valido
     * <br>
     * <b>Post:</b> se ha agregado al sistema una nueva cursada con una identificacion unica
     * @param identificacion Identificacion de la asignatura de la cursada
     * @param periodo Periodo de la cursada
     * @param dia Dia de la cursada
     * @param horaInicio Hora de inicio de la cursada
     * @param horaFin Hora de finalizacion de la cursada
     * @throws IdInvalidoException No existe una asignatura con la identificacion
     * @throws PeriodoInvalidoException El periodo no cumple con la mascara CC-AAAA
     * @throws HoraInvalidaException La hora no existe o no cumple con la mascara 99:99
     */
    public void altaCursada(String identificacion, String periodo, String dia, String horaInicio, String horaFin)
    throws IdInvalidoException, PeriodoInvalidoException, HoraInvalidaException
    {
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        Cursada cursada = new Cursada(this.asignaturas.get(identificacion), periodo, dia, horaInicio, horaFin);
        this.cursadas.put(cursada.getId(), cursada);
    }
    
    //...............................................INSPECCION...............................................
    //El hecho de que el metodo remove del TreeMap retorne null no garantiza que no habia un objeto almacenado
    //con esa clave, ya que tambien puede significar que el objeto almacenado con esa clave sea null

    /**
     * Elimina un alumno del sistema
     * <br>
     * <b>Post:</b> se ha eliminado al alumno del sistema
     * @param legajo Legajo del alumno
     * @throws IdInvalidoException No existe un alumno con ese legajo
     */
    public void bajaAlumno(String legajo) 
    throws IdInvalidoException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        this.alumnos.remove(legajo);
        setChanged();
        notifyObservers(legajo);
    }

    /**
     * Elimina un profesor del sistema
     * <br>
     * <b>Post:</b> se ha eliminado al profesor del sistema
     * @param legajo Legajo del profesor
     * @throws IdInvalidoException No existe un profesor con ese legajo
     */
    public void bajaProfesor(String legajo)
    throws IdInvalidoException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        this.profesores.remove(legajo);
        setChanged();
        notifyObservers(legajo);
    }

    /**
     * Elimina una asignatura del sistema
     * <br>
     * <b>Post:</b> se ha eliminado a la asignatura del sistema
     * @param identificacion Identificacion de la asignatura
     * @throws IdInvalidoException No existe una asignatura con esa identificacion
     */
    public void bajaAsignatura(String identificacion)
    throws IdInvalidoException
    {
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        this.asignaturas.remove(identificacion);
        setChanged();
        notifyObservers(identificacion);
    }
    
    /**
     * Elimina una cursada del sistema
     * <br>
     * <b>Post:</b> se ha eliminado a la cursada del sistema
     * @param identificacion Identificacion de la cursada
     * @throws IdInvalidoException No existe una cursada con esa identificacion
     */
    public void bajaCursada(String identificacion)
    throws IdInvalidoException
    {
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        this.cursadas.remove(identificacion);
    }

    /**
     * Modifica un alumno del sistema
     * <br>
     * <b>Pre:</b> apellido, nombre, calle, numero y telefono son validos
     * <b>Post:</b> los atributos del alumno han sido modificados
     * @param legajo Legajo del alumno
     * @param apellido Apellido del alumno
     * @param nombre Nombre del alumno
     * @param calle Calle del domicilio del alumno
     * @param numero Numero del domicilio del alumno
     * @param telefono Telefono del alumno
     * @param email Email del alumno
     * @throws IdInvalidoException No existe un alumno con ese legajo
     * @throws EmailInvalidoException El email no cumple con la mascara AAAAAA@AAAAAA
     */
    public void modificaAlumno(String legajo, String apellido, String nombre, String calle, int numero, String telefono, String email)
    throws IdInvalidoException, EmailInvalidoException
    {
        if(!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        this.alumnos.get(legajo).modificar(apellido, nombre, calle, numero, telefono, email);
    }
    
    /**
     * Modifica un profesor del sistema
     * <br>
     * <b>Pre:</b> apellido, nombre, calle, numero y telefono son validos
     * <b>Post:</b> los atributos del profesor han sido modificados
     * @param legajo Legajo del profesor
     * @param apellido Apellido del profesor
     * @param nombre Nombre del profesor
     * @param calle Calle del domicilio del profesor
     * @param numero Numero del domicilio del profesor
     * @param telefono Telefono del profesor
     * @param email Email del profesor
     * @throws IdInvalidoException No existe un profesor con ese legajo
     * @throws EmailInvalidoException El email no cumple con la mascara AAAAAA@AAAAAA
     */
    public void modificaProfesor(String legajo, String apellido, String nombre, String calle, int numero, String telefono, String email)
    throws IdInvalidoException, EmailInvalidoException
    {
        if(!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        this.profesores.get(legajo).modificar(apellido, nombre, calle, numero, telefono, email);
    }

    /**
     * Modifica una asignatura del sistema
     * <br>
     * <b>Pre:</b> el nombre es valido
     * <b>Post:</b> los atributos de la asignatura han sido modificados
     * @param identificacion Identificacion de la asignatura
     * @param nombre Nombre de la asignatura
     * @throws IdInvalidoException No existe una asignatura con esa identificacion
     */
    public void modificaAsignatura(String identificacion, String nombre)
    throws IdInvalidoException
    {
        if(!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        this.asignaturas.get(identificacion).setNombre(nombre);
    }

    /**
     * Modifica una cursada del sistema
     * <br>
     * <b>Pre:</b> el dia es valido
     * <b>Post:</b> los atributos de la cursada han sido modificados
     * @param identificacion Identificacion de la cursada
     * @param periodo Periodo de la cursada
     * @param dia Dia de la cursada
     * @param horaInicio Hora de inicio de la cursada
     * @param horaFin Hora de finalizacion de la cursada
     * @throws IdInvalidoException No existe una cursada con esa identificacion
     * @throws PeriodoInvalidoException El periodo no cumple con la mascara CC-AAAA
     * @throws HoraInvalidaException La hora no existe o no cumple con la mascara 99:99
     * @throws HorarioNoViableException Algun profesor o alumno de la cursada no puede cursar en el nuevo horario
     */
    public void modificaCursada(String identificacion, String periodo, String dia, String horaInicio, String horaFin)
    throws IdInvalidoException, PeriodoInvalidoException, HoraInvalidaException, HorarioNoViableException
    {
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        Iterator<Alumno> alumnos = this.getAlumnosIterator();
        boolean compatible = true;
        while (alumnos.hasNext() && compatible)
            compatible = this.compatibilidadHorariaAlumno(alumnos.next().getId(), periodo, dia, horaInicio, horaFin);
        if (!compatible)
            throw new HorarioNoViableException(periodo, dia, horaInicio, horaFin, "Algun alumno no puede cursar en ese horario");
        Iterator<Profesor> profesores = this.getProfesoresIterator();
        while (profesores.hasNext() && compatible)
            compatible = this.compatibilidadHorariaProfesor(profesores.next().getId(), periodo, dia, horaInicio, horaFin);
        if (!compatible)
            throw new HorarioNoViableException(periodo, dia, horaInicio, horaFin, "Algun profesor no puede cursar en ese horario");
        this.cursadas.get(identificacion).modificar(periodo, dia, horaInicio, horaFin);
    }

    /**
     * Obtiene los alumnos cuyos nombre y apellido contienen a los parametros
     * @param apellido Apellido del alumno o parte de este
     * @param nombre Nombre del alumno o parte de este
     * @return Iterator de los alumnos resultantes de la busqueda
     */
    public Iterator<Alumno> ubicaAlumno(String apellido, String nombre)
    {
        TreeMap<String, Alumno> retorno = new TreeMap<String, Alumno>();
        Iterator<Alumno> alumnos = this.getAlumnosIterator();
        while(alumnos.hasNext())
        {
            Alumno otro = alumnos.next();
            if (otro.getApellido().contains(apellido) && otro.getNombre().contains(nombre))
                retorno.put(otro.getId(), otro);
        }
        return retorno.values().iterator();
    }

    /**
     * Obtiene los profesores cuyos nombre y apellido contienen a los parametros
     * @param apellido Apellido del profesor o parte de este
     * @param nombre Nombre del profesor o parte de este
     * @return Iterator de los profesores resultantes de la busqueda
     */
    public Iterator<Profesor> ubicaProfesor(String apellido, String nombre)
    {
        TreeMap<String, Profesor> retorno = new TreeMap<String, Profesor>();
        Iterator<Profesor> profesores = this.getProfesoresIterator();
        while(profesores.hasNext())
        {
            Profesor otro = profesores.next();
            if (otro.getApellido().contains(apellido) && otro.getNombre().contains(nombre))
                retorno.put(otro.getId(), otro);
        }
        return retorno.values().iterator();
    }

    /**
     * Obtiene las asignaturas cuyo nombre contiene al parametro
     * @param nombre Nombre de la asignatura o parte de este
     * @return Iterator de las asignaturas resultantes de la busqueda
     */
    public Iterator<Asignatura> ubicaAsignatura(String nombre)
    {
        TreeMap<String, Asignatura> retorno = new TreeMap<String, Asignatura>();
        Iterator<Asignatura> asignaturas = this.getAsignaturasIterator();
        while(asignaturas.hasNext())
        {
            Asignatura otro = asignaturas.next();
            if (otro.getNombre().contains(nombre))
                retorno.put(otro.getId(), otro);
        }
        return retorno.values().iterator();
    }
    
    /**
     * Obtiene las cursadas cuyo nombre contiene al parametro
     * @param nombre Nombre de la cursada o parte de este
     * @return Iterator de las cursadas resultantes de la busqueda
     */
    public Iterator<Cursada> ubicaCursada(String nombre)
    {
        TreeMap<String, Cursada> retorno = new TreeMap<String, Cursada>();
        Iterator<Cursada> cursadas = this.getCursadasIterator();
        while(cursadas.hasNext())
        {
            Cursada otro = cursadas.next();
            if (otro.getAsignatura().getNombre().contains(nombre))
                retorno.put(otro.getId(), otro);
        }
        return retorno.values().iterator();
    }

    /**
     * Obtiene un alumno del sistema
     * @param legajo Legajo del alumno
     * @return Alumno con el legajo especificado
     * @throws IdInvalidoException No existe un alumno con ese legajo
     */
    public Alumno consultaAlumno(String legajo)
    throws IdInvalidoException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        return this.alumnos.get(legajo);
    }
    
    /**
     * Obtiene un profesor del sistema
     * @param legajo Legajo del profesor
     * @return Profesor con el legajo especificado
     * @throws IdInvalidoException No existe un profesor con ese legajo
     */
    public Profesor consultaProfesor(String legajo)
    throws IdInvalidoException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        return this.profesores.get(legajo);
    }

    /**
     * Obtiene una asignatura del sistema
     * @param identificacion Identificacion de la asignatura
     * @return Asignatura con la identificacion especificada
     * @throws IdInvalidoException No existe una asignatura con esa identificacion
     */
    public Asignatura consultaAsignatura(String identificacion)
    throws IdInvalidoException
    {
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        return this.asignaturas.get(identificacion);
    }
    
    /**
     * Obtiene una cursada del sistema
     * @param identificacion Identificacion de la cursada
     * @return Cursada con la identificacion especificada
     * @throws IdInvalidoException No existe una cursada con esa identificacion
     */
    public Cursada consultaCursada(String identificacion)
    throws IdInvalidoException
    {
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        return this.cursadas.get(identificacion);
    }

    /**
     * Agrega la asignatura de una cursada a la historia de un alumno y lo elimina de la misma
     * <br>
     * <b>Post:</b> la asignatura ha sido agregada a la historia del alumno
     * y el alumno ha sido eliminado de la cursada
     * @param legajo Legajo del alumno
     * @param identificacion Identificacion de la cursada
     * @throws IdInvalidoException No existe un alumno con ese legajo 
     * o no existe una cursada con esa identificacion
     * @throws EntidadInvalidaException La asignatura ya se encuentra en la historia del alumno
     */
    public void aprobarAlumno(String legajo, String identificacion)
    throws IdInvalidoException, EntidadInvalidaException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        this.cursadas.get(identificacion).aprobarAlumno(legajo);
    }

    /**
     * Elimina una asignatura de la historia de un alumno
     * <br>
     * <b>Post:</b> la asignatura ha sido eliminada de la historia del alumno
     * @param legajo Legajo del alumno
     * @param identificacion Idenficacion de la asignatura
     * @throws IdInvalidoException No existe un alumno con ese legajo, 
     * no existe una asignatura con esa identificacion, 
     * la asignatura no se encuentra en la historia del alumno 
     * o hay asignaturas en la historia del alumno que la tienen como correlativa
     */
    public void removeAsignaturaAlumno(String legajo, String identificacion)
    throws IdInvalidoException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        Alumno alumno = this.alumnos.get(legajo);
        Iterator<Asignatura> historia = alumno.getHistoriaIterator();
        boolean correlativa = false;
        while (historia.hasNext() && !correlativa)
            correlativa = historia.next().isCorrelativa(identificacion);
        if (correlativa)
            throw new IdInvalidoException(identificacion, "La asignatura no puede ser removida");
        alumno.removeAsignatura(identificacion);
        Iterator<Cursada> cursadas = this.getCursadasIterator();
        while (cursadas.hasNext())
        {
            Cursada cursada = cursadas.next();
            if (cursada.hasAlumno(legajo) && cursada.getAsignatura().getId().equals(identificacion))
                cursada.removeAlumno(legajo);
        }
    }

    /**
     * Agrega una asignatura a las competencias de un profesor
     * <br>
     * <b>Post:</b> la asignatura ha sido agregada a las competencias del profesor
     * @param legajo Legajo del profesor
     * @param identificacion Identificacion de la asignatura
     * @throws IdInvalidoException No existe un profesor con ese legajo 
     * o no existe una asignatura con esa identificacion
     * @throws EntidadInvalidaException La asignatura ya se encuentra en las competencias del profesor
     */
    public void addCompetencia(String legajo, String identificacion)
    throws IdInvalidoException, EntidadInvalidaException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        this.profesores.get(legajo).addCompetencia(this.asignaturas.get(identificacion));
    }

    /**
     * Elimina una asignatura de las competencias de un profesor
     * <br>
     * <b>Post:</b> la asignatura ha sido eliminada de las competencias del profesor
     * @param legajo Legajo del profesor
     * @param identificacion Identificacion de la asignatura
     * @throws IdInvalidoException No existe un profesor con ese legajo, 
     * no existe una asignatura con esa identificacion 
     * o la asignatura no se encuentra en las competencias del profesor
     */
    public void removeCompetencia(String legajo, String identificacion)
    throws IdInvalidoException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        if (!this.asignaturas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La asignatura ingresada no existe");
        this.profesores.get(legajo).removeCompetencia(identificacion);
        Iterator<Cursada> cursadas = this.getCursadasIterator();
        while (cursadas.hasNext())
        {
            Cursada cursada = cursadas.next();
            if (cursada.hasProfesor(legajo) && cursada.getAsignatura().getId().equals(identificacion))
                cursada.removeProfesor(legajo);
        }
    }

    /**
     * Agrega una correlativa a una asignatura
     * <br>
     * <b>Post:</b> la correlativa ha sido agregada a la asignatura
     * @param idAsignatura Identificacion de la asignatura
     * @param idCorrelativa Identificacion de la correlativa
     * @throws IdInvalidoException No existe una asignatura con alguna de las identificaciones
     * @throws EntidadInvalidaException La asignatura ya posee la correlativa
     */
    public void addCorrelativa(String idAsignatura, String idCorrelativa)
    throws IdInvalidoException, EntidadInvalidaException
    {
        if (!this.asignaturas.containsKey(idAsignatura))
            throw new IdInvalidoException(idAsignatura, "La asignatura ingresada no existe");
        if (!this.asignaturas.containsKey(idCorrelativa))
            throw new IdInvalidoException(idCorrelativa, "La correlativa ingresada no existe");
        this.asignaturas.get(idAsignatura).addCorrelativa(this.asignaturas.get(idCorrelativa));
    }

    /**
     * Elimina una correlativa de una asignatura
     * <br>
     * <b>Post:</b> la correlativa ha sido eliminada de la asignatura
     * @param idAsignatura Identificacion de la asignatura
     * @param idCorrelativa Identificacion de la correlativa
     * @throws IdInvalidoException No existe una asignatura con alguna de las identificaciones 
     * o la asignatura no posee la correlativa
     */
    public void removeCorrelativa(String idAsignatura, String idCorrelativa)
    throws IdInvalidoException
    {
        if (!this.asignaturas.containsKey(idAsignatura))
            throw new IdInvalidoException(idAsignatura, "La asignatura ingresada no existe");
        if (!this.asignaturas.containsKey(idCorrelativa))
            throw new IdInvalidoException(idCorrelativa, "La correlativa ingresada no existe");
        this.asignaturas.get(idAsignatura).removeCorrelativa(idCorrelativa);
    }

    /**
     * Verifica si un alumno esta disponible en un determinado horario de cursada
     * <br>
     * <b>Pre:</b> cursada y legajo son validos
     * @param legajo Legajo del alumno
     * @param cursada Cursada a la cual se pretende agregar al alumno
     * @return true si el alumno esta disponible en ese horario, false en caso contrario
     */
    private boolean compatibilidadHorariaAlumno(String legajo, Cursada cursada)
    {
        return this.compatibilidadHorariaAlumno(legajo, cursada.getPeriodo(), cursada.getDia(),
                                                cursada.getHoraInicio(), cursada.getHoraFin());
    }
    
    /**
     * Verifica si un profesor esta disponible en un determinado horario de cursada
     * <br>
     * <b>Pre:</b> cursada y legajo son validos
     * @param legajo Legajo del profesor
     * @param cursada Cursada a la cual se pretende agregar al profesor
     * @return true si el profesor esta disponible en ese horario, false en caso contrario
     */
    private boolean compatibilidadHorariaProfesor(String legajo, Cursada cursada)
    {
        return this.compatibilidadHorariaProfesor(legajo, cursada.getPeriodo(), cursada.getDia(),
                                                  cursada.getHoraInicio(), cursada.getHoraFin());
    }

    /**
     * Verifica si un alumno esta disponible en un determinado horario de cursada
     * <br>
     * <b>Pre:</b> periodo, dia, horaInicio y horaFin son validos
     * @param legajo Legajo del alumno
     * @param periodo Periodo de la cursada
     * @param dia Dia de la cursada
     * @param horaInicio Hora de inicio de la cursada
     * @param horaFin Hora de finalizacion de la cursada
     * @return true si el alumno esta disponible en ese horario, false en caso contrario
     */
    private boolean compatibilidadHorariaAlumno(String legajo, String periodo, String dia, String horaInicio, String horaFin)
    {
        Iterator<Cursada> cursadas = this.getCursadasIterator();
        boolean retorno = true;
        while (retorno && cursadas.hasNext())
        {
            Cursada cursada = cursadas.next();
            retorno = !cursada.hasAlumno(legajo) || cursada.isCompatible(periodo, dia, horaInicio, horaFin);
        }
        return retorno;
    }
    
    /**
     * Verifica si un profesor esta disponible en un determinado horario
     * <br>
     * <b>Pre:</b> periodo, dia, horaInicio y horaFin son validos
     * @param legajo Legajo del profesor
     * @param periodo Periodo de la cursada
     * @param dia Dia de la cursada
     * @param horaInicio Hora de inicio de la cursada
     * @param horaFin Hora de finalizacion de la cursada
     * @return true si el profesor esta disponible en ese horario, false en caso contrario
     */
    private boolean compatibilidadHorariaProfesor(String legajo, String periodo, String dia, String horaInicio, String horaFin)
    {
        Iterator<Cursada> cursadas = this.getCursadasIterator();
        boolean retorno = true;
        while (retorno && cursadas.hasNext())
        {
            Cursada cursada = cursadas.next();
            retorno = !cursada.hasProfesor(legajo) || cursada.isCompatible(periodo, dia, horaInicio, horaFin);
        }
        return retorno;
    }

    /**
     * Agrega un alumno a una cursada
     * <br>
     * <b>Post:</b> el alumno ha sido agregado a la cursada
     * @param legajo Legajo del alumno
     * @param identificacion Identificacion de la cursada
     * @throws IdInvalidoException No existe un alumno con ese legajo 
     * o no existe una cursada con esa identificacion
     * @throws EntidadInvalidaException El alumno ya ha aprobado la asignatura o no esta habilitado a cursarla
     * @throws HorarioNoViableException El alumno no puede cursar en ese horario
     */
    public void addAlumnoCursada(String legajo, String identificacion)
    throws IdInvalidoException, EntidadInvalidaException, HorarioNoViableException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        Cursada cursada = this.cursadas.get(identificacion);
        Alumno alumno = this.alumnos.get(legajo);
        if (!this.compatibilidadHorariaAlumno(legajo, cursada))
            throw new HorarioNoViableException(alumno, cursada, "El alumno no puede cursar en ese horario");
        cursada.addAlumno(alumno);
    }

    /**
     * Elimina a un alumno de una cursada
     * <br>
     * <b>Post:</b> el alumno ha sido eliminado de la cursada
     * @param legajo Legajo del alumno
     * @param identificacion Identificacion de la cursada
     * @throws IdInvalidoException No existe un alumno con ese legajo, 
     * no existe una cursada con esa identificacion 
     * o el alumno no esta en la cursada
     */
    public void removeAlumnoCursada(String legajo, String identificacion)
    throws IdInvalidoException
    {
        if (!this.alumnos.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El alumno ingresado no existe");
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        this.cursadas.get(identificacion).removeAlumno(legajo);
    }

    /**
     * Agrega un profesor a una cursada
     * <br>
     * <b>Post:</b> el profesor ha sido agregado a la cursada
     * @param legajo Legajo del profesor
     * @param identificacion Identificacion de la cursada
     * @throws IdInvalidoException No existe un profesor con ese legajo 
     * o no existe una cursada con esa identificacion
     * @throws EntidadInvalidaException El profesor no es competente para la asignatura
     * @throws HorarioNoViableException El profesor no puede dar clases en ese horario
     */
    public void addProfesorCursada(String legajo, String identificacion)
    throws IdInvalidoException, EntidadInvalidaException, HorarioNoViableException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        Cursada cursada = this.cursadas.get(identificacion);
        Profesor profesor = this.profesores.get(legajo);
        if (!this.compatibilidadHorariaProfesor(legajo, this.cursadas.get(identificacion)))
            throw new HorarioNoViableException(profesor, cursada, "El profesor no puede dar clases en ese horario");
        this.cursadas.get(identificacion).addProfesor(this.profesores.get(legajo));
    }

    /**
     * Elimina un profesor de una cursada
     * <br>
     * <b>Post:</b> el profesor ha sido eliminado de la cursada
     * @param legajo Legajo del profesor
     * @param identificacion Identificacion de la cursada
     * @throws IdInvalidoException No existe un profesor con ese legajo, 
     * no existe una cursada con esa identificacion 
     * o el profesor no esta en la cursada
     */
    public void removeProfesorCursada(String legajo, String identificacion)
    throws IdInvalidoException
    {
        if (!this.profesores.containsKey(legajo))
            throw new IdInvalidoException(legajo, "El profesor ingresado no existe");
        if (!this.cursadas.containsKey(identificacion))
            throw new IdInvalidoException(identificacion, "La cursada ingresada no existe");
        this.cursadas.get(identificacion).removeProfesor(legajo);
    }

    public Iterator<Alumno> getAlumnosIterator()
    {
        return this.alumnos.values().iterator();
    }
    
    public Iterator<Profesor> getProfesoresIterator()
    {
        return this.profesores.values().iterator();
    }
    
    public Iterator<Asignatura> getAsignaturasIterator()
    {
        return this.asignaturas.values().iterator();
    }
    
    public Iterator<Cursada> getCursadasIterator()
    {
        return this.cursadas.values().iterator();
    }

/*...................................................Getters y setters..................................................
.............................................Necesarios para serializar en XML........................................*/

    public void setAlumnos(TreeMap<String, Alumno> alumnos)
    {
        this.alumnos = alumnos;
    }

    public TreeMap<String, Alumno> getAlumnos()
    {
        return this.alumnos;
    }

    public void setProfesores(TreeMap<String, Profesor> profesores)
    {
        this.profesores = profesores;
    }

    public TreeMap<String, Profesor> getProfesores()
    {
        return this.profesores;
    }

    public void setAsignaturas(TreeMap<String, Asignatura> asignaturas)
    {
        this.asignaturas = asignaturas;
    }

    public TreeMap<String, Asignatura> getAsignaturas()
    {
        return this.asignaturas;
    }

    public void setCursadas(TreeMap<String, Cursada> cursadas)
    {
        this.cursadas = cursadas;
    }

    public TreeMap<String, Cursada> getCursadas()
    {
        return this.cursadas;
    }

}
