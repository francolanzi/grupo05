package trabajofinal;

import java.util.Iterator;

public class Alumno implements Entidad
{
    
    private static int sigLegajo = 0;
    public static final String PREFIJO = "ALU";
    
    private String legajo;
    private String apellido;
    private String nombre;
    private Domicilio domicilio;
    private String telefono;
    private String email;
    private ObserverTreeMap<Asignatura> historia;

    /**
     * Constructor de la clase Alumno
     * <br>
     * <b>Pre:</b> apellido, nombre, calle, numero y telefono son validos
     * <br>
     * <b>Post:</b> se ha creado un nuevo alumno con un nuevo legajo unico
     * @param apellido Apellido del alumno
     * @param nombre Nombre del alumno
     * @param calle Calle de la direccion del alumno
     * @param numero Numero de la direccion del alumno
     * @param telefono Telefono del alumno
     * @param email Email del alumno
     * @throws EmailInvalidoException El email no cumple con la mascara AAAAAA@AAAAAA
     */
    public Alumno(String apellido, String nombre, String calle, int numero, String telefono, String email) throws EmailInvalidoException
    {
        this.modificar(apellido, nombre, calle, numero, telefono, email);
        this.legajo = Mascaras.genId(sigLegajo++, PREFIJO);
        this.historia = new ObserverTreeMap<Asignatura>();
    }
    
    //...........................................INSPECCION...........................................
    //La verificacion del email se realiza dentro de la clase para asegurar la integridad de la misma

    /**
     * Modifica los atributos de alumno
     * <br>
     * <b>Pre:</b> apellido, nombre, calle, numero y telefono son validos
     * <br>
     * <b>Post:</b> los atributos del alumno han sido modificados
     * @param apellido Apellido del alumno
     * @param nombre Nombre del alumno
     * @param calle Calle de la direccion del alumno
     * @param numero Numero de la direccion del alumno
     * @param telefono Telefono del alumno
     * @param email Email del alumno
     * @throws EmailInvalidoException El email no cumple con la mascara AAAAAA@AAAAAA
     */
    public void modificar(String apellido, String nombre, String calle, int numero, String telefono, String email) throws EmailInvalidoException
    {
        if (!Mascaras.emailValido(email))
            throw new EmailInvalidoException(email, "El email ingresado es invalido");
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = new Domicilio(calle, numero);
        this.telefono = telefono;
        this.email = email;
    }
    
    @Override
    public String getId()
    {
        return this.legajo;
    }

    /**
     * Agrega una asignatura a la historia del alumno
     * <br>
     * <b>Pre:</b> la asignatura es valida
     * <br>
     * <b>Post:</b> la asignatura ha sido agregada a la historia del alumno
     * @param asignatura Asignatura a agregar
     * @throws EntidadInvalidaException La asignatura ya se encuentra en la historia del alumno
     */
    public void aprobarAsignatura(Asignatura asignatura) throws EntidadInvalidaException
    {
        try
        {
            this.historia.add(asignatura);
        }
        catch (EntidadInvalidaException e)
        {
            throw new EntidadInvalidaException(e.getEntidad(), "El alumno ya ha aprobado la asignatura");
        }
    }

    /**
     * Elimina una asignatura de la historia del alumno
     * <br>
     * <b>Post:</b> la asignatura ha sido eliminada de la historia del alumno
     * @param identificacion Identificacion de la asignatura a eliminar
     * @throws IdInvalidoException La asignatura no se encuentra en la historia del alumno
     */
    public void removeAsignatura(String identificacion) throws IdInvalidoException
    {
        try
        {
            this.historia.remove(identificacion);
        }
        catch (IdInvalidoException e)
        {
            throw new IdInvalidoException(e.getId(), "El alumno no posee aprobada la asignatura");
        }
    }

    /**
     * Verifica si una asignatura esta en la historia del alumno
     * @param identificacion Identificacion de la asignatura a verificar
     * @return true si la asignatura ha sido aprobada, false en caso contrario
     */
    public boolean isAprobada(String identificacion)
    {
        return this.historia.contains(identificacion);
    }

    public Iterator<Asignatura> getHistoriaIterator()
    {
        return this.historia.getIterator();
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Alumno))
        {
            return false;
        }
        final Alumno other = (Alumno) object;
        if (!(legajo == null? other.legajo == null: legajo.equals(other.legajo)))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((legajo == null)? 0: legajo.hashCode());
        return result;
    }
    
/*.........................................Constructor vacío, getters y setters.........................................
.............................................Necesarios para serializar en XML........................................*/
    
    public Alumno(){}

    public static void setSigLegajo(int sigLegajo)
    {
        Alumno.sigLegajo = sigLegajo;
    }

    public static int getSigLegajo()
    {
        return Alumno.sigLegajo;
    }

    public void setLegajo(String legajo)
    {
        this.legajo = legajo;
    }
    
    public String getLegajo()
    {
        return this.legajo;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public String getApellido()
    {
        return this.apellido;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public void setDomicilio(Domicilio domicilio)
    {
        this.domicilio = domicilio;
    }

    public Domicilio getDomicilio()
    {
        return this.domicilio;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getTelefono()
    {
        return this.telefono;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setHistoria(ObserverTreeMap<Asignatura> historia)
    {
        this.historia = historia;
    }

    public ObserverTreeMap<Asignatura> getHistoria()
    {
        return this.historia;
    }
    
}
