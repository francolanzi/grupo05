package trabajofinal;

import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

public class ObserverTreeMap<T extends Entidad> implements Observer
{
    
    private TreeMap<String, T> coleccion;
    
    public ObserverTreeMap()
    {
        this.coleccion = new TreeMap<String, T>();
        Controlador.getInstance().addObserver(this);
    }
    
    public void add(T elemento) throws EntidadExistenteException
    {
        if (this.coleccion.containsValue(elemento))
            throw new EntidadExistenteException(elemento);
        this.coleccion.put(elemento.getId(), elemento);
    }
    
    public T get(String id) throws IdNoExistenteException
    {
        if (!this.coleccion.containsKey(id))
            throw new IdNoExistenteException(id);
        return this.coleccion.get(id);
    }
    
    public T remove(String id) throws IdNoExistenteException
    {
        if (!this.coleccion.containsKey(id))
            throw new IdNoExistenteException(id);
        return this.coleccion.remove(id);
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
    
}
