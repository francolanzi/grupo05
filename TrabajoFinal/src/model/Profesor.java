package model;

import java.util.Iterator;

public class Profesor implements Entidad
{
    
    private static int sigLegajo = 0;
    public static final String PREFIJO = "PRO";
    
    private String legajo;
    private String apellido;
    private String nombre;
    private Domicilio domicilio;
    private String telefono;
    private String email;
    private ObserverTreeMap<Asignatura> competencias;

    /**
     * Constructor de la clase Profesor
     * <br>
     * <b>Pre:</b> apellido, nombre, calle, numero y telefono son validos
     * <br>
     * <b>Post:</b> se ha creado un nuevo profesor con un legajo unico
     * @param apellido Apellido del profesor
     * @param nombre Nombre del profesor
     * @param calle Calle del domicilio del profesor
     * @param numero Numero del domicilio del profesor
     * @param telefono Telefono del profesor
     * @param email Email del profesor
     * @throws model.EmailInvalidoException El email no cumple con la mascara AAAAAA@AAAAAA
     */
    public Profesor(String apellido, String nombre, String calle, int numero, String telefono, String email)
    throws EmailInvalidoException
    {
        this.modificar(apellido, nombre, calle, numero, telefono, email);
        this.legajo = Mascaras.genId(sigLegajo++, PREFIJO);
        this.competencias = new ObserverTreeMap<Asignatura>();
    }
    
    //...........................................INSPECCION...........................................
    //La verificacion del email se realiza dentro de la clase para asegurar la integridad de la misma

    /**
     * Modifica los atributos del profesor
     * <br>
     * <b>Pre:</b> apellido, nombre, calle, numero y telefono son validos
     * <br>
     * <b>Post:</b> los atributos del profesor han sido modificados
     * @param apellido Apellido del profesor
     * @param nombre Nombre del profesor
     * @param calle Calle del domicilio del profesor
     * @param numero Numero del domicilio del profesor
     * @param telefono Telefono del profesor
     * @param email Email del profesor
     * @throws model.EmailInvalidoException El email no cumple con la mascara AAAAAA@AAAAAA
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
        return legajo;
    }

    /**
     * Agrega una asignatura a las competencias al profesor
     * <br>
     * <b>Pre:</b> la asignatura es valida
     * <br>
     * <b>Post:</b> la asignatura ha sido agregada a las competencias del profesor
     * @param competencia Asignatura a agregar
     * @throws model.EntidadInvalidaException La asignatura ya se encuentra en las competencias del profesor
     */
    public void addCompetencia(Asignatura competencia)
    throws EntidadInvalidaException
    {
        try
        {
            this.competencias.add(competencia);
        }
        catch (EntidadInvalidaException e)
        {
            throw new EntidadInvalidaException(e.getEntidad(), "El profesor ya posee la competencia");
        }
    }
    
    /**
     * Elimina una asignatura de las competencias del profesor
     * <br>
     * <b>Post:</b> la asignatura ha sido eliminada de las competencias del profesor
     * @param identificacion Identificacion de la asignatura a eliminar
     * @throws model.IdInvalidoException La asignatura no se encuentra en las competencias del profesor
     */
    public void removeCompetencia(String identificacion)
    throws IdInvalidoException
    {
        try
        {
            this.competencias.remove(identificacion);
        }
        catch (IdInvalidoException e)
        {
            throw new IdInvalidoException(e.getId(), "El profesor no posee la competencia");
        }
    }

    /**
     * Verifica si una asignatura esta en las competencias del profesor
     * @param identificacion Identificacion de la asignatura a verificar
     * @return true si el profesor es competente, false en caso contrario
     */
    public boolean isCompetente(String identificacion)
    {
        return this.competencias.contains(identificacion);
    }

    public Iterator<Asignatura> getCompetenciasIterator()
    {
        return this.competencias.getIterator();
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Profesor))
        {
            return false;
        }
        final Profesor other = (Profesor) object;
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
    
    public Profesor(){}

    public static void setSigLegajo(int sigLegajo)
    {
        Profesor.sigLegajo = sigLegajo;
    }

    public static int getSigLegajo()
    {
        return Profesor.sigLegajo;
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

    public void setCompetencias(ObserverTreeMap<Asignatura> competencias)
    {
        this.competencias = competencias;
    }

    public ObserverTreeMap<Asignatura> getCompetencias()
    {
        return this.competencias;
    }

}
