package trabajofinal;

import java.util.Iterator;
import java.util.TreeMap;

public class Asignatura implements Entidad
{
    
    private static int sigIdentificacion = 0;
    public static final String PREFIJO = "ASI";
    
    private String identificacion;
    private String nombre;
    private ObserverTreeMap<Asignatura> correlativas;

    /**
     * Constructor de la clase Asignatura
     * <br>
     * <b>Pre:</b> el nombre es valido
     * <b>Post:</b> se ha creado una nueva asignatura con una nueva identificacion unica
     * @param nombre Nombre de la asignatura
     */
    public Asignatura(String nombre)
    {
        this.identificacion = Mascaras.genId(sigIdentificacion++, PREFIJO);
        this.setNombre(nombre);
        this.correlativas = new ObserverTreeMap<Asignatura>();
    }
    
    @Override
    public String getId()
    {
        return identificacion;
    }

    /**
     * Agrega una correlativa a la asignatura
     * <b>Pre:</b> la correlativa es valida
     * <br>
     * <b>Post:</b> la correlativa ha sido agregada a la asignatura
     * @param correlativa Asignatura a agregar como correlativa
     * @throws EntidadInvalidaException La asignatura ya posee la correlativa
     */
    public void addCorrelativa(Asignatura correlativa) throws EntidadInvalidaException
    {
        try
        {
            this.correlativas.add(correlativa);
        }
        catch (EntidadInvalidaException e)
        {
            throw new EntidadInvalidaException(e.getEntidad(), "La asignatura ya posee la correlativa");
        }
    }

    /**
     * Elimina una correlativa de la asignatura
     * <br>
     * <b>Post:</b> la correlativa ha sido eliminada de la asignatura
     * @param identificacion Identificacion de la correlativa a eliminar
     * @throws IdInvalidoException La asignatura no posee la correlativa
     */
    public void removeCorrelativa(String identificacion)
    throws IdInvalidoException
    {
        try
        {
            this.correlativas.remove(identificacion);
        }
        catch (IdInvalidoException e)
        {
            throw new IdInvalidoException(e.getId(), "La asignatura no posee la correlativa");
        }
    }

    /**
     * Verifica si una asignatura es correlativa de esta
     * @param identificacion Identificacion de la correlativa
     * @return true si la asignatura es correlativa, false en caso contrario
     */
    public boolean isCorrelativa(String identificacion)
    {
        return this.correlativas.contains(identificacion);
    }

    public Iterator<Asignatura> getCorrelativasIterator()
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
    
/*.........................................Constructor vacío, getters y setters.........................................
.............................................Necesarios para serializar en XML........................................*/
    
    public Asignatura(){}

    public static void setSigIdentificacion(int sigIdentificacion)
    {
        Asignatura.sigIdentificacion = sigIdentificacion;
    }

    public static int getSigIdentificacion()
    {
        return Asignatura.sigIdentificacion;
    }

    public void setIdentificacion(String identificacion)
    {
        this.identificacion = identificacion;
    }
    
    public String getIdentificacion()
    {
        return this.identificacion;
    }
    
    public String getNombre()
    {
        return this.nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setCorrelativas(ObserverTreeMap<Asignatura> correlativas)
    {
        this.correlativas = correlativas;
    }

    public ObserverTreeMap<Asignatura> getCorrelativas()
    {
        return this.correlativas;
    }

}
