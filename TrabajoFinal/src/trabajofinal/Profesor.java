package trabajofinal;

import java.util.TreeMap;

public class Profesor implements Entidad
{
    
    private static int sigLegajo = 0;
    private static final String prefijo = "PRO";
    
    private String legajo;
    private String apellido;
    private String nombre;
    private Domicilio domicilio;
    private String telefono;
    private String email;
    private ObserverTreeMap<Asignatura> competencias;

    public Profesor(String apellido, String nombre, String calle, int numero, String telefono, String email) throws EmailInvalidoException
    {
        this.modificar(apellido, nombre, calle, numero, telefono, email);
        this.legajo = Mascaras.genId(sigLegajo++, prefijo);
        this.competencias = new ObserverTreeMap<Asignatura>();
    }
    
    public void addCompetencia(Asignatura competencia) throws EntidadExistenteException
    {
        this.competencias.add(competencia);
    }
    
    public void removeCompetencia(String identificacion) throws IdNoExistenteException
    {
        this.competencias.remove(identificacion);
    }

    @Override
    public String getId()
    {
        return legajo;
    }
    
    public void modificar(String apellido, String nombre, String calle, int numero, String telefono, String email) throws EmailInvalidoException
    {
        if (!Mascaras.emailValido(email))
            throw new EmailInvalidoException(email);
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

    public String getApellido() {
        return this.apellido;
    }

    public String getNombre() {
        return this.nombre;
    }
}
