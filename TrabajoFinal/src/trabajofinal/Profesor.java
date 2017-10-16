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

    public Profesor(String apellido, String nombre, Domicilio domicilio, String telefono, String email) throws EmailInvalidoException
    {
        if (Mascaras.emailValido(email))
            this.email = email;
        else
            throw new EmailInvalidoException(email);
        this.legajo = Mascaras.genId(sigLegajo++, prefijo);
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.competencia = new ObserverTreeMap<Asignatura>();
    }

    @Override
    public String getId()
    {
        return legajo;
    }
    
    public boolean equals (Object obj) {
        Profesor pro= (Profesor) obj;
        if (this.nombre==pro.nombre && this.apellido==pro.apellido && this.email==pro.email && this.domicilio.getCalle()==pro.domicilio.getCalle() && this.domicilio.getNumero()==pro.domicilio.getNumero() && this.telefono== pro.telefono)
            return true;     
        else       
            return false;
    }

}
