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
    private ObserverTreeMap<Asignatura> competencia;

    public Profesor(String apellido, String nombre, String calle, int numero, String telefono, String email) throws EmailInvalidoException
    {
        this.modificar(apellido, nombre, calle, numero, telefono, email);
        this.legajo = Mascaras.genId(sigLegajo++, prefijo);
        this.competencia = new ObserverTreeMap<Asignatura>();
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
        if (!(apellido == null? other.apellido == null: apellido.equals(other.apellido)))
        {
            return false;
        }
        if (!(nombre == null? other.nombre == null: nombre.equals(other.nombre)))
        {
            return false;
        }
        if (!(domicilio == null? other.domicilio == null: domicilio.equals(other.domicilio)))
        {
            return false;
        }
        if (!(telefono == null? other.telefono == null: telefono.equals(other.telefono)))
        {
            return false;
        }
        if (!(email == null? other.email == null: email.equals(other.email)))
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
        result = PRIME * result + ((apellido == null)? 0: apellido.hashCode());
        result = PRIME * result + ((nombre == null)? 0: nombre.hashCode());
        result = PRIME * result + ((domicilio == null)? 0: domicilio.hashCode());
        result = PRIME * result + ((telefono == null)? 0: telefono.hashCode());
        result = PRIME * result + ((email == null)? 0: email.hashCode());
        return result;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getNombre() {
        return this.nombre;
    }
}
