package trabajofinal;

import java.util.TreeMap;

public class Profesor
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

    public Profesor(String apellido, String nombre, Domicilio domicilio, String telefono, String email)
    {
        this.legajo = Identificador.genIdentificador(sigLegajo++, prefijo);
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.competencia = new ObserverTreeMap<Asignatura>();
    }

}
