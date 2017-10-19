package trabajofinal;

import java.util.Iterator;
import java.util.TreeMap;

public class Asignatura implements Entidad
{
    
    private static int sigIdentificacion = 0;
    private static final String prefijo = "ASI";
    
    private String identificacion;
    private String nombre;
    private ObserverTreeMap<Asignatura> correlativas;

    public Asignatura(String nombre)
    {
        this.identificacion = Mascaras.genId(sigIdentificacion++, prefijo);
        this.setNombre(nombre);
        this.correlativas = new ObserverTreeMap<Asignatura>();
    }
    
    public void addCorrelativa(Asignatura correlativa) throws EntidadInvalidaException
    {
        this.correlativas.add(correlativa);
    }
    
    public void removeCorrelativa(String identificacion) throws IdInvalidoException
    {
        this.correlativas.remove(identificacion);
    }
    
    public boolean isCorrelativa(String identificacion)
    {
        return this.correlativas.contains(identificacion);
    }

    @Override
    public String getId()
    {
        return identificacion;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public Iterator<Asignatura> getCorrelativas()
    {
        return this.correlativas.getIterator();
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Asignatura))
        {
            return false;
        }
        final Asignatura other = (Asignatura) object;
        if (!(identificacion == null? other.identificacion == null: identificacion.equals(other.identificacion)))
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
        result = PRIME * result + ((identificacion == null)? 0: identificacion.hashCode());
        return result;
    }

}
