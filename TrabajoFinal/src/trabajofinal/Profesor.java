package trabajofinal;

import java.util.Iterator;
import java.util.TreeMap;

public class Profesor implements Entidad
{
    
    private static int sigLegajo = 0;
    public static final String prefijo = "PRO";
    
    private String legajo;
    private String apellido;
    private String nombre;
    private Domicilio domicilio;
    private String telefono;
    private String email;
    private ObserverTreeMap<Asignatura> competencias;

    public Profesor(String apellido, String nombre, String calle, int numero, String telefono, String email)
    throws EmailInvalidoException
    {
        this.modificar(apellido, nombre, calle, numero, telefono, email);
        this.legajo = Mascaras.genId(sigLegajo++, prefijo);
        this.competencias = new ObserverTreeMap<Asignatura>();
    }
    
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

    @Override
    public String getId()
    {
        return legajo;
    }
    
    public boolean isCompetente(String identificacion)
    {
        return this.competencias.contains(identificacion);
    }
    
    public Iterator<Asignatura> getCompetenciasIterator()
    {
        return this.competencias.getIterator();
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
