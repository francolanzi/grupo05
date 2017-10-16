package trabajofinal;

import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

public class ObserverTreeMap<T> implements Observer
{
    
    private TreeMap<String, T> coleccion;
    
    public ObserverTreeMap()
    {
        this.coleccion = new TreeMap<String, T>();
        Controlador.getInstance().addObserver(this);
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
