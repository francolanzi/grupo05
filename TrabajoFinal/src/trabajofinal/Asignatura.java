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

    public String getIdentificacion() {
        return identificacion;
    }
    
    public boolean equals (Object obj) {
        Asignatura asi= (Asignatura) obj;
        if (this.nombre==asi.nombre)
            return true;     
        else       
            return false;
    }
}
