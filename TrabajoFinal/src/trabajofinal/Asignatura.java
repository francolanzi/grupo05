package trabajofinal;

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
    
    public void addCorrelativa(Asignatura correlativa) throws EntidadExistenteException
    {
        this.correlativas.add(correlativa);
    }
    
    public void removeCorrelativa(String identificacion) throws IdNoExistenteException
    {
        this.correlativas.remove(identificacion);
    }

    @Override
    public String getId()
    {
        return identificacion;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
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
        if (!(nombre == null? other.nombre == null: nombre.equals(other.nombre)))
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
        result = PRIME * result + ((nombre == null)? 0: nombre.hashCode());
        return result;
    }

    public String getNombre() {
        return this.nombre;
    }

}
