    package trabajofinal;

import java.util.Iterator;
import java.util.TreeMap;

public class Alumno implements Entidad
{
    
    private static int sigLegajo = 0;
    private static final String prefijo = "ALU";
    
    private String legajo;
    private String apellido;
    private String nombre;
    private Domicilio domicilio;
    private String email;
    private ObserverTreeMap<Asignatura> historia;

    public Alumno(String apellido, String nombre, String calle, int numero, String email) throws EmailInvalidoException
    {
        this.modificar(apellido, nombre, calle, numero, email);
        this.legajo = Mascaras.genId(sigLegajo++, prefijo);
        this.historia = new ObserverTreeMap<Asignatura>();
    }
    
    public String getApellido() {
        return this.apellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getId()
    {
        return legajo;
    }
    
    public Iterator<Asignatura> getHistoria()
    {
        return this.historia.getIterator();
    }

    public void modificar(String apellido, String nombre, String calle, int numero, String email) throws EmailInvalidoException
    {
        if (!Mascaras.emailValido(email))
            throw new EmailInvalidoException(email);
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = new Domicilio(calle, numero);
        this.email = email;
    }
    
    public void aprobarAsignatura(Asignatura asignatura) throws EntidadExistenteException
    {
        this.historia.add(asignatura);
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
    
}
