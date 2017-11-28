package view;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import model.Serializador;

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
    public void windowClosing(WindowEvent windowEvent)
    {
        try
        {
            Serializador.serializar();
        }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "ERROR: Los cambios no se han guardado");
        }
    }
    
}
