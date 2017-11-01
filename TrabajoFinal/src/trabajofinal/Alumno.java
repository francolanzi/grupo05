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

    public Alumno(String apellido, String nombre, String calle, int numero, String telefono, String email) throws EmailInvalidoException
    {
        this.modificar(apellido, nombre, calle, numero, telefono, email);
        this.legajo = Mascaras.genId(sigLegajo++, PREFIJO);
        this.historia = new ObserverTreeMap<Asignatura>();
    }

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
    
    //Constructor vacío, getters y setters
    //Necesarios para serializar en XML
    
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
