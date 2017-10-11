package trabajofinal;

import java.util.TreeMap;

public class Asignatura
{
    
    private static int sigIdentificacion = 0;
    private static final String prefijo = "ASI";
    
    private String identificacion;
    private String nombre;
    private ObserverTreeMap<Asignatura> correlatividades;

    public Asignatura(String nombre)
    {
        this.identificacion = Identificador.genIdentificador(sigIdentificacion++, prefijo);
        this.nombre = nombre;
        this.correlatividades = new ObserverTreeMap<Asignatura>();
    }
    
}
