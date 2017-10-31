package GUI;

import java.awt.event.WindowAdapter;

import trabajofinal.Controlador;
import trabajofinal.Serializador;

public class WindowSerializador extends WindowAdapter
{
    
    private static WindowSerializador serializador = null;
    
    private WindowSerializador(){}
    
    public static WindowSerializador getInstance()
    {
        if (serializador == null)
            serializador = new WindowSerializador();
        return serializador;
    }
    
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        Serializador.serializar();
    }
    
}
