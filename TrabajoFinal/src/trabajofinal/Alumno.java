    package trabajofinal;

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

    public Alumno(String apellido, String nombre, Domicilio domicilio, String email) throws EmailInvalidoException
    {
        if (Mascaras.emailValido(email))
            this.email = email;
        else
            throw new EmailInvalidoException(email);
        this.legajo = Mascaras.genId(sigLegajo++, prefijo);
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.historia = new ObserverTreeMap<Asignatura>();
    }

    @Override
    public String getId()
    {
        return legajo;
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
        result = PRIME * result + ((email == null)? 0: email.hashCode());
        return result;
    }


}
