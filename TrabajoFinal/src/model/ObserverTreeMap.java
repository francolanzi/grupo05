package model;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

public class ObserverTreeMap<T extends Entidad> implements Observer
{
    
    private TreeMap<String, T> coleccion;

    /**
     * Constructor de la clase ObserverTreeMap
     * <br>
     * La clase lanza las excepciones propias del sistema
     * <br>
     * Cuando el Observador elimina una Entidad, tambien se elimina de esta coleccion
     * <br>
     * <b>Post:</b> se ha creado un nuevo ObserverTreeMap vacio
     */
    public ObserverTreeMap()
    {
        this.coleccion = new TreeMap<String, T>();
        Controlador.getInstance().addObserver(this);
    }

    /**
     * Agrega un elemento a la coleccion
     * <br>
     * <b>Pre:</b> el elemento es valido
     * <br>
     * <b>Post:</b> se ha agregado el elemento a la coleccion
     * @param elemento Elemento a agregar
     * @throws model.EntidadInvalidaException El elemento ya se encuentra en la coleccion
     */
    public void add(T elemento) throws EntidadInvalidaException
    {
        if (this.coleccion.containsValue(elemento))
            throw new EntidadInvalidaException(elemento);
        this.coleccion.put(elemento.getId(), elemento);
    }

    /**
     * Obtiene un elemento de la coleccion
     * @param id Id del elemento a retornar
     * @return Elemento con el id solicitado
     * @throws model.IdInvalidoException No hay un elemento con ese id en la coleccion
     */
    public T get(String id) throws IdInvalidoException
    {
        if (!this.coleccion.containsKey(id))
            throw new IdInvalidoException(id);
        return this.coleccion.get(id);
    }

    /**
     * Elimina un elemento de la coleccion
     * @param id Id del elemento a eliminar
     * @return Elemento eliminado de la coleccion
     * @throws model.IdInvalidoException El elemento no esta en la coleccion
     */
    public T remove(String id) throws IdInvalidoException
    {
        if (!this.coleccion.containsKey(id))
            throw new IdInvalidoException(id);
        return this.coleccion.remove(id);
    }

    /**
     * Obtiene los elementos de la coleccion
     * @return Iterator de los elementos de la coleccion
     */
    public Iterator<T> getIterator()
    {
        return this.coleccion.values().iterator();
    }

    /**
     * Verifica si un elemento pertenece a la coleccion
     * @param id Id del elemento
     * @return true si el elemento pertenece a la coleccion, false en caso contrario
     */
    public boolean contains(String id)
    {
        return this.coleccion.containsKey(id);
    }

    @Override
    public void update(Observable observable, Object object)
    {
        if (observable == Controlador.getInstance())
        {
            String id = (String) object;
            this.coleccion.remove(id);
        }
    }
    
/*...................................................Getters y setters..................................................
.............................................Necesarios para serializar en XML........................................*/

    public void setColeccion(TreeMap<String, T> coleccion)
    {
        this.coleccion = coleccion;
    }

    public TreeMap<String, T> getColeccion()
    {
        return this.coleccion;
    }

}
